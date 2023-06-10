plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.ksp)
    kotlin("kapt")
}

android {
    namespace = libs.versions.name.app.get()
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        applicationId = libs.versions.name.app.get()
        minSdk = libs.versions.minSdk.get().toInt()
        targetSdk = libs.versions.targetSdk.get().toInt()
        versionCode = libs.versions.versionCode.get().toInt()
        versionName = libs.versions.versionName.get()

        testInstrumentationRunner = libs.versions.testInstrumentationRunner.get()
        vectorDrawables {
            useSupportLibrary = true
        }
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.kotlinCompilerExtension.get()
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(project(path = ":authorization"))
    implementation(project(path = ":splashScreen"))
    implementation(project(path = ":network"))
    implementation(project(path = ":localDb"))
    implementation(project(path = ":profile"))
    implementation(project(path = ":core"))

    implementation(libs.android.coreKtx)
    implementation(libs.android.activityCompose)

    implementation(platform(libs.android.composeBom))
    implementation(libs.bundles.composeUi)

    androidTestImplementation(platform(libs.android.composeBom))
    androidTestImplementation(libs.bundles.tests)
    testImplementation(libs.tests.junit)
    debugImplementation(libs.tests.uiTooling)
    debugImplementation(libs.tests.uiTestManifest)

    implementation(libs.bundles.lifecycle)

    implementation(libs.coroutines)

    implementation(libs.bundles.dagger2)
    kapt(libs.dagger2.compiler)
    annotationProcessor(libs.dagger2.processor)

    implementation(libs.compose.navigationCompose)

}