import org.gradle.api.Project
import org.gradle.api.publish.PublishingExtension
import org.gradle.api.publish.maven.MavenPublication
import org.gradle.api.publish.maven.plugins.MavenPublishPlugin
import org.gradle.api.publish.maven.tasks.AbstractPublishToMaven
import org.gradle.api.tasks.bundling.Jar
import org.gradle.kotlin.dsl.*
import org.gradle.plugins.signing.Sign
import org.gradle.plugins.signing.SigningExtension
import org.gradle.plugins.signing.SigningPlugin

fun Project.configurePublishing(projectName: String, projectDescription: String) {
  apply<MavenPublishPlugin>()
  apply<SigningPlugin>()

  version = Versions.app
  group = Details.groupId

  val emptyJavadocJar by tasks.registering(Jar::class) { archiveClassifier.set("javadoc") }

  extensions.configure<PublishingExtension>("publishing") {
    setupPublication(projectName, projectDescription, property("SCM_NAME").toString())

    publications {
      publications.withType<MavenPublication>().all { artifact(emptyJavadocJar.get()) }
    }

    setupRepos(project)
  }

  setupSigning()
}

private fun PublishingExtension.setupPublication(
    projectName: String,
    projectDescription: String,
    scmName: String,
) {
  val githubUrl = "https://github.com/dragossusi/$scmName/"
  publications.withType<MavenPublication> {
    version = Versions.app
    groupId = Details.groupId

    pom {
      name.set(projectName)
      description.set(projectDescription)
      url.set(githubUrl)

      licenses {
        license {
          name.set("The Apache License, Version 2.0")
          url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
        }
      }

      developers {
        developer {
          id.set("dragossusi")
          name.set("Dragos Rachieru")
          email.set("rachierudragos97@gmail.com")
        }
      }

      scm {
        connection.set("scm:git:git://github.com/dragossusi/$scmName.git")
        developerConnection.set("scm:git:ssh://github.com/dragossusi/$scmName.git")
        url.set(githubUrl)
      }
    }
  }
}

private fun PublishingExtension.setupRepos(project: Project) {
  val sonatypeUsername =
      checkNotNull(project.findProperty("sonatype.username")) { "Missing username" }
  val sonatypePassword =
      checkNotNull(project.findProperty("sonatype.password")) { "Missing password" }

  repositories {
    maven {
      name = "sonatype"
      url = project.uri("https://ossrh-staging-api.central.sonatype.com/service/local/staging/deploy/maven2/")
      credentials {
        username = sonatypeUsername.toString()
        password = sonatypePassword.toString()
      }
    }
  }
}

private fun Project.setupSigning() {
  extensions.configure<SigningExtension>("signing") {
    sign(the<PublishingExtension>().publications)
  }

  // Resolve the dependency conflict between signing and publishing
  tasks.withType<AbstractPublishToMaven> {
    val signingTasks = tasks.withType<Sign>()
    mustRunAfter(signingTasks)
  }
}
