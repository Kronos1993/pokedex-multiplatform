# Task completion

- This repo has NO automated test suite (zero test source sets) — never invent a "run tests" step. "Done" = build-green only, plus a manual run in emulator/simulator for UI-visible changes.
- Verification commands (from `.specs/config.json` `verification.build_commands`):
  - Android: `./gradlew :androidApp:assembleDebug`
  - Desktop: `./gradlew :desktopApp:run` (or `hotRun --auto` for iteration)
  - Full: `./gradlew build`
  - iOS: manual, via Xcode — not automatable from a skill/CLI chain.
- Default local verification for a change touching only shared/androidApp: Android debug assemble is enough (covers `:shared` + `:androidApp` compilation). Run `./gradlew build` if the change touched `jvmMain`/`desktopApp` or `iosMain`.
- Secret-log keyword guard exists in `.specs/config.json` (`apiKey`, `token`, `secret`, `password`, …) even though PokeAPI itself needs no credentials — kept as a standing guard for if one is added later.
