object Dependencies {

    // Plugins
    private const val ver_AndroidApplication = "8.2.0-alpha06"
    private const val ver_KotlinAndroid = "1.8.10"

    // Android
    private const val ver_CoreKtx = "1.10.1"
    private const val ver_ActivityCompose = "1.7.2"
    private const val ver_ActivityComposeBom = "2023.05.01"

    // Lifecycle
    private const val ver_LifecycleRuntimeKtx = "2.6.1"

    // Tests
    private const val ver_JUnit = "4.13.2"
    private const val ver_AndroidxTestExtJUnit = "1.1.5"
    private const val ver_EspressoCore = "3.5.1"


    object Plugins {
        const val androidApplication = "com.android.application:$ver_AndroidApplication"
        const val kotlinAndroid = "org.jetbrains.kotlin.android:$ver_KotlinAndroid"
    }

    object Android {
        const val coreKtx = "androidx.core:core-ktx:$ver_CoreKtx"
        const val activityCompose = "androidx.activity:activity-compose:$ver_ActivityCompose"
        const val activityComposeBom = "androidx.compose:compose-bom:$ver_ActivityComposeBom"
        const val composeUi = "androidx.compose.ui:ui"
        const val composeUiGraphics = "androidx.compose.ui:ui-graphics"
        const val composeMaterial3 = "androidx.compose.material3:material3"
    }

    object Lifecycle {
        const val lifecycleRuntimeKtx =
            "androidx.lifecycle:lifecycle-runtime-ktx:$ver_LifecycleRuntimeKtx"
    }

    object Tests {
        const val jUnit = "junit:junit:$ver_JUnit"
        const val extJUnit = "androidx.test.ext:junit:$ver_AndroidxTestExtJUnit"
        const val espressoCore = "androidx.test.espresso:espresso-core:$ver_EspressoCore"
        const val uiTestJunit4 = "androidx.compose.ui:ui-test-junit4"
        const val composeUiTooling = "androidx.compose.ui:ui-tooling"
        const val composeUiToolingPreview = "androidx.compose.ui:ui-tooling-preview"
        const val uiTestManifest = "androidx.compose.ui:ui-test-manifest"
    }

}