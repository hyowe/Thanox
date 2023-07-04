import tornaco.project.android.thanox.Configs
import tornaco.project.android.thanox.Configs.resPrefix
import tornaco.project.android.thanox.Libs

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
    id("dagger.hilt.android.plugin")
}

android {
    defaultConfig {
        minSdk = Configs.minSdkVersion
        compileSdk = Configs.compileSdkVersion
        targetSdk = Configs.targetSdkVersion
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        compose = true
        buildConfig = true
        aidl = true
        renderScript = false
        resValues = false
        shaders = false
        viewBinding = true
        dataBinding = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = tornaco.project.android.thanox.Compose.composeVersion
    }

    resourcePrefix = resPrefix
}
dependencies {
    implementation(Libs.Kotlin.stdlib)

    implementation(Libs.AndroidX.androidXCore)
    implementation(Libs.AndroidX.appCompat)

    implementation(tornaco.project.android.thanox.Compose.runtimeSaveAble)
    implementation(tornaco.project.android.thanox.Compose.ui)
    implementation(tornaco.project.android.thanox.Compose.runtime)
    implementation(tornaco.project.android.thanox.Compose.material)
    implementation(tornaco.project.android.thanox.Compose.material3)
    implementation(tornaco.project.android.thanox.Compose.material3Adapter)
    implementation(tornaco.project.android.thanox.Compose.activityCompose)
    implementation(tornaco.project.android.thanox.Compose.viewmodel)
    implementation(tornaco.project.android.thanox.Compose.navigationCompose)
    implementation(tornaco.project.android.thanox.Compose.hiltNavigation)
    implementation(tornaco.project.android.thanox.Compose.tooling)
    implementation(tornaco.project.android.thanox.Compose.toolingPreview)
    implementation(tornaco.project.android.thanox.Compose.composeMaterialIconsExtended)
    implementation(Libs.Accompanist.appcompatTheme)
    implementation(Libs.Accompanist.systemUiController)
    implementation(Libs.Accompanist.pager)

    implementation(Libs.Others.glide)
    annotationProcessor(Libs.Others.glideCompiler)
    implementation(Libs.Others.listenablefutureEmpty)

    implementation(tornaco.project.android.thanox.Compose.hiltNavigation)
    implementation(Libs.Hilt.library)
    kapt(Libs.Hilt.googleAndroidCompiler)

    implementation(project(":modules:module_common"))
    implementation(project(":android_framework:base"))
}