import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    alias(libs.plugins.kotlinJvm)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
}

dependencies {
    implementation(projects.shared)

    implementation(compose.desktop.currentOs)
    implementation(libs.kotlinx.coroutinesSwing)

    implementation(libs.compose.uiToolingPreview)
}

compose.desktop {
    application {
        mainClass = "com.kronos.mutliplatform.pokedex.MainKt"

        nativeDistributions {
            modules("jdk.unsupported", "java.sql")

            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "Pokedex"
            packageVersion = "1.0.0"

            macOS {
                iconFile.set(rootProject.file("icons/desktop-app-icons/icon.icns"))
                bundleID = "com.kronos.mutliplatform.pokedex"
            }
            windows {
                iconFile.set(rootProject.file("icons/desktop-app-icons/icon.ico"))
                menuGroup = "Pokedex"
                upgradeUuid = "TU-UUID-AQUI"
            }
            linux {
                iconFile.set(rootProject.file("icons/desktop-app-icons/icon.png"))
            }
        }
    }
}