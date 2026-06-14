repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
}

plugins {
    `kotlin-dsl`
}

dependencies {
    implementation("com.android.tools.build:gradle:9.2.0")
    implementation("org.jetbrains.kotlin.android:org.jetbrains.kotlin.android.gradle.plugin:2.4.0")
}

gradlePlugin {
    plugins {
        register("libraryPlugin") {
            id = "library-common"
            implementationClass = "LibraryConventionPlugin"
        }
    }
}
