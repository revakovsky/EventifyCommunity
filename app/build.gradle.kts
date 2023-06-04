plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
}

android {
    namespace = Config.namespace
    compileSdk = Config.compileSdk

    defaultConfig {
        applicationId = Config.applicationId
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk
        versionCode = Config.versionCode
        versionName = Config.versionName

        testInstrumentationRunner = Config.testInstrumentationRunner
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
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(Dependencies.Android.coreKtx)
    implementation(Dependencies.Android.activityCompose)
    implementation(platform(Dependencies.Android.activityComposeBom))
    implementation(Dependencies.Android.composeUi)
    implementation(Dependencies.Android.composeUiGraphics)
    implementation(Dependencies.Android.composeMaterial3)

    implementation(Dependencies.Lifecycle.lifecycleRuntimeKtx)

    testImplementation(Dependencies.Tests.jUnit)
    androidTestImplementation(Dependencies.Tests.extJUnit)
    androidTestImplementation(Dependencies.Tests.espressoCore)
    androidTestImplementation(platform(Dependencies.Android.activityComposeBom))
    androidTestImplementation(Dependencies.Tests.uiTestJunit4)
    debugImplementation(Dependencies.Tests.composeUiTooling)
    implementation(Dependencies.Tests.composeUiToolingPreview)
    debugImplementation(Dependencies.Tests.uiTestManifest)

}