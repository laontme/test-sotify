plugins {
    kotlin("jvm") version "1.7.0"
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

repositories {
    mavenCentral()
    maven("https://papermc.io/repo/repository/maven-public/")
}

dependencies {
    implementation("org.bstats:bstats-bukkit:3.0.0")
    compileOnly("io.papermc.paper:paper-api:1.19-R0.1-SNAPSHOT")
}

tasks {
    processResources {
        filesMatching("plugin.yml") {
            expand(
                "name" to rootProject.name.capitalize(),
                "version" to version,
                "author" to project.property("author"),
                "description" to project.description,
                "api" to project.property("api"),
                "main" to "${project.group}.${rootProject.name}.${rootProject.name.capitalize()}"
            )
        }
    }
    jar {
        archiveClassifier.set("noshade")
    }
    shadowJar {
        archiveClassifier.set("")

        relocate("org.bstats", "me.laont.sotify")
    }
    build {
        dependsOn(shadowJar)
    }
}