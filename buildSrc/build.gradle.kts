repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
}

plugins {
    `kotlin-dsl`
}

dependencies {
    implementation(libs.android.gradle.plugin)
    implementation(libs.kotlin.gradle.plugin)
}

gradlePlugin {
    plugins {
        register("libraryPlugin") {
            id = "library-common"
            implementationClass = "LibraryConventionPlugin"
        }
    }
}
