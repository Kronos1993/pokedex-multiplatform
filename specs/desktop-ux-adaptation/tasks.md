---
spec_id: desktop-ux-adaptation
mirrors: plan.md
generated_by: /spec-plan
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

# Tasks: Adapt existing touch interactions to mouse/keyboard on Desktop

## Implementation

- [x] **Step 1** — Add a desktop-detection helper on top of the existing `Platform` binding
  - [x] Code change applied
  - [x] Build green (`./gradlew :androidApp:assembleDebug`)
  - [x] Verification met (per plan.md)
- [x] **Step 2** — Add a Desktop refresh action + F5 shortcut to `AppTopAppBar`
  - [x] Code change applied
  - [x] Build green
  - [x] Verification met
- [x] **Step 3** — Add hover/pressed/focused/disabled states to `Button`, `IconButton`, and `CardView`
  - [x] Code change applied
  - [x] Build green
  - [x] Verification met
- [x] **Step 4** — Wire the refresh callback into `AppTopAppBar` on each of the 17 screens
  - [x] Code change applied
  - [x] Build green
  - [x] Verification met
- [x] **Step 5** — Add a Desktop `Esc` handler to `PokedexScreen`
  - [x] Code change applied
  - [x] Build green
  - [x] Verification met
- [x] **Step 6** — Build matrix verification
  - [x] Verification met (`./gradlew build`: red only on pre-existing-baseline `:shared:compileCommonMainKotlinMetadata`, see decisions.md; all real compile targets — Android, JVM/Desktop, iOS — green; zero new `expect` declarations confirmed by diff review)
- [x] **Step 7** — Manual runs on Desktop and Android
  - [x] Verification met — Desktop: user-confirmed live in `:desktopApp:run` (refresh icon + `F5`, hover/pressed/focused visuals, and `Esc` on the Pokedex screen all working). Android: user-confirmed live on a physical device — app runs fine, no regression.

## Pre-handoff checks

- [x] Full build green (`./gradlew build` — covers Android + JVM/desktop targets; run `./gradlew :androidApp:assembleDebug` at minimum if only Android was touched) — red only on `:shared:compileCommonMainKotlinMetadata`, confirmed pre-existing on clean `main` (decisions.md); every other task, including `:androidApp:assembleDebug`, `:shared:compileKotlinJvm`, and the iOS compile tasks, is green
- [x] iOS build manually verified via Xcode if any `iosMain`/`iosApp/` file changed — N/A, no `iosMain`/`iosApp/` file touched by this spec (confirmed: `git diff --name-only` is commonMain-only)
- [x] No new logs/prints touch an API key or any other credential — confirmed via `git diff` grep against `verification.secret_log_keywords`, no matches
- [x] Every touched commonMain `expect` has a matching `actual` in every affected source set — N/A, no `expect` declaration added or changed (confirmed via `git diff` grep)
- [x] Any touched user-facing string shown by both Compose UI and native iOS code is updated in both `composeResources` and `iosApp/*.strings` — N/A, no new user-facing string introduced (refresh icon has no new content-description text, matching existing `IconButton` call-site conventions in this file)
- [x] No automated-test checkbox invented — this repo has zero test source sets (confirmed in `CLAUDE.md`); verification is build-green + manual run only
- [x] Acceptance criteria from proposal.md §8 satisfied — AC-1–AC-7 all verified: build green (modulo the pre-existing baseline metadata task) plus user-confirmed manual runs on both Desktop (`:desktopApp:run`) and a physical Android device
- [x] proposal.md frontmatter `blockers: []` (empty)
- [x] proposal.md frontmatter `depends_on:` either `[]` OR every listed ID has a folder under `specs/_archive/` — `[]`
- [x] All §9 OQs resolved or marked out-of-band — OQ-1 (non-blocking) resolved by default per proposal.md: refresh icon appended after existing actions
- [x] No plan.md step retains `_(skeleton)_` (each expanded with concrete sub-checks)

## Handoff

- [ ] Branch created (`feature/desktop-ux-adaptation`)
- [ ] `/commit` executed
- [ ] Branch pushed
- [ ] PR opened against `main`
- [ ] Spec folder archived to `specs/_archive/desktop-ux-adaptation/`
- [ ] Reusable-knowledge candidates from `decisions.md` proposed
