plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.hilt)
    id("com.google.gms.google-services")
    kotlin("kapt")
}

android {
    namespace = libs.versions.name.featureAuth.get()
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()

        testInstrumentationRunner = libs.versions.testInstrumentationRunner.get()
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
    implementation(project(path = ":domain"))
    implementation(project(path = ":core"))

    // Android
    implementation(libs.android.coreKtx)
    implementation(libs.android.appcompat)
    implementation(libs.android.material)

    // Compose
    implementation(platform(libs.compose.bom))
    implementation(libs.bundles.composeUi)
    debugImplementation(libs.tests.uiTooling)
    implementation(libs.compose.navigationCompose)

    // Hilt
    implementation(libs.bundles.hilt)
    kapt(libs.hilt.compiler)

    // Firebase Auth
    implementation(libs.firebase.auth)

}

kapt {
    correctErrorTypes = true
}