# Conventions

- Architecture shape per feature: `features/<feature>/{list,detail}/XxxScreenViewModel` (extends `core/viewmodel/ParentViewModel`, sealed `ScreenState`) -> `domain/repository/*Interface` (DIP boundary) -> `data/repository/<feature>/*Impl` -> `data/remote` (Ktor/PokeAPI). `di/` wires interface->impl via Koin.
- Error handling: sealed `Result<Success, Error>` in `core/result/Result.kt` (`map`, `onSuccess`, `onError`, `asEmptyDataResult`) — used instead of exceptions for repository/domain-layer flow control.
- `ParentViewModel` (`core/viewmodel/ParentViewModel.kt`) supplies shared state helpers: `updateSearchQuery`, `isSearching`, `setLastPage`, `setLimit`, `setOffset`, `setRefreshing`, `clearMessage`, `log`. New feature ViewModels should extend it rather than reimplementing this state.
- Compose screens use `koinViewModel()` injection, not manual DI wiring per screen.
- expect/actual file suffixes: `.android.kt`, `.ios.kt`, `.jvm.kt` (not `.native.kt`).
- New feature scaffolding is templated by the `new-feature` skill (`.claude/skills/new-feature/SKILL.md`) — prefer it over hand-rolling a new feature's boilerplate.
- Deep architecture/SOLID/clean-code guidance for this codebase's specific shape lives in the `solid` skill (`.claude/skills/solid/SKILL.md` + `references/*.md`) — read it before larger refactors.
