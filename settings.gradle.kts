@file:Suppress("UnstableApiUsage")

rootProject.name = "androidx-navigation-route-ksp"

pluginManagement {
    includeBuild("build-logic/initialization")
    includeBuild("build-logic/gradm")
    repositories {
        gradlePluginPortal {
            content {
                includeGroupByRegex("com.gradle.*")
            }
        }
        mavenCentral()
        maven(url = "https://s01.oss.sonatype.org/content/repositories/snapshots")
    }
}

plugins {
    id("initialization")
    id("gradm")
    id("com.gradle.enterprise") version "3.12.3"
}

gradleEnterprise {
    buildScan {
        termsOfServiceUrl = "https://gradle.com/terms-of-service"
        termsOfServiceAgree = "yes"
        publishAlwaysIf(!gradle.startParameter.isOffline)
    }
}

includeBuild("build-logic")

include("annotation")
include("compiler")

include("example")
