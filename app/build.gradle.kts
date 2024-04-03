plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.akexorcist.coordinatorlayout.catalogue"
    compileSdk = Versions.compileSdk

    defaultConfig {
        applicationId = "com.akexorcist.coordinatorlayout.catalogue"
        minSdk = Versions.minSdk
        targetSdk = Versions.targetSdk
        versionCode = Versions.versionCode
        versionName = Versions.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    implementation(project(":category:standard"))
    implementation(project(":category:top-sticky"))
    implementation(project(":category:snapped"))
    implementation(project(":category:stacked"))
    implementation(project(":category:recycler-view"))
    implementation(project(":category:nested-child-view"))
    implementation(project(":category:fragment"))
    implementation(project(":category:motion-layout"))
    implementation(project(":category:view-pager"))
    implementation(project(":shared:resource"))
}
