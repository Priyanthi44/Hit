
buildscript {
    dependencies{
        classpath("com.android.tools.build:gradle:8.13.1")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.10")
        classpath ("com.google.dagger:hilt-android-gradle-plugin:2.40.1")
    }
}




plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
   // alias(libs.plugins.kotlin.compose) apply false
}