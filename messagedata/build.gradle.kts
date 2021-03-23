plugins {
    kotlin("multiplatform")
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

    jvm {

    }
    ios()


    sourceSets {
        val commonMain by getting {
            dependencies {

            }
        }
    }

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