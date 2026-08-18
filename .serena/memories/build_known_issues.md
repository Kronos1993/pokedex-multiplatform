# Known build issues

- `:shared:compileCommonMainKotlinMetadata` fails on a clean checkout of `main` (confirmed 2026-08-18, commit `a1dd950`) with "Class 'X' is not abstract and does not implement abstract members" for several unrelated `expect` classes (`DevicePlatform`, `ExceptionHandlerImpl`, `LogManager`, `AppPreference`, `AppInfo`, `ChangeLang`, `CloseAppImpl`, `ExpectedIntents`, `KtorEngine`). This is the standalone KMP common-metadata publish target — independent of the real compile targets (`:androidApp:assembleDebug`, `:shared:compileKotlinJvm`, `:shared:compileKotlinIosArm64`/`IosSimulatorArm64`), which all succeed in the same build.
- Before treating a red `./gradlew build` as a regression from your own change, check whether `:shared:compileCommonMainKotlinMetadata` is the *only* failed task — if so, verify via `git stash` + re-run on the clean baseline before investigating further; it is very likely this pre-existing issue, not your change.

## Related memories

- `mem:core` — module map, invariants.
