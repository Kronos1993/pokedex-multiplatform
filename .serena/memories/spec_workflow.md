# .specs/ spec-driven workflow

This repo uses a `.specs/`-based spec workflow (ported from sibling repo `multiplatform-weather-app`, itself from a Smartmatic-internal lineage). Config: `.specs/config.json` (schema: `.specs/config.schema.md`).

Skill chain: `/spec-new` -> `/spec-plan` -> `/spec-implement` -> [`/spec-review` optional] -> `/spec-handoff` -> `/spec-finalize` (or `/spec-ship` as a one-shot handoff+finalize+archive). `/spec-status` is the read-only inspector — check it first to see what's in flight.

Key config facts (subject to change — re-read `.specs/config.json` rather than trusting this verbatim over time):
- No issue tracker of any kind; intake is file/manual/url only.
- Branch naming: `feature/{key}`, `bugfix/{key}`, `refactor/{key}`, `chore/{key}`, `hotfix/{key}`.
- PR default target `main` is CONFIRMED (2026-08-14): no `develop` branch, no git-flow model — branches are cut from `main`, PRs target `main`. `origin/HEAD` pointing at `master` is a stale GitHub pointer, not a workflow signal.
- `architecture.modules`: domain, data, features, core, di, cache, components — split-heuristic thresholds live in `plan.split_thresholds`.
- `verification.no_test_suite: true` — see `mem:task_completion`.

## CLAUDE.md
Root `CLAUDE.md` was created 2026-08-14 via the `init` skill (sections: Project, Commands, Architecture, Working Rules). `.specs/lib/check-claude-md.sh` and `.specs/lib/check-sync.sh` both pass. Several skills (`spec-implement`, `spec-plan`, `create-pr`, `new-feature`, `commit`, `spec-review`) reference it directly for conventions (no test suite, no formatter/linter, `.serena/memories/` committed, "confirm file location before creating" rule) — keep it in sync if those skills' expectations change.

## Weather-app leftovers cleaned up (2026-08-14)
The `.specs/` workflow and skills were ported from the sibling `multiplatform-weather-app` repo and had NOT been fully adapted — same class of bug the user hit in the `parcel-tracking-multiplatform` repo. Found and fixed:
- 13 hardcoded `github.com/Kronos1993/Multiplatform-Weather-App` PR URLs (spec-finalize, spec-ship, spec-status, EXTERNAL_SKILLS.md, handoff-schema.md) → `Kronos1993/pokedex-multiplatform`.
- `spec-plan`'s "Knowledge selection" keyword table was 100% weather-app domain (`data/repository/weather`, `radar`, `location`, `features/add_city`) — rewritten for Pokedex's actual features (pokemon, abilities, items, move, types, natures, berries, egg_group, pokedex, about, setting).
- "WeatherAPI key" checklist items (a real functional bug, not just flavor text — PokeAPI is keyless) in `spec-plan`, `spec-review`, `spec-implement`, and — most importantly — in `.specs/templates/{proposal,tasks,plan}.md`, which get copied into every future spec. Genericized to "API key / credential-shaped string".
- `templates/proposal.md`'s Dual Localization checklist item hardcoded `iosApp/en.strings`/`iosApp/es.strings` as required targets even though this repo has NO such files (`architecture.dual_localization_required: false`) — fixed to state that directly instead of assuming the weather-app's file layout.
- GPS/MapLibre/Moko-permissions risk examples (not applicable — no location feature here) replaced with PokeAPI/sprite/cache-relevant equivalents.
Left untouched: purely illustrative `## Examples` blocks using fictional spec names like `fix-uv-index-rounding`/`add-rain-radar-toggle` — cosmetic only, don't affect skill behavior. If a new sibling repo is ever forked from this one, re-run this same audit (`grep -rniE "pokemon|pokedex|PokeAPI" .claude/skills .specs` from the new repo, expecting zero domain-specific hits) before trusting the ported workflow.

## gh CLI not installed
`create-pr` (and anything that calls it: `spec-finalize`, `spec-ship`) preconditions on `gh` being on PATH and authenticated. As of 2026-08-14 `gh` is NOT installed on this machine — `command -v gh` fails. Any PR-opening step will stop at the precondition check until the user runs `brew install gh && gh auth login`.
