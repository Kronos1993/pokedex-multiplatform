# Desktop platform interactions (Compose Multiplatform)

- Desktop detection: inject `Platform` (Koin-bound `singleOf(::DevicePlatform).bind<Platform>()` in every `Module.*.kt`) and compare `platformType == PlatformType.DESKTOP`. Reusable helper: `core/ui/PlatformInteraction.kt` (`isDesktop()` / `rememberIsDesktop()`) — use it instead of re-deriving the check per call site, so gating stays consistent across screens.
- Compose Desktop key events (`Modifier.onPreviewKeyEvent`/`onKeyEvent`) only fire within a subtree that currently has focus — there is no window-level shortcut registration reachable from a shared composable; a true global shortcut (working regardless of what has focus) needs a key listener in `desktopApp/main.kt`. Workaround used in this repo for a per-screen shortcut: request focus onto the relevant composable via a dedicated `FocusRequester` in a `LaunchedEffect`, gated to when the feature is active and `isDesktop` is true.
- Gotcha: when adding a Desktop-only modifier chain (`.focusRequester(...).focusable().onPreviewKeyEvent{...}`), gate the *entire chain* behind the `isDesktop` check — not just the behavior inside the key-event lambda. Attaching `focusable()` unconditionally (even if the lambda body no-ops on touch platforms) still changes focus/semantics on Android/iOS. A build-green check never catches this — it's a runtime/semantics change, not a compile error.

## Related memories

- `mem:core` — module map, invariants.
- `mem:build_known_issues` — a pre-existing baseline build failure unrelated to Desktop work, but worth knowing before assuming a red build is your regression.
