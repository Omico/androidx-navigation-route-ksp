plugins {
    id("com.android.library")
    id("com.google.devtools.ksp")
    kotlin("android")
}

kotlin {
    sourceSets.all {
        kotlin.srcDir("$buildDir/generated/ksp/$name/kotlin")
    }
}

android {
    lint {
        baseline = file("build/reports/lint-baseline.xml")
    }
}

dependencies {
    implementation(projects.annotation)
    ksp(projects.compiler)
}

dependencies {
    implementation(androidx.navigation.compose)
    implementation(androidx.navigation.runtime.ktx)
}
