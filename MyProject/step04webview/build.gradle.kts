plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.step04_webview"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.step04_webview"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
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

    //이 파일을 수정하고 우상단에 Sync Now 링크를 눌러야 적용이 된다
    buildFeatures {
        viewBinding = true //view binding 을 가능하게 하기 위한 설정
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}