# Cache / persistence

Only local persistence in this repo: a single generic HTTP-response cache table via SQLDelight.
- Schema: `shared/src/commonMain/sqldelight/.../data/local/database/ApiCache.sq`
- Wiring: `core/cache/CacheModule.kt` (interface `ICache`, impl `AppCache`)
- A new feature almost never needs its own Room-style entity/DAO — it goes through the existing keyed-by-request `ICache` automatically.
- Only add a new SQLDelight table for a genuinely new persisted concept (not the default path for a new feature) — see `.claude/skills/new-feature/SKILL.md`.
- This differs from sibling repos in the same lineage (multiplatform-weather-app, parcel-tracking-multiplatform), which use per-feature Room entities.
