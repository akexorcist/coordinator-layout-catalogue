plugins {
    id("library-common")
}

android {
    namespace = "com.akexorcist.coordinatorlayout.category.viewpager"
}

dependencies {
    implementation(libs.androidx.fragment.ktx)
    implementation(libs.androidx.viewpager2)
}
