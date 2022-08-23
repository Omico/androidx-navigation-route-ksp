plugins {
    kotlin("jvm")
}

dependencies {
    compileOnly(projects.annotation)
}

dependencies {
    implementation(kotlinpoet)
    implementation(kotlinpoet.ksp)
    implementation(ksp.api)
}
