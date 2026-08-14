---
name: new-feature
description: Scaffold a complete new feature end-to-end in this Kotlin Multiplatform app — domain model + repository interface, data repository implementation with a remote (Ktor/PokeAPI) and/or local (SQLDelight) data source, Koin DI wiring, a ViewModel (extends ParentViewModel with a sealed ScreenState), a Compose Screen (koinViewModel injection), and optionally navigation registration (Destinations + NavHost route). Use when the user wants a brand-new screen/capability added to the app, not a change to an existing feature. Produces a compiling skeleton with TODOs for the actual business logic and UI — it does not invent behavior. Chained from /spec-implement when a spec's proposal.md §6 names this skill.
metadata:
  claude_md_requires: '[]'
---

## Usage

```
/new-feature <FeatureName> --data <remote|local|none> [--parent <existing_feature>] [--nav-route <yes|no>]
```

| Arg | Meaning |
|---|---|
| `<FeatureName>` | PascalCase feature identifier, e.g. `Berries`. Drives every generated name (see Naming below). |
| `--data` | `remote` — new Ktor-backed data source against PokeAPI (the common case — almost every feature here is "a new PokeAPI resource list/detail"); `local` — a genuinely new **persisted** SQLDelight table (rare — most features don't need their own table, see `architecture.cache_not_room`); `none` — the feature only reads/writes through **existing** repositories. |
| `--parent` | Optional. An existing feature package to nest under. Most Pokedex features are top-level (`features/pokemon/`, `features/berries/`, `features/items/`, …) with `list`/`detail` sub-packages — check `features/` first for the closest sibling shape before deciding. |
| `--nav-route` | `yes` (default) — add a `Destinations` entry (in `core/ui/components/NavDrawer.kt` — **not** a standalone `Destinations.kt`, unlike some sibling repos) and wire the Screen into the `NavHost`. `no` — the Screen is embedded/opened another way and navigation wiring is skipped. |

When invoked from `/spec-implement`, all args come from the plan.md step's "Skill args / inputs" — this skill does not re-prompt for them. When invoked directly by the user, ask for any argument not supplied (don't guess `--data` or `--parent` silently — the wrong choice means real rework).

## Preconditions

- The target package path does not already exist. If `features/<parent?>/<feature_snake>/` (or a same-name domain/data file) already exists, stop and ask whether this is actually a change to an existing feature instead (wrong skill — just edit directly).
- Per root `CLAUDE.md` Working Rules: **confirm the intended location with the user before creating any file** — state the resolved package path and the full file list (see Output) and wait for explicit approval before writing anything.

## Naming

All names derive from `<FeatureName>` (PascalCase input):

