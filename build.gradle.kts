// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()  // Maven Central repository
        maven { url = uri("https://jitpack.io" ) }
    }
    dependencies {
        classpath("com.android.tools.build:gradle:8.1.2")
    }
}


plugins {
    id("com.android.application") version "8.1.1" apply false
    id("org.jetbrains.kotlin.android") version "1.8.0" apply false
    id("com.android.library") version "7.4.1" apply false
}