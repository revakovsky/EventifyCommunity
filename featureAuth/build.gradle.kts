import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties
import java.util.Properties

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.ksp)
    alias(libs.plugins.hilt)
    id("com.google.gms.google-services")
}

android {
    namespace = libs.versions.name.featureAuth.get()
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()

        testInstrumentationRunner = libs.versions.testInstrumentationRunner.get()

//        val properties = Properties()
//        val key = gradleLocalProperties(rootDir).getProperty("Web_client_id")
//        buildConfigField("String", "CLIENT_WEB_ID", key)
    }

    buildTypes {
        debug {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = libs.versions.jvmTarget.get()
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.kotlinCompilerExtension.get()
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    // Modules
    implementation(project(path = ":core"))

    // Android
    implementation(libs.bundles.androidCore)

    // Compose
    implementation(platform(libs.compose.bom))
    implementation(libs.bundles.composeUi)
    implementation(libs.play.services.auth)
    debugImplementation(libs.tests.uiTooling)
    implementation(libs.compose.navigationCompose)

    // Hilt
    implementation(libs.bundles.hilt)
    ksp(libs.hilt.compiler)

    // Firebase
    implementation(libs.bundles.firebase)

}