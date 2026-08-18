---
spec_id: desktop-ux-adaptation
title: Adapt existing touch interactions to mouse/keyboard on Desktop
type: story
priority: normal
source: manual
source_ref: dictated in chat, 2026-08-18
created: 2026-08-18
status: INTAKE_PARSED
recommend_split: no
blockers: []
depends_on: []
expect_actual_touched: no
localization_touched: no
branch_suggested: feature/desktop-ux-adaptation
---

# Proposal: Adapt existing touch interactions to mouse/keyboard on Desktop

## 1. Source

Manual intake, dictated in chat 2026-08-18 (see `specs/desktop-ux-adaptation/story.md`). A Spanish-language user story: "Adaptación de UX para Desktop" — adapt the app's touch-gesture-oriented interactions to mouse/keyboard-native Desktop interactions, without changing business logic, without degrading mobile/tablet, and without a separate Desktop implementation.

**Scope narrowed 2026-08-18** at the user's explicit request: rather than building a speculative library of desktop primitives for interaction patterns the app doesn't have yet (context menus for long-press, multi-select, tooltips, FAB→toolbar), this spec adapts only the touch-gesture interactions **confirmed to exist in the codebase today**. Everything else from the source story is dropped from this spec's scope (see §3 Out of scope and the investigation notes below).

## 2. Problem / Why

This is a Compose Multiplatform app (Android/iOS/Desktop) whose UI was built touch-first. Investigation (grep across `shared/src/commonMain`) confirms exactly three touch-oriented interactions exist in the app today with no desktop-native equivalent:

1. **Swipe-to-refresh** — `PullToRefreshContainer` (`core/ui/components/PullRefresh.kt`) is used in 17 list/detail screens; there is no button or keyboard way to trigger the same refresh on Desktop.
2. **Tap feedback on buttons/cards** — `Buttons.kt` (`Button`, `IconButton`) and `CardView.kt` have no hover/pressed/focused/disabled visual states; a mouse user gets no visual feedback before/without clicking.
3. **Back gesture/button** — `BackPressHandlerEffect` (used in `features/pokedex/PokedexScreen.kt`) has no Desktop equivalent; a Desktop user has no keyboard way to trigger the same "back" action.

Everything else the original story mentions (FAB→toolbar, bottom sheets, long-press→context menu, Ctrl/Cmd+Click multi-select, tooltips) has **no existing implementation to adapt** — `FabButton`/`FabDialButton` are defined in `Buttons.kt` but never called from any screen, and grep found zero `combinedClickable`/`onLongClick`/`BottomSheet`/selection-state code anywhere in the repo.

## 3. Scope

**In scope**
- Add an `onRefresh: (() -> Unit)? = null` / `isRefreshing: Boolean = false` pair of optional params to the shared `AppTopAppBar` (`core/ui/components/TopAppBar.kt`): when set and running on Desktop, render a refresh action icon plus an `F5` keyboard shortcut, calling the same refresh callback each screen already wires to its `PullToRefreshContainer`. `PullToRefreshContainer` itself is untouched — the swipe gesture keeps working everywhere, the button/shortcut is Desktop-only and additive.
- Wire that new `onRefresh`/`isRefreshing` param on each of the 17 screens that already call both `AppTopAppBar` and `PullToRefreshContainer`, passing their existing refresh callback through (mechanical wiring — no new refresh logic).
- Add hover/pressed/focused/disabled visual states to `Button` and `IconButton` in `core/ui/components/button/Buttons.kt`, and to `core/ui/components/CardView.kt`, via `InteractionSource` — additive, defaults to current touch behavior unchanged.
- Add a Desktop-only `Esc` key handler on `features/pokedex/PokedexScreen.kt` that invokes the same `onBack` callback already passed to `BackPressHandlerEffect` — mobile back-button/gesture behavior untouched.
- A small `core/ui/PlatformInteraction.kt` helper (`isDesktop()` / `rememberIsDesktop()`) built on the already Koin-bound `Platform`/`PlatformType.DESKTOP`, used to gate all of the above — the single, consistent way every screen checks "am I on Desktop," so gating isn't duplicated ad-hoc per call site.

