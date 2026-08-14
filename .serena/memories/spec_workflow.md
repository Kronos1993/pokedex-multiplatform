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

## gh CLI not installed
`create-pr` (and anything that calls it: `spec-finalize`, `spec-ship`) preconditions on `gh` being on PATH and authenticated. As of 2026-08-14 `gh` is NOT installed on this machine — `command -v gh` fails. Any PR-opening step will stop at the precondition check until the user runs `brew install gh && gh auth login`.
