import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

class LibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.library")
            }

            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

            extensions.configure<LibraryExtension> {
                compileSdk = 37

                defaultConfig {
                    minSdk = 26

                    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                }

                buildTypes {
                    release {
                        isMinifyEnabled = false
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

            tasks.withType<KotlinCompile>().configureEach {
                compilerOptions {
                    jvmTarget.set(JvmTarget.JVM_17)
                }
            }

            dependencies {
                implementation(libs.findLibrary("androidx-core-ktx").get())
                implementation(libs.findLibrary("androidx-appcompat").get())
                implementation(libs.findLibrary("material").get())
                testImplementation(libs.findLibrary("junit").get())
                androidTestImplementation(libs.findLibrary("androidx-test-junit").get())
                androidTestImplementation(libs.findLibrary("androidx-test-espresso-core").get())

                implementation(project(":shared:resource"))
            }
        }
    }
}

private fun DependencyHandler.`implementation`(dependencyNotation: Any): Dependency? =
    add("implementation", dependencyNotation)

private fun DependencyHandler.`testImplementation`(dependencyNotation: Any): Dependency? =
    add("testImplementation", dependencyNotation)

private fun DependencyHandler.`androidTestImplementation`(dependencyNotation: Any): Dependency? =
    add("androidTestImplementation", dependencyNotation)
