plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.example.weatherapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.weatherapp"
        minSdk = 24
        targetSdk = 35
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
    implementation(libs.androidx.runtime.livedata)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    // Jetpack Compose
    implementation ("androidx.compose.ui:ui:1.4.0")
    implementation ("androidx.compose.material:material:1.4.0")
    implementation ("androidx.compose.ui:ui-tooling-preview:1.4.0")
    implementation ("androidx.navigation:navigation-compose:2.5.3")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1") // Для работы с LiveData
    implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.1") // ViewModel для Compose

    implementation ("com.jakewharton.threetenabp:threetenabp:1.3.1")


    // Retrofit для работы с API
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation( "com.squareup.retrofit2:converter-gson:2.9.0")

    // Coroutine для асинхронных операций
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")

    // Gson для парсинга JSON
    implementation ("com.google.code.gson:gson:2.8.8")

    // OkHttp для HTTP запросов
    implementation ("com.squareup.okhttp3:okhttp:4.9.3")
    implementation ("androidx.compose.ui:ui:<version>")
    implementation ("androidx.compose.material:material:<version>")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:<version>")
    implementation ("androidx.compose.material3:material3:1.0.0")
    implementation ("androidx.compose.material:material:1.4.0") // Для других компонентов Material
    implementation ("androidx.compose.ui:ui:1.4.0")
}
