repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
}

plugins {
    `kotlin-dsl`
}

dependencies {
    implementation("com.android.tools.build:gradle:8.3.1")
    implementation("org.jetbrains.kotlin.android:org.jetbrains.kotlin.android.gradle.plugin:1.9.23")
}

gradlePlugin {
    plugins {
        register("libraryPlugin") {
            id = "library-common"
            implementationClass = "LibraryConventionPlugin"
        }
    }
}