**Out of scope** (no existing implementation in the app to adapt — confirmed by investigation, not assumed)
- FAB→toolbar evaluation: `FabButton`/`FabDialButton` exist in `Buttons.kt` but are called from zero screens.
- Bottom sheet → dialog/popover adaptation: no `BottomSheet`/`ModalBottomSheet` usage anywhere in the repo.
- Long-press → right-click/context-menu: no `combinedClickable`/`onLongClick` anywhere in the repo.
- Ctrl/Cmd+Click multi-select: no selection-state/multi-select feature exists in any screen.
- Tooltips: no existing "elements that need additional explanation" pattern (icon-only affordance, truncated-text pattern, etc.) was found that this spec could attach a tooltip to.
- Keyboard focus-order audit across the whole app, and NavDrawer/BottomNavBar-specific keyboard adaptation: the drawer/bottom-nav are already opened and navigated via ordinary clickable Material3 components (`IconButton`, `NavigationDrawerItem`, `NavigationBarItem`), which already receive Compose Multiplatform Desktop's baseline focus/hover handling; no gesture-only interaction was found there that lacks a mouse/keyboard equivalent today.
- Any change to `domain/`, `data/`, or ViewModel business logic.
- Removing or degrading any existing mobile/tablet gesture.
- A separate/independent Desktop app implementation.

If any of the above turns out to be wanted later (once the app actually grows a FAB, a bottom sheet, a long-press action, or a multi-select feature), it becomes a new spec at that time — adapting a real interaction, not a hypothetical one.

## 4. Affected areas

| Area | Source set(s) | Class(es) / file(s) touched | Change type | Resolved by | Notes |
|--------|--------------|-------------------------------|-------------|-------------|-------|
| core | commonMain | `core/ui/PlatformInteraction.kt` (new) | add | | `isDesktop()`/`rememberIsDesktop()` on top of existing Koin-bound `Platform`/`PlatformType.DESKTOP` |
| core | commonMain | `core/ui/components/TopAppBar.kt` (`AppTopAppBar`) | modify (additive) | | new optional `onRefresh`/`isRefreshing` params; existing callers unaffected if they don't pass them |
| core | commonMain | `core/ui/components/button/Buttons.kt` (`Button`, `IconButton`) | modify (additive) | | hover/pressed/focused/disabled via `InteractionSource`; `FabButton`/`FabDialButton` untouched (unused, out of scope) |
| core | commonMain | `core/ui/components/CardView.kt` | modify (additive) | | already creates a `MutableInteractionSource` — extend, don't replace |
| features | commonMain | 17 screens under `features/{pokemon,abilities,items,move,types,natures,berries,egg_group,pokedex}/{list,detail}/*Screen.kt` | modify (wiring only) | | pass existing refresh callback into `AppTopAppBar`'s new params — no new refresh logic |
| features | commonMain | `features/pokedex/PokedexScreen.kt` | modify (additive) | | add Desktop-only `Esc` handler calling the existing `onBack` lambda already passed to `BackPressHandlerEffect` |

## 5. Architectural gauntlet (this repo's hard rules)

### 5a. Always explicit (no shortcut)

- [x] **Expect/actual parity** — N/A. No new/changed `expect` declaration; Desktop detection reuses the already-bound `Platform`/`PlatformType` interface.
      Approach: N/A — reuse existing `Platform` binding.
- [x] **Dual localization** — N/A. This spec introduces no new user-facing string (the refresh action reuses an icon, no new label text is required; if a content-description string is added it goes only into `composeResources/values` + `values-es`, consistent with `architecture.dual_localization_required: false`).
      Approach: confirmed — no new copy planned; if a content-description is needed during implementation, add it to both `values/strings.xml` and `values-es/strings.xml`.
- [x] **Secrets & logging** — N/A. UI-only change; no network/credential code involved.
      Approach: confirmed.
- [x] **No automated tests exist** — Acknowledged. Verification is build-green (`./gradlew build`) plus a manual run of `:desktopApp:run` — see plan.md Out-of-band actions.
      Acknowledged: yes.

