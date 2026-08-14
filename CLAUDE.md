# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project

Pokedex — a Kotlin Multiplatform (Compose Multiplatform) app over the public PokeAPI, targeting Android, iOS, and Desktop (JVM). Three Gradle modules: `:androidApp`, `:desktopApp`, `:shared`. iOS is a separate Xcode project (`iosApp/iosApp.xcodeproj`), not a Gradle module.

Root package: `com.kronos.mutliplatform.pokedex` — the `mutliplatform` spelling is an intentional, load-bearing typo baked into the whole package tree. Do not "fix" it.

## Commands

- Android debug build: `./gradlew :androidApp:assembleDebug`
- Desktop run: `./gradlew :desktopApp:run`
- Desktop hot reload: `./gradlew :desktopApp:hotRun --auto`
- Full build (all Gradle modules): `./gradlew build`
- iOS: no Gradle target. Open `iosApp/iosApp.xcodeproj` in Xcode and run from there, or use the IDE run configuration — not automatable headlessly.

There is **no automated test suite** (zero test source sets) and **no automated formatter/linter** (no detekt, no ktlint, no `.editorconfig`) configured anywhere in this repo. Verification for a change is build-green plus a manual run in the emulator/simulator for UI-visible changes; style is convention-only — match the surrounding code.

## Architecture

Clean Architecture + MVVM + Koin, layered under `shared/src/commonMain/kotlin/com/kronos/mutliplatform/pokedex/`:

- `domain/` — models plus `repository/*Interface` (the DIP boundary); no implementation logic.
- `data/` — `repository/<feature>/*Impl`, `remote/` (Ktor client against PokeAPI, DTOs, mappers), `local/` (SQLDelight — a single generic HTTP-response cache, not per-feature entities).
- `features/<feature>/{list,detail}/` — `XxxScreenViewModel` (extends `core/viewmodel/ParentViewModel`, sealed `ScreenState`) + `XxxScreen.kt` (Compose, injected via `koinViewModel()`).
- `core/` — shared infra: `viewmodel/ParentViewModel` (search query, pagination, refreshing, message state shared across features), `result/Result.kt` (sealed `Result<Success, Error>` with `map`/`onSuccess`/`onError`, used instead of exceptions for repository/domain flow control), `di/`, `cache/`, `preferences/`, `exception/`, `ui/`.
- `di/Modules.kt`, `di/Koin.kt` — Koin wiring entry points; every repository interface is bound to its impl here.
- `components/` — shared Compose components (icons, etc.).

Data flow per feature: ViewModel → `domain/repository/*Interface` → `data/repository/<feature>/*Impl` → `data/remote` (Ktor/PokeAPI), wired end-to-end through Koin.

Persistence is intentionally **not** per-feature Room-style entities — the only local store is a single generic response cache (`data/local/database/ApiCache.sq`, `ICache`/`AppCache` in `core/cache/CacheModule.kt`), keyed by request. A new feature almost never needs its own table; only add one for a genuinely new persisted concept.

expect/actual parity is required: every `expect` in `commonMain` needs a matching `actual` in every active platform source set that uses it. File-suffix convention: `.android.kt`, `.ios.kt`, `.jvm.kt`.

Localization lives only in `shared/src/commonMain/composeResources/values[-es]/*.xml` — no native iOS `.strings` files exist.

## Working Rules

- Confirm the intended location with the user before creating any new file — state the resolved package path and the full file list, and wait for explicit approval before writing anything.
- `.serena/project.yml` and `.serena/memories/` are meant to be committed (only `.serena/cache/` and `.serena/project.local.yml` are gitignored) — they carry durable project knowledge for future sessions, keep them in sync with reality.
- This repo uses a `.specs/`-driven spec workflow (`/spec-new` → `/spec-plan` → `/spec-implement` → `/spec-handoff` → `/spec-finalize`, or `/spec-ship` as a one-shot). Config and conventions: `.specs/config.json`, `.specs/IMPROVEMENTS.md`, `.specs/templates/`. Run `/spec-status` to see what's in flight before starting new work.
- No issue tracker exists (solo-maintained, GitHub-hosted `Kronos1993/pokedex-multiplatform`) — spec intake is file/manual/URL only.
