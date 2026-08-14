# Spec workflow — improvements backlog

This is the running log of deferred/unfinished improvements to this
`.specs/` workflow itself (not to the app code). Adapted from a
Smartmatic-internal `.specs/` workflow lineage — that lineage's own log
entries are specific to its tuning history and are not reproduced here;
this file starts fresh for this repo's own workflow.

Add an entry whenever a spec-* skill's design surfaces a known gap,
deferred feature, or rough edge that isn't worth fixing immediately.

## Format

```
### <YYYY-MM-DD> — <short title>

**Where:** <skill or doc>
**What:** <the gap or deferred item>
**Why deferred:** <one line>
```

## Deferred items carried over from the workflow's design (re-evaluate if/when relevant here)

- **Notifications** (`notifications.*` in `.specs/config.json`) — all
  channels disabled, none configured. No skill fans out any external
  notification today; `/spec-finalize` opens PRs only.
- **`/spec-resume`** — a hypothetical future skill to append new
  information to an already-planned spec's `story.md` (e.g. after a
  scope conversation continues outside the original intake). Not built.
- **`--checkpoint-per-step` commit mode** for `/spec-implement` — an
  opt-in mode that would commit after each `[implement]` step for
  granular bisectability. The default (zero commits during implement,
  one commit at `/spec-handoff`) is the current contract.

## This repo's own entries

### 2026-08-14 — `pr.default_target` confirmed as `main`

**Where:** `.specs/config.json` `pr.default_target` / `pr._default_target_doc`
**What:** User confirmed there is no `develop` branch and no git-flow branching model in this repo — branches are cut from `main`, and `main` is the PR integration target. `origin/HEAD` pointing at `master` is a stale GitHub default-branch pointer, not a workflow signal.
**Resolved:** Removed the "unconfirmed" caveat from `config.json` and this backlog's deferred-items list.
