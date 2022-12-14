@file:Suppress("UnstableApiUsage")

rootProject.name = "androidx-navigation-route-ksp"

pluginManagement {
    includeBuild("build-logic")
    includeBuild("build-logic/initialization")
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
    id("com.gradle.enterprise") version "3.11.4"
}

gradleEnterprise {
    buildScan {
        termsOfServiceUrl = "https://gradle.com/terms-of-service"
        termsOfServiceAgree = "yes"
        publishAlwaysIf(!gradle.startParameter.isOffline)
    }
}

include("annotation")
include("compiler")

include("example")
