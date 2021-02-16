// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {

    val kotlin_version by extra("1.4.21")
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:4.0.2")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}")

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

plugins {
    kotlin("jvm") version Versions.kotlin
    `maven-publish`
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}