# Navigation

`Destinations` (enum) is the app's route/screen identifier list — one entry per screen (`POKEDEX`, `POKEMON_LIST`, `POKEMON_DETAIL`, `MOVES`, `MOVE_DETAIL`, `TYPES`, `TYPES_DETAIL`, `ABILITIES`, `ABILITY_DETAIL`, `NATURES`, `NATURE_DETAIL`, `EGG_GROUPS`, `EGG_GROUP_DETAIL`, `ITEMS`, `ITEMS_CATEGORIES`, `ITEM_DETAIL`, `BERRIES`, `BERRY_DETAIL`, `SETTINGS`, `ABOUT`, `EXIT`).

Unlike the sibling repos in this lineage (e.g. weather-app, parcel-tracking-multiplatform), where a `Destinations`-equivalent lives in its own root-level file, in **this repo** it is defined inline inside `core/ui/components/NavDrawer.kt` (not a standalone `Destinations.kt` — no such file exists here) — colocated with the nav-drawer UI that consumes it. Used by `App.kt` (top-level nav host) and `core/ui/components/NavDrawer.kt`/`BottomNavBar.kt` for routing.

When comparing navigation conventions across sibling repos, don't assume a standalone `Destinations.kt` file exists here — grep for `enum class Destinations` instead of guessing the file path.
