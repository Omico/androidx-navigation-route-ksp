@file:Suppress("UnstableApiUsage")

import me.omico.age.dsl.sonatypeSnapshots

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        sonatypeSnapshots(
            groupRegexList = setOf(
                "me.omico.*",
            ),
        )
        gradlePluginPortal {
            content {
                includeGroupByRegex("com.diffplug.spotless.*")
                includeGroupByRegex("com.gradle.*")
                includeGroupByRegex("gradle.plugin.*")
                includeGroupByRegex("org.gradle.*")
                includeGroupByRegex("org.jetbrains.kotlin.*")
            }
        }
        google()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        sonatypeSnapshots(
            groupRegexList = setOf(
                "me.omico.*",
            ),
        )
        gradlePluginPortal {
            content {
                includeGroupByRegex("com.diffplug.spotless.*")
                includeGroupByRegex("com.gradle.*")
                includeGroupByRegex("gradle.plugin.*")
                includeGroupByRegex("org.gradle.*")
                includeGroupByRegex("org.jetbrains.kotlin.*")
            }
        }
        google()
        mavenCentral()
    }
}
