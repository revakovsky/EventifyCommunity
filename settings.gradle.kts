@file:Suppress("UnstableApiUsage")

pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Eventify Community"

include(":app")
include(":featureSplash")
include(":featureAuth")
include(":featureProfile")

include(":domain")
include(":core")

include(":data")
include(":network")
include(":localDb")
