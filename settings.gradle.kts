@file:Suppress("UnstableApiUsage")

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Coordinator Layout Catalogue"
include(":app")
include(":category:standard")
include(":category:top-sticky")
include(":category:snapped")
include(":category:stacked")
include(":category:recycler-view")
include(":category:nested-child-view")
include(":category:fragment")
include(":category:motion-layout")
include(":shared:resource")
include(":category:view-pager")
