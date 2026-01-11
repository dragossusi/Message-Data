plugins {
  id("com.android.library")
  kotlin("multiplatform")
  id("kotlin-parcelize")
  `maven-publish`
  signing
}

group = "ro.dragossusi"

version = Versions.app

kotlin {
  jvm()
  androidTarget { publishLibraryVariants("release") }
  js(IR) { browser { binaries.library() } }
  iosArm64()

  sourceSets {
    val commonMain by getting { dependencies {} }

    val androidMain by getting {
      dependencies {
        implementation("androidx.core:core-ktx:1.17.0")
        implementation("androidx.appcompat:appcompat:1.7.1")
      }
    }
  }

  jvmToolchain(21)
  compilerOptions.freeCompilerArgs.add("-Xexpect-actual-classes")
}

android {
  compileSdk = Versions.targetSdk
  namespace = "ro.dragossusi.messagedata"

  defaultConfig { minSdk = Versions.minSdk }

  sourceSets {
    getByName("main") {
      manifest.srcFile("src/androidMain/AndroidManifest.xml")
      res.srcDirs("src/androidMain/res")
    }
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
  }

  publishing {
    singleVariant("release") {
      withSourcesJar()
      withJavadocJar()
    }
  }

  kotlin { jvmToolchain(21) }
}

configurePublishing(
    projectName = "Message-Data",
    projectDescription = "Message-Data classes for easier handling",
)
