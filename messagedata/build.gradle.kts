plugins {
    kotlin("jvm")
    `maven-publish`
    signing
}

group = "ro.dragossusi"
version = Versions.app
//artifactId = "errordata"

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation("org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}")

    testImplementation("junit:junit:4.13.1")
}

val sourcesJar by tasks.registering(Jar::class) {
    classifier = "sources"
    from(sourceSets.main.get().allSource)
}

//afterEvaluate {
publishing {
    publications {
        // Creates a Maven publication called "release".
        create<MavenPublication>("java") {
            // Applies the component for the release build variant.
            from(components["java"])
            artifact(sourcesJar.get())

            // You can then customize attributes of the publication as shown below.
            groupId = Details.groupId
            artifactId = "messagedata"
            version = Versions.app

            pom {
                name.set("MessageData")
                description.set("Message classes for easier handling")
                url.set("https://github.com/dragossusi/Message-Data/")
                scm {
                    connection.set("scm:git:git://github.com/dragossusi/Message-Data.git")
                    developerConnection.set("scm:git:ssh://github.com/dragossusi/Message-Data.git")
                    url.set("https://github.com/dragossusi/Message-Data/")
                }
            }
        }
    }
}

apply<PublishPlugin>()
//}