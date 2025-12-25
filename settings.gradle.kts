rootProject.name = "spring-template"

pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.6.0"
}

module(":service-api", "apps/service-api")

module(":first-domain", "domain/first-domain")
module(":second-domain", "domain/second-domain")
module(":third-domain", "domain/third-domain")

module(":ai", "libs/infra/ai")
module(":database", "libs/infra/database")
module(":security", "libs/security")
module(":common", "libs/common")

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            from(files("libs.versions.toml"))
        }
    }
}

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

fun module(name: String, path: String) {
    include(name)
    project(name).projectDir = file(path)
}
