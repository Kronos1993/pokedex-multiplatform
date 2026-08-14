# Tech stack

- Kotlin Multiplatform (Compose Multiplatform) targeting Android, iOS, Desktop (JVM). `enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")` in settings.gradle.kts — use `libs.xxx` accessors, not raw version-catalog strings.
- DI: Koin (`di/Modules.kt`, `di/Koin.kt`).
- Networking: Ktor client against PokeAPI (public, keyless — no API credentials in this repo).
- Persistence: SQLDelight — single generic HTTP-response cache table (`ApiCache.sq`), not per-feature entities.
- Build: Gradle Kotlin DSL, `kotlin.code.style=official`, configuration cache + build cache enabled (gradle.properties).
- Repo hosted on GitHub: `Kronos1993/pokedex-multiplatform`. Solo-maintained, no issue tracker, no CI-inferred branch convention (no merge commits in history).
