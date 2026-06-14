import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

class LibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.library")
            }

            extensions.configure<LibraryExtension> {
                compileSdk = Versions.compileSdk

                defaultConfig {
                    minSdk = Versions.minSdk

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
                implementation("androidx.core:core-ktx:1.19.0")
                implementation("androidx.appcompat:appcompat:1.7.1")
                implementation("com.google.android.material:material:1.12.0")
                testImplementation("junit:junit:4.13.2")
                androidTestImplementation("androidx.test.ext:junit:1.3.0")
                androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")

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
