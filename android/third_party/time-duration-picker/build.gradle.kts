import tornaco.project.android.thanox.Configs

plugins {
    alias(libs.plugins.agp.lib)
}

android {
    namespace = "mobi.upod.timedurationpicker"

    buildFeatures {
        compose = false
        buildConfig = true
        aidl = true
        renderScript = false
        resValues = false
        shaders = false
        viewBinding = true
        dataBinding = true
    }
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
}


