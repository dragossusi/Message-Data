import org.gradle.kotlin.dsl.`kotlin-dsl`
plugins {
    `kotlin-dsl`
}
repositories {
    mavenCentral()
    google()
}

dependencies{
    implementation("com.android.tools.build:gradle:4.2.2")
//    implementation("maven-publish")
//    implementation("signing")
}