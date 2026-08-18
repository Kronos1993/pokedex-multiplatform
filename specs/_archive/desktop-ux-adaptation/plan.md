---
spec_id: desktop-ux-adaptation
generated_by: /spec-plan
generated_at: 2026-08-18
---

> **Blockers**: none
> **Depends on**: none
>
> /spec-implement refuses to start while any blocker remains OR any
> dependency is not yet archived. To clear:
> - blocker → resolve the OQ in proposal.md §9, remove its ID from `blockers:`
> - dependency → wait for the depended spec to land in `specs/_archive/`,
>   then remove its ID from `depends_on:`
>
> Re-run /spec-plan after either to regenerate this banner.

# Plan: Adapt existing touch interactions to mouse/keyboard on Desktop

## Strategy

Three independent, additive changes, each adapting one confirmed-existing touch interaction: build the `isDesktop()` gate first (Step 1), then the two shared-component changes that depend on it (Steps 2–3), then the mechanical per-screen wiring pass (Step 4) and the single-screen `Esc` handler (Step 5), then verification (Steps 6–7). No step touches `domain/`, `data/`, or a ViewModel.

## Steps

### Step 1 — Add a desktop-detection helper on top of the existing `Platform` binding [implement]

- **Skill**: direct edits
- **Area(s)**: `core`
- **Files / symbols**:
  - `shared/src/commonMain/kotlin/com/kronos/mutliplatform/pokedex/core/ui/PlatformInteraction.kt` (new) — add `isDesktop(platform: Platform): Boolean` and a `@Composable fun rememberIsDesktop(): Boolean` built on the already Koin-bound `Platform`/`PlatformType.DESKTOP` (`core/Platform.kt`, `core/di/Module.jvm.kt:27`)
- **Skill args / inputs**: none
- **Why**: single, consistent gating point so Steps 2, 3, and 5 don't each duplicate a `platformType == PlatformType.DESKTOP` check
- **Verification**: `./gradlew :androidApp:assembleDebug` green; new symbol resolves on all 3 targets; grep the new file for `expect` — expect none

### Step 2 — Add a Desktop refresh action + F5 shortcut to `AppTopAppBar` [implement]

