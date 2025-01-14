// Suppress annotation is a workaround for a bug.
@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    kotlin("multiplatform")
    alias(libs.plugins.compose)

    alias(libs.plugins.dokka)
}

group = extra["GROUP"] as String
version = extra["VERSION_NAME"] as String

kotlin {
    jvmToolchain(17)

    jvm()

    sourceSets {
        val jvmMain by getting {
            dependencies {
                implementation(compose.desktop.common)
                implementation(compose.foundation)

                implementation("com.github.alexfacciorusso:windows-registry-ktx:6a9b0b89d2")
//                implementation("com.alexfacciorusso:windows-registry-ktx")

                implementation(libs.jna)
                implementation(libs.jna.platform)
            }
        }
    }
}