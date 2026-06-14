plugins {
    id("com.android.application")
}

android {
    namespace = "com.akexorcist.coordinatorlayout.catalogue"
    compileSdk = 37

    defaultConfig {
        applicationId = "com.akexorcist.coordinatorlayout.catalogue"
        minSdk = 26
        targetSdk = 36
        versionCode = 1
        versionName = "1.0.0"

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

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.junit)
    androidTestImplementation(libs.androidx.test.espresso.core)

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
