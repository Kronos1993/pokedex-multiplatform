# .specs/config.json — schema & reader map

`.specs/config.json` holds the spec-driven workflow's configuration.
This file is the single catalog of config keys: what each one is, its
default, and **which skill reads it**.

Ported from the sibling repo `multiplatform-weather-app`'s `.specs/`
workflow for this repo's shape: a Kotlin Multiplatform app using the
current standard multi-module project structure — three Gradle modules
(`:androidApp`, `:desktopApp`, `:shared`), not a single `:composeApp`
like the sibling weather-app repo — solo-maintained, GitHub-hosted,
**no issue tracker**, **no automated test suite**, and SQLDelight (not
Room) for its one local persistence table.

**Division of labor:** `.specs/config.json` holds live values + inline
`_doc` rationale; this file holds the key catalog + reader map.

> **Secrets:** never store tokens/webhooks as literal values — use
> env-var indirection if one is ever needed (none is today).

---

## Key catalog

### `paths.*`

| Key | Type | Default | Read by |
|---|---|---|---|
| `paths.specs_root` | string | `specs` | `/spec-new`, `/spec-plan`, `/spec-status` |
| `paths.archive_root` | string | `specs/_archive` | `/spec-finalize`, `/spec-ship`, `/spec-status` |
| `paths.templates_root` | string | `.specs/templates` | `/spec-new`, `/spec-plan` |
| `paths.improvements_log` | string | `.specs/IMPROVEMENTS.md` | (informational) |

### `intake.*` — read by `/spec-new`

| Key | Type | Default | Purpose |
|---|---|---|---|
| `intake.sources` | string[] | `["file","manual","url"]` | The only three intake shapes — no issue-tracker key/URL detection exists in this repo. |

There is no `jira.*` block in this repo's config — see
`.specs/EXTERNAL_SKILLS.md` and `/spec-new`'s own doc for why, and what
replaced it.

### `branch.naming.<type>` — read by `/spec-handoff`, `/spec-ship`, `/spec-finalize`

| Key | Type | Default |
|---|---|---|
| `branch.naming.bug` | string template | `bugfix/{key}` |
| `branch.naming.story` | string template | `feature/{key}` |
| `branch.naming.refactor` | string template | `refactor/{key}` |
| `branch.naming.chore` | string template | `chore/{key}` |
| `branch.naming.hotfix` | string template | `hotfix/{key}` |

### `plan.*` — read by `/spec-plan`

| Key | Type | Default | Purpose |
|---|---|---|---|
| `plan.split_thresholds.modules` | int | `3` | §4 affected-modules table reaching this many DISTINCT capability areas (see `architecture.modules`) → split suggestion. |
| `plan.split_thresholds.risks` | int | `4` | §7 risk count reaching this → split. |
| `plan.split_thresholds.subsystems` | int | `2` | §8 AC subsystem grouping. |

### `ship.*` — read by `/spec-ship`

| Key | Type | Default | Purpose |
|---|---|---|---|
| `ship.open_archive_pr` | boolean | `true` | Archive PR default. |

### `pr.*` — read by `/create-pr`

| Key | Type | Default | Read by |
|---|---|---|---|
| `pr.cli` | string | `gh` | `/create-pr` |
| `pr.host` | string | `github.com` | `/create-pr` |
| `pr.repo_slug` | string | `Kronos1993/pokedex-multiplatform` | `/create-pr` |
| `pr.default_target` | string | `main` | `/create-pr` — **unconfirmed**: this repo has `main` (local, active) and `master` on origin (origin/HEAD) with no PR history to infer a convention from. Confirm with the user before the first real handoff. |
| `pr.create_args` | string[] | `[]` | `/create-pr` — GitHub has no MR-creation-time equivalent to GitLab's squash/delete-branch flags; those are merge-time choices. |
| `pr.first_push_strict_host_checking` | string | `accept-new` | `/create-pr` |

### `reviewers.*`

