# Core — Pokedex (Kotlin Multiplatform)

Pokedex app over PokeAPI. Clean Architecture + MVVM + Koin, 3 Gradle modules: `:androidApp`, `:desktopApp`, `:shared`. iOS built separately via Xcode (`iosApp/iosApp.xcodeproj`), not a Gradle module.

Root package: `com.kronos.mutliplatform.pokedex` (note: "mutliplatform" is a real, intentional typo baked into the package path — do not "fix" it, it's load-bearing across the whole tree).

## Source map
- `shared/src/commonMain/kotlin/.../pokedex/` — the app, ~362 files:
  - `domain/` — models + `repository/*Interface` (DIP boundary), no impl logic
  - `data/` — `repository/<feature>/*Impl`, `remote/` (Ktor client hitting PokeAPI, DTOs), `local/` (SQLDelight — generic HTTP cache only, see `mem:cache`), `mapper/`
  - `features/<feature>/{list,detail}/` — `XxxScreenViewModel` (extends `core/viewmodel/ParentViewModel`) + `XxxScreen.kt` (Compose, `koinViewModel()` injection); features: pokemon, abilities, items, move, types, natures, berries, egg_group, pokedex, about, setting
  - `core/` — `viewmodel/ParentViewModel`, `result/Result.kt` (sealed `Result<Success/Error>` + `map`/`onSuccess`/`onError`), `di/`, `cache/`, `preferences/`, `logguer/` (sic), `exception/`, `ui/`
  - `di/Modules.kt`, `di/Koin.kt` — Koin wiring entry points
  - `components/` — shared Compose components (icons, etc.)
- `androidMain`/`iosMain`/`jvmMain`/`nativeMain` — platform actuals. File suffix convention: `.android.kt`, `.ios.kt`, `.jvm.kt`.
- `androidApp/`, `desktopApp/` — thin platform entry points.

## Invariants
- expect/actual parity is required: every `expect` in commonMain needs a matching `actual` in every active platform source set that uses it.
- New feature data flow: ViewModel -> `domain/repository/*Interface` -> `data/repository/<feature>/*Impl` -> `data/remote` (Ktor/PokeAPI). Wired via Koin in `di/`.
- Persistence is NOT per-feature Room-style entities — see `mem:cache`.
- No automated test suite exists anywhere in this repo (zero test source sets) — see `mem:task_completion`.
- Localization: `shared/src/commonMain/composeResources/values[-es]/*.xml` only (no native iOS `.strings` files).

## Related memories
- `mem:tech_stack` — languages, frameworks, versions.
- `mem:suggested_commands` — build/run commands actually used, Darwin-specific notes.
- `mem:conventions` — code style, DI, error-handling, screen/viewmodel shape.
- `mem:task_completion` — what "done" means for a task here (build-green, no tests).
- `mem:cache` — the single SQLDelight ICache/AppCache design.
- `mem:spec_workflow` — the `.specs/` spec-driven workflow and its skills.
