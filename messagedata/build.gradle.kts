plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("kotlin-parcelize")
    `maven-publish`
    signing
}

group = "ro.dragossusi"
version = Versions.app

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

kotlin {

    android {
        publishLibraryVariants("release","debug")
    }
    jvm()
    ios()


    sourceSets {
        val commonMain by getting {
            dependencies {

            }
        }
        val androidMain by getting {
            dependencies {
                implementation("androidx.core:core-ktx:1.3.2")
                implementation("androidx.appcompat:appcompat:1.2.0")
            }
        }
        val androidTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
                implementation("junit:junit:4.13.2")

            }
        }

    }
}

android {
    compileSdkVersion(30)
    buildToolsVersion("30.0.3")

    defaultConfig {
        minSdkVersion(16)
        targetSdkVersion(30)
        versionCode = 1
        versionName = Versions.app

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    sourceSets {
        getByName("main") {
            manifest.srcFile("src/androidMain/AndroidManifest.xml")
            java.srcDirs("src/androidMain/kotlin")
            res.srcDirs("src/androidMain/res")
        }
        getByName("test") {
            java.srcDirs("src/androidTest/kotlin")
            res.srcDirs("src/androidTest/res")
        }
    }

//    buildTypes {
//        getByName("release") {
//            isMinifyEnabled = false
//            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
//        }
//    }
}

//val sourcesJar by tasks.registering(Jar::class) {
//    classifier = "sources"
//    from(sourceSets.main.get().allSource)
//}


publishing {
    publications {
        publications.withType<MavenPublication> {
            pom {
                name.set("Message-Data")
                description.set("Message-Data classes for easier handling")
                url.set("https://github.com/dragossusi/Message-Data/")
            }
        }
    }
}

apply<PublishPlugin>()
//}