### 5b. Confinement-conditional

- [ ] **Confinement claim** — NOT ticked. This touches shared `core/ui/components/` (consumed by every feature) plus mechanical wiring across 17 feature screens, so the single-feature shortcut doesn't apply — even though no domain/data boundary is crossed.

- [x] **Domain/data boundary (DIP)** — N/A. No new or changed data access; no `domain/repository/*` interface or `data/repository/*Impl` touched. The refresh callback and `onBack` lambda already exist and are only threaded through to new UI-layer params.
      Approach: N/A — pure UI-layer wiring.
- [x] **Result-type error handling** — N/A. No repository/data-layer function added or changed.
      Approach: N/A.

## 6. Skills

**Skills**: direct edits

## 7. Risks

- `AppTopAppBar`, `Buttons.kt`, and `CardView.kt` are shared by every feature — a regression there ripples across the whole app, and this repo has no automated test to catch it before a manual pass.
- Wiring the new `onRefresh`/`isRefreshing` params across 17 screens is repetitive; a skipped or inconsistent screen breaks the story's "same functionality everywhere" acceptance bar (§8 AC-4 below covers this).
- The `Esc` handler on `PokedexScreen` must preserve the exact existing mobile back-button/gesture behavior and must live in the Compose UI layer (a `Platform`-gated key handler in the Screen), not in the ViewModel — exactly the "no Desktop-specific behavior in business logic" rule the source story itself calls out.

## Out-of-band actions

- Manual verification of hover/pressed/focused visuals, the `F5` refresh shortcut, and the `Esc` back handler requires a human at a real desktop session running `:desktopApp:run` — Claude Code can build/launch the JVM desktop target but cannot drive real mouse hover or keyboard-focus interaction inside the window.

## 8. Acceptance criteria

- [ ] **AC-1** — `AppTopAppBar` renders a refresh action icon and responds to `F5` on Desktop only, when a screen passes a non-null `onRefresh`; on Android/iOS, `AppTopAppBar`'s existing behavior is unchanged (no icon, no shortcut).
- [ ] **AC-2** — All 17 screens that call `PullToRefreshContainer` also pass their existing refresh callback into `AppTopAppBar`'s new `onRefresh` param; swipe-to-refresh keeps working unchanged on Android/iOS.
- [ ] **AC-3** — `Button`, `IconButton`, and `CardView` show distinct hover/pressed/focused/disabled visuals when running under `PlatformType.DESKTOP`; existing call sites compile and render unchanged on touch platforms.
- [ ] **AC-4** — Pressing `Esc` on `PokedexScreen` (Desktop only) triggers the same `onBack` behavior as the existing Android back button/gesture; mobile back-button behavior is unchanged.
- [ ] **AC-5** — No file under `domain/`, `data/`, or any ViewModel's business-logic method is changed; the `Esc`/refresh/hover logic lives only in Compose `Screen`/`core/ui/components` files.
- [ ] **AC-6** — `./gradlew build` is green (Android + Desktop/JVM); no `expect`/`actual` file is touched.
- [ ] **AC-7** — Manual run of `./gradlew :desktopApp:run` confirms the refresh button, `F5` shortcut, hover/pressed/focused states, and `Esc` back handler all work as intended (Out-of-band action above); a manual run on Android (emulator) confirms swipe-to-refresh and the Android back button still work unchanged.

## 9. Open questions

- **OQ-1** — Should the Desktop refresh icon replace the existing `Search`/menu action ordering in `AppTopAppBar`, or simply append after them? Non-blocking — default to appending last (least disruptive to each screen's existing action list).

---

## Serena memories consulted

- `mem:core` — module map, invariants (expect/actual parity, no test suite, localization location).
- `mem:conventions` — `ParentViewModel`, DIP boundary, Result-type error handling, expect/actual suffixes.
- `mem:navigation` — `Destinations` enum location (inline in `NavDrawer.kt`) — confirmed not touched by this narrowed scope.
- `mem:tech_stack` — Compose Multiplatform targets, Koin, no test suite.
