plugins {
    alias(libs.plugins.kotlin.jvm)
}

dependencies {
    compileOnly("org.projectlombok:lombok:1.18.20")
    annotationProcessor("org.projectlombok:lombok:1.18.20")

    implementation(project(":android_framework:base"))
    compileOnly(project(":android_framework:hidden-api"))
}