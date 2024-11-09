plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("kotlin-kapt")
    id ("dagger.hilt.android.plugin")
}

android {
    namespace = "com.gymshark.hits"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.gymshark.hits"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
        multiDexEnabled = true
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
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

//    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    implementation("androidx.multidex:multidex:2.0.1")
    //Dagger - Hilt
    implementation ("com.google.dagger:hilt-android:2.39")
    implementation ("androidx.hilt:hilt-navigation-compose:1.0.0")

    implementation ("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03")
// Dagger - Hilt
    annotationProcessor ("com.google.dagger:hilt-android-compiler:2.39")
    implementation ("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03")
    annotationProcessor ("androidx.hilt:hilt-compiler:1.0.0")


    // Retrofit
    implementation("com.squareup.okhttp3:okhttp:2.9.0")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.retrofit2:converter-moshi:2.9.0")
  0
    // JSON Converter
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")

    //material icons - use with caution!
    // implementation "androidx.compose.material:material-icons-extended:$compose_version"
    // Coroutines
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.2")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-play-services:1.5.2")
    testImplementation ("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.5.2")

    // Coroutine Lifecycle Scopes
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.0")
    //lifecycle
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.4.0")

    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.5")

    // Coil
    implementation("io.coil-kt:coil-compose:2.7.0")

    //Room
    implementation ("androidx.room:room-runtime:2.3.0")
    annotationProcessor ("androidx.room:room-compiler:2.3.0")
// Moshi
    implementation ("com.squareup.moshi:moshi:1.15.0")
    implementation ("com.squareup.moshi:moshi-kotlin:1.15.0")

// Moshi converter for Retrofit
    implementation ("com.squareup.retrofit2:converter-moshi:2.9.0")

// Optional: Code generation for better performance
    kapt ("com.squareup.moshi:moshi-kotlin-codegen:1.15.0")
    // To use Kotlin annotation processing tool (kapt) MUST HAVE!
    kapt("androidx.room:room-compiler:2.3.0")
    implementation ("androidx.room:room-ktx:2.3.0")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.1")
    implementation ("androidx.lifecycle:lifecycle-viewmodel:2.8.7")

    implementation ("androidx.core:core-ktx:1.7.0")
    implementation ("androidx.appcompat:appcompat:1.4.0")
    implementation ("com.google.android.material:material:1.4.0")
    implementation ("androidx.compose.ui:ui:1.0.5")
    implementation ("androidx.compose.material:material:1.0.5")
    implementation ("androidx.compose.ui:ui-tooling-preview:1.0.5")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.4.0")
    implementation ("androidx.activity:activity-compose:1.4.0")
    testImplementation ("junit:junit:4.+")
    androidTestImplementation ("androidx.test.ext:junit:1.1.3")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.4.0")
    androidTestImplementation ("androidx.compose.ui:ui-test-junit4:1.0.5")
    debugImplementation ("androidx.compose.ui:ui-tooling:1.0.5")
    testImplementation ("androidx.arch.core:core-testing:2.1.0")



}