| Placeholder | Derivation | Example (`Berries`) |
|---|---|---|
| `{Feature}` | as given | `Berries` |
| `{feature_snake}` | snake_case | `berries` |
| `{FeatureTable}` | PascalCase, for a new SQLDelight table name (matches the existing `ApiCache` table's PascalCase convention, not SCREAMING_SNAKE_CASE) | `BerriesCache` |

## What this skill does

Generate files in this order — later steps depend on earlier ones existing.

### 1. Domain model (only if the feature needs a new one)

If the feature represents a new concept not already modeled under
`domain/model/` (check first — reuse an existing model when the story
is really "a new view of existing data"), create:

```
domain/model/{Feature}.kt
```

A plain `data class {Feature}(...)` with the fields the story implies.
Ask the user for the field list if it's not obvious from the spec —
don't invent fields.

### 2. Domain repository interface (skip if `--data none`)

```
domain/repository/{Feature}Repository.kt
```

```kotlin
package com.kronos.mutliplatform.pokedex.domain.repository

import com.kronos.mutliplatform.pokedex.domain.model.{Feature}

interface {Feature}Repository {
    suspend fun listAll(): List<{Feature}>
    // TODO: add the operations this feature actually needs
}
```

Keep it narrow (ISP) — only the operations this feature needs, not a
speculative full CRUD set.

### 3a. Remote data source (`--data remote` — the common case)

Follows the existing PokeAPI-backed data source pattern (read a
sibling like `features/berries` or `features/pokemon`'s repository
with Serena first to match the exact shape rather than guessing):

```
data/remote/dto/{feature_snake}/{Feature}Dto.kt              # PokeAPI wire format, @Serializable
data/mapper/{Feature}Mapper.kt                                 # DTO -> domain mapping
data/remote/datasources/{Feature}RemoteDataSource.kt          # interface
data/remote/datasources/{Feature}RemoteDataSourceImpl.kt      # implementation, uses a KtorClientFactory
data/repository/{feature_snake}/{Feature}RepositoryImpl.kt    # implements domain/repository/{Feature}Repository, delegates to the DataSource, returns core/result/Result
```

The DataSourceImpl constructor takes a `KtorClientFactory` (inject via
the qualifier pattern already used in `data/remote/di/Modules.kt` — PokeAPI
is a single public, keyless API, so there's normally only one factory
qualifier in use here, unlike repos that split PUBLIC/PRIVATE clients).

Repository methods return `core/result/Result<D, Error>` (`Success`/
`Error`), never throw.

**Caching note:** per-response caching (`core/cache/ICache` /
`AppCache`, backed by `data/local/database/ApiCache.sq`) is meant to
wrap the remote call generically — check whether the existing cache
plumbing already applies to new PokeAPI calls made through the shared
Ktor client, or whether this feature's data source needs to call
`ICache` explicitly. Don't build a second, feature-specific caching
mechanism.

### 3b. Local data source (`--data local` — rare)

Only for a genuinely new **persisted** concept (e.g. user favorites,
a team builder) — not for caching, which already exists generically
(see 3a). This repo uses **SQLDelight**, not Room:

```
shared/src/commonMain/sqldelight/com/kronos/mutliplatform/pokedex/data/local/database/{Feature}.sq
data/local/datasources/{Feature}LocalDataSource.kt          # interface, wraps the generated Queries object
data/local/datasources/{Feature}LocalDataSourceImpl.kt      # implementation
data/repository/{feature_snake}/{Feature}RepositoryImpl.kt  # implements domain/repository/{Feature}Repository
```

`.sq` file example (mirrors `ApiCache.sq`'s style — raw SQL + named
queries, SQLDelight generates a typed `Queries` class from this, no
separate Entity/Dao/mapper split like Room):

```sql
CREATE TABLE {FeatureTable} (
    id TEXT NOT NULL PRIMARY KEY,
    -- TODO: add columns
);

listAll:
SELECT * FROM {FeatureTable};

upsert:
INSERT OR REPLACE INTO {FeatureTable}(id, /* ... */)
VALUES (?, /* ... */);
```

**SQLDelight vs Room (important, don't apply the wrong mental model):**
a brand-new `.sq` file/table needs **no manual migration** — SQLDelight
creates it as part of normal schema creation. A manual numbered
migration (`.sqm` file) is only needed when **altering** a table that
already shipped to real installs. Do not port a Room-style
"bump version + write CREATE TABLE by hand" step here — that's a
different repo's convention (see the sibling `multiplatform-weather-app`
repo's `/new-feature`, which is Room-based).

### 4. DI wiring

- `--data remote`: add to `data/remote/di/Modules.kt`
  `commonRemoteModules`, following the qualifier pattern already there.
- `--data local`: add to `data/local/di/Modules.kt`
  `commonDataLocalModules`:
  ```kotlin
  single<{Feature}LocalDataSource> { {Feature}LocalDataSourceImpl(get()) }
  single { {Feature}RepositoryImpl(get()) }.bind<{Feature}Repository>()
  ```
- `--data none`: no new repository binding — the ViewModel will inject
  existing repositories directly.
- Always: register the ViewModel in `di/Modules.kt` `viewModelModule`:
  ```kotlin
  viewModelOf(::{Feature}ScreenViewModel)
  ```
  (Note this repo's own naming convention: ViewModels are named
  `{Feature}ScreenViewModel`, e.g. `PokemonListScreenViewModel` — not
  bare `{Feature}ViewModel` — match it.)

Use Serena's `insert_after_symbol`/`replace_content` on these existing
files — do not rewrite them wholesale.

### 5. ViewModel

```
features/{parent?}/{feature_snake}/{Feature}ScreenViewModel.kt
```

```kotlin
class {Feature}ScreenViewModel(
    private val {feature}Repository: {Feature}Repository, // omit if --data none; inject whichever existing repositories the feature actually needs instead
) : ParentViewModel() {

    private val _screenState = MutableStateFlow<{Feature}ScreenState>({Feature}ScreenState.Idle)
    val screenState = _screenState.asStateFlow()

    fun load() {
        viewModelScope.launch(Dispatchers.IO) {
            _screenState.value = {Feature}ScreenState.Loading
            // TODO: call the repository, convert Result into a screen state
        }
    }
}

sealed class {Feature}ScreenState {
    object Idle : {Feature}ScreenState()
    object Loading : {Feature}ScreenState()
    // TODO: add the states this screen actually needs (an Obtained/Error pair at minimum)
}
```

Ask the user what states the screen actually needs beyond
`Idle`/`Loading` — don't guess a state machine for them. Read an
existing sibling ViewModel (e.g. `PokemonListScreenViewModel`,
`BerryListScreenViewModel`) with Serena first to match logging/error
conventions exactly — this repo's `ParentViewModel`/logging shape may
have evolved since this skill was written.

### 6. Screen composable

```
features/{parent?}/{feature_snake}/{Feature}Screen.kt
```

```kotlin
@Composable
fun {Feature}Screen(
    navHost: NavHostController,
    // TODO: add whatever params sibling screens take that this screen actually needs
) {
    val viewModel = koinViewModel<{Feature}ScreenViewModel>()
    val screenState by viewModel.screenState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.load()
    }

    // TODO: render per screenState
}
```

For a larger screen with list + detail, mirror an existing pair like
`features/berries/list` + `features/berries/detail`.

### 7. Navigation (only if `--nav-route yes`)

1. Add an entry to the `Destinations` enum — **located in
   `core/ui/components/NavDrawer.kt`** in this repo, not a standalone
   `Destinations.kt` file:
   ```kotlin
   enum class Destinations {
       POKEDEX, POKEMON_LIST, POKEMON_DETAIL, /* … */, {FEATURE_ENUM}
   }
   ```
2. Add the route to the `NavHost` (find it with Serena — confirm the
   exact host file in this repo before assuming it's `App.kt`, since
   this repo's structure differs from sibling repos):
   ```kotlin
   composable(route = Destinations.{FEATURE_ENUM}.name) {
       {Feature}Screen(navController, /* TODO: params */)
   }
   ```
   Use Serena's `insert_after_symbol`/`replace_content` — don't rewrite
   the host file wholesale.

If `--nav-route no`, skip this step and note in the output summary how
the caller is expected to reach the new Screen (embedded, dialog, etc.)
— that wiring is the caller's responsibility, not this skill's.

### 8. Localization stub

Add placeholder string keys for any screen copy to
`shared/src/commonMain/composeResources/values/strings.xml` **and**
`values-es/strings.xml` (empty or `TODO` placeholder text — the real
copy is a content decision, not this skill's job to invent).
`architecture.dual_localization_required` is `false` in this repo (no
`iosApp/*.strings` exist) — Compose resources are the only place
localized strings live.

## What this skill does NOT do

- Does not invent business logic, UI layout, or screen states beyond
  `Idle`/`Loading` — every generated body has a `// TODO` where a
  decision belongs to the spec's own implementation steps.
- Does not run the app or the build — the caller (`/spec-implement`,
  or the user directly) verifies per the usual
  `./gradlew :androidApp:assembleDebug` / manual-run process.
- Does not modify an existing feature — refuses if the target package
  already exists (see Preconditions).
- Does not build a second caching mechanism when the existing
  `ICache`/`ApiCache.sq` plumbing already covers the need (see 3a).
- Does not commit anything.

## Output

After generation, print the full file list grouped by layer (Domain /
Data / DI / Presentation / Navigation / Localization), each marked
`created` or `edited` (for the DI/nav/localization files that were
modified in place, not created), plus a `TODO` checklist pulled from
every `// TODO` comment inserted — so the next step (or the user) has a
single list of what's left to actually implement.

## Failure modes and recovery

| Symptom | Cause | Recovery |
|---|---|---|
| Target package already exists | Feature name collides with an existing one | Confirm whether this should be an edit to the existing feature instead; pick a different name if genuinely new |
| `--data local` requested but the need is really just caching | Most "I need to persist this" asks are actually covered by the existing generic cache | Confirm with the user whether `--data remote` (going through the existing cache) is enough before scaffolding a new SQLDelight table |
| `--data remote` but the existing `KtorClientFactory` qualifier pattern doesn't fit | The feature needs a client shape not covered by the existing qualifier(s) | Read `data/remote/di/Modules.kt` and `data/remote/ktor/` with Serena first, surface the mismatch, ask the user how to proceed rather than inventing a new factory type silently |
| `--nav-route yes` but there's no obvious parent screen to link to | Feature is meant to be reached from a not-yet-built entry point | Wire the `Destinations` entry and route anyway (so it's reachable via `navController.navigate(...)`), note in the summary that no caller triggers it yet |

## Reference

- Real examples to mirror (read with Serena before generating, don't
  rely on this file's templates alone — they're illustrative, the live
  code is the source of truth): `features/berries/list` +
  `features/berries/detail` (list/detail pair, remote data),
  `features/pokemon/list` + `features/pokemon/detail` (the most complex
  pair, includes tabs/pages), `features/about` (simplest, no data
  layer — `--data none` shape).
- `.serena/memories/` (once seeded via onboarding) — the layering and
  naming rules this skill encodes.
- `.claude/skills/solid/SKILL.md` — the SOLID rationale behind the
  domain/data split this skill scaffolds.
- Used by: `/spec-implement`, when a spec's `proposal.md` §6 names
  `/new-feature` (see `/spec-plan`'s Decision rules for when that's the
  right call).
