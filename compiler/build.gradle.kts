plugins {
    kotlin("jvm")
}

dependencies {
    implementation(projects.annotation)
}

dependencies {
    implementation(kotlinpoet)
    implementation(kotlinpoet.ksp)
    implementation(ksp.api)
}
