plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.furkanmulayim.birikio"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.furkanmulayim.birikio"
        minSdk = 28
        targetSdk = 36
        versionCode = 2
        versionName = "2.0"

        signingConfig = signingConfigs.getByName("debug")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.navigation.runtime.android)
    debugImplementation(libs.androidx.ui.tooling)
    implementation(libs.accompanist.systemuicontroller)

    // Compose Icons
    implementation(libs.compose.icons.extended)

    // Navigation Compose
    implementation(libs.androidx.navigation.compose)

    // RETROFIT
    implementation(libs.retrofit)

    // GSON CONVERT
    implementation(libs.gson.converter)
    implementation(libs.gson)

    // Pager (Like Tab Bars)
    implementation(libs.accompanist.pager)
    implementation(libs.accompanist.pager.indicators)

    // Animation
    implementation(platform(libs.androidx.compose.bom))

    // List Picker (Wheel Picker)
    implementation(libs.compose.wheel.picker)
}