- **Skill**: direct edits
- **Area(s)**: `core`
- **Files / symbols**:
  - `shared/src/commonMain/kotlin/com/kronos/mutliplatform/pokedex/core/ui/components/TopAppBar.kt` — add optional `onRefresh: (() -> Unit)? = null` and `isRefreshing: Boolean = false` params to `AppTopAppBar`; when `onRefresh != null && rememberIsDesktop()`, append a refresh `IconButton` action (reusing the file's existing `AppBarAction.Icon`-style icon-button pattern) and handle `F5` via a key-event modifier on the `TopAppBar`
- **Skill args / inputs**: none
- **Why**: AC-1 — additive to `AppTopAppBar`'s existing signature; no existing caller that omits the new params is affected
- **Verification**: build green; `AppTopAppBar`'s existing callers that don't pass `onRefresh` compile and render unchanged

### Step 3 — Add hover/pressed/focused/disabled states to `Button`, `IconButton`, and `CardView` [implement]

- **Skill**: direct edits
- **Area(s)**: `core`
- **Files / symbols**:
  - `shared/src/commonMain/kotlin/com/kronos/mutliplatform/pokedex/core/ui/components/button/Buttons.kt` — extend `Button` and `IconButton` with hover/focus/pressed/disabled-aware styling via `InteractionSource`, defaulting to current visuals on touch; `FabButton`/`FabDialButton` untouched (unused, out of scope)
  - `shared/src/commonMain/kotlin/com/kronos/mutliplatform/pokedex/core/ui/components/CardView.kt` — extend the existing `MutableInteractionSource` usage with hover/focused states
- **Skill args / inputs**: none
- **Why**: AC-3
- **Verification**: build green; existing call sites of `Button`/`IconButton`/`CardView` compile unchanged (no signature break)

### Step 4 — Wire the refresh callback into `AppTopAppBar` on each of the 17 screens [implement]

- **Skill**: direct edits
- **Area(s)**: `features`
- **Files / symbols**:
  - `shared/src/commonMain/kotlin/com/kronos/mutliplatform/pokedex/features/{pokemon/list/PokemonListScreen.kt, abilities/list/AbilityListScreen.kt, abilities/detail/AbilityDetailScreen.kt, items/list/ItemListScreen.kt, items/detail/ItemDetailScreen.kt, items/categories/ItemCategoryListScreen.kt, move/list/MoveListScreen.kt, move/detail/MoveDetailScreen.kt, types/list/TypeListScreen.kt, types/detail/TypeDeatilScree.kt, natures/list/NatureListScreen.kt, natures/detail/NatureDetailScreen.kt, berries/list/BerryListScreen.kt, berries/detail/BerryDetailScreen.kt, egg_group/list/EggGroupListScreen.kt, egg_group/detail/EggGroupDetailScreen.kt, pokedex/PokedexScreen.kt}` — each already calls `AppTopAppBar` and `PullToRefreshContainer`; pass the same callback/state already wired to `PullToRefreshContainer`'s `onRefresh`/`isRefreshing` into the new `AppTopAppBar` params. No new refresh logic — this is wiring only.
- **Skill args / inputs**: none
- **Why**: AC-2
- **Verification**: build green; grep confirms all 17 files pass a non-null `onRefresh` to `AppTopAppBar`

### Step 5 — Add a Desktop `Esc` handler to `PokedexScreen` [implement]

- **Skill**: direct edits
- **Area(s)**: `features`
- **Files / symbols**:
  - `shared/src/commonMain/kotlin/com/kronos/mutliplatform/pokedex/features/pokedex/PokedexScreen.kt` — add a Desktop-only key-event handler that, when `Esc` is pressed and `rememberIsDesktop()` is true, invokes the same `onBack` lambda already passed to `BackPressHandlerEffect` (line 134); the existing `BackPressHandlerEffect` call and mobile behavior are untouched
- **Skill args / inputs**: none
- **Why**: AC-4 — kept in the Compose UI layer per the source story's explicit rule against Desktop-specific business logic
- **Verification**: build green; `BackPressHandlerEffect`'s existing call is unmodified (diff shows only an addition)

### Step 6 — Build matrix verification [verify]

- **What to check**: `./gradlew build` succeeds (Android + Desktop/JVM compilation); grep the diff for any new `expect`/`expect class`/`expect fun` — expect none
- **Pass criteria**: build green; zero new `expect` declarations in the diff

### Step 7 — Manual runs on Desktop and Android [verify]

- **What to check**: `./gradlew :desktopApp:run` — refresh icon appears in `AppTopAppBar` on at least one screen, `F5` triggers refresh, hover/pressed/focused states are visible on buttons/cards, `Esc` on the Pokedex screen triggers back navigation. Then a manual run on the Android emulator confirms swipe-to-refresh and the Android back button/gesture are unchanged.
- **Pass criteria**: both runs behave as described; no regression on Android. Full interactive Desktop verification (hover/F5/Esc) is an Out-of-band action below — requires a human at a real desktop session.

## Dependencies

- Step 4 depends on Step 2 (the new `AppTopAppBar` params must exist before screens can pass them).
- Step 5 depends on Step 1 (`rememberIsDesktop()` must exist).
- Steps 6–7 depend on Steps 1–5 complete.

## Out-of-band actions

- Manual verification of hover/pressed/focused visuals, the `F5` refresh shortcut, and the `Esc` back handler requires a human at a real desktop session running `:desktopApp:run` — Claude Code can build/launch the JVM desktop target (Step 7) but cannot drive real mouse hover or keyboard-focus interaction inside the window.

## Rollback

All changes are additive (new optional params, new file, new key handlers) or mechanical wiring passes across the 17 screens — `git restore` the specific files listed in the failing step. No migration tool or test suite exists, so re-verify with `./gradlew build` after any manual revert.
