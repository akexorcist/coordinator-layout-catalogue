plugins {
    id("library-common")
}

android {
    namespace = "com.akexorcist.coordinatorlayout.category.viewpager"
}

dependencies {
    implementation("androidx.fragment:fragment-ktx:1.6.2")
    implementation("androidx.viewpager2:viewpager2:1.0.0")
}