| Key | Type | Default | Read by |
|---|---|---|---|
| `reviewers.default` | string[] (GitHub usernames) | `[]` | `/spec-finalize`, `/spec-ship` — empty means no `--reviewer` flag passed, not an error. |

### `review.*` — read by `/spec-review`

| Key | Type | Default | Purpose |
|---|---|---|---|
| `review.default_mode` | string | `quick` | `quick` \| `full` \| `security-only` \| `scope-only`. |
| `review.confidence_critical` | int | `80` | ≥ this → Critical. |
| `review.confidence_important` | int | `50` | Filter threshold. |
| `review.findings_file` | path template | `specs/{key}/.review-findings.md` | Per-run findings file. |

### `verification.*` — read by `/spec-implement`

| Key | Type | Default | Purpose |
|---|---|---|---|
| `verification.build_per_implement_step` | boolean | `false` | Build after each `[implement]` step. |
| `verification.build_matrix_at_pre_handoff` | boolean | `true` | Build once at pre-handoff. |
| `verification.build_commands.*` | object | see `config.json` | Per-target build commands (`android`: `:androidApp:assembleDebug`, `desktop`: `:desktopApp:run`, `desktop_hot_reload`, `full`; `ios` has no headless equivalent — manual). Module names differ from the sibling weather-app repo. |
| `verification.skip_all_local` | boolean | `false` | Opt-in when both build flags are `false`. |
| `verification.distinguish_pre_existing_baseline` | boolean | `true` | Baseline-check before blaming the spec for a red build. |
| `verification.no_test_suite` | boolean | `true` | **Zero test source sets in this repo.** `/spec-plan`/`/spec-implement` must never invent a test step. |
| `verification.secret_log_keywords` | string[] | see `config.json` | Standing guard list — PokeAPI is free/keyless, no real secret exists in this repo today. |

### `architecture.*` — read by `/spec-plan` (gauntlet), `/spec-implement` (pre-handoff)

| Key | Type | Default | Purpose |
|---|---|---|---|
| `architecture.modules` | string[] | domain, data, features, core, di, cache, components | Populates §4 Affected-areas checklist. |
| `architecture.shape` | string | see `config.json` | One-line Clean Architecture chain, for quick reference in generated proposals. |
| `architecture.expect_actual_parity_required` | boolean | `true` | Every touched KMP `expect` must have a matching `actual` in every affected source set. |
| `architecture.cache_not_room` | boolean | `true` | This repo's real divergence from the sibling repos: persistence is one generic SQLDelight response cache (`ApiCache.sq` + `ICache`), not per-feature Room entities. A new feature normally doesn't need its own local table. |
| `architecture.dual_localization_required` | boolean | `false` | No `iosApp/*.strings` exist in this repo — localization lives only in `composeResources`. Flip to `true` if native iOS-side strings are ever introduced. |

---

## Reader map (skill → namespaces)

| Skill | Reads |
|---|---|
| `/spec-new` | `intake.*`, `paths.*` |
| `/spec-plan` | `paths.*`, `plan.*`, `architecture.*` |
| `/spec-implement` | `verification.*`, `paths.*` |
| `/spec-review` | `review.*`, `paths.*` |
| `/spec-handoff` | `branch.naming.*`, `paths.*` |
| `/spec-finalize` | `paths.*`, `pr.*`, `branch.naming.*`, `reviewers.default` |
| `/spec-ship` | `branch.naming.*`, `pr.*`, `reviewers.default`, `ship.open_archive_pr`, `paths.*` |
| `/spec-status` | `paths.*` |
| `/create-pr` | `pr.*` |

## Maintenance

- Adding a config key: add it to `config.json` with its `_doc`
  rationale, then add a catalog row + reader-map entry here.
- This workflow has no sibling spec/proposal system in this repo — it
  is the only one installed here.
- If `pr.default_target` is confirmed to be something other than
  `main` (see that key's `_doc`), update both `config.json` and this
  row together.
