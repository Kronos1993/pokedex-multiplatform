# Suggested commands

- Android debug build: `./gradlew :androidApp:assembleDebug`
- Desktop run: `./gradlew :desktopApp:run`
- Desktop hot reload: `./gradlew :desktopApp:hotRun --auto`
- Full build (all modules): `./gradlew build`
- iOS: no Gradle target. Open `iosApp/iosApp.xcodeproj` in Xcode and run from there, or use the IDE run configuration. Not automatable headlessly.
- No test command exists — there are zero test source sets in this repo (see `mem:task_completion`).
- PR flow: `gh pr create` (gh CLI) — see `.claude/skills/create-pr/SKILL.md`. Default PR target is `main` (provisional, unconfirmed vs `master` — see `.specs/config.json` `pr._default_target_doc`).
