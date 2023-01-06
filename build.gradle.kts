import net.minecraftforge.gradle.userdev.UserDevExtension

plugins {
    java
    id("com.diffplug.spotless") version "6.6.1"
    id("net.minecraftforge.gradle") version "5.1.+"
    id("org.parchmentmc.librarian.forgegradle") version "1.+"
}

project.group = "io.github.realyusufismail"

project.version = "1.19.3-1.0.0.alpha.1"

base.archivesName.set("armourandtoolsmod")

println(
    """
        Java: ${System.getProperty("java.version")}
        JVM: ${System.getProperty("java.vm.version")} (${System.getProperty("java.vendor")})
        Arch: ${System.getProperty("os.arch")}
    """
        .trimIndent())

java {
    toolchain {
        withJavadocJar()
        withSourcesJar()

        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

configure<UserDevExtension> {
    // mappings channel: "parchment", version: "2022.12.18-1.19.3"
    mappings("official", "1.19.3")

    runs {
        create("client") {
            workingDirectory(file("run"))

            // Recommended logging data for a userdev environment
            property("forge.logging.markers", "SCAN,REGISTRIES,REGISTRYDUMP")

            // Recommended logging level for the console
            property("forge.logging.console.level", "debug")

            mods { create(base.archivesName.get()) { source(sourceSets["main"]) } }
        }

        create("server") {
            workingDirectory(file("run"))

            // Recommended logging data for a userdev environment
            property("forge.logging.markers", "SCAN,REGISTRIES,REGISTRYDUMP")

            // Recommended logging level for the console
            property("forge.logging.console.level", "debug")

            mods { create(base.archivesName.get()) { source(sourceSets["main"]) } }
        }

        create("gameTestServer") {
            workingDirectory(file("run"))

            // Recommended logging data for a userdev environment
            property("forge.logging.markers", "SCAN,REGISTRIES,REGISTRYDUMP")

            // Recommended logging level for the console
            property("forge.logging.console.level", "debug")

            mods { create(base.archivesName.get()) { source(sourceSets["main"]) } }
        }

        create("data") {
            workingDirectory(file("run"))

            taskName = "datagen"

            // Recommended logging data for a userdev environment
            property("forge.logging.markers", "SCAN,REGISTRIES,REGISTRYDUMP")

            // Recommended logging level for the console
            property("forge.logging.console.level", "debug")

            // Specify the mod id for data generation, where to output the resulting resource, and
            // where to look for existing resources.
            args(
                "--mod",
                base.archivesName.get(),
                "--all",
                "--output",
                file("src/generated/resources/"),
                "--existing",
                file("src/main/resources/"))

            mods { create(base.archivesName.get()) { source(sourceSets["main"]) } }
        }
    }
}

repositories { mavenCentral() }

dependencies {
    "minecraft"(
        group = "net.minecraftforge",
        name = "forge",
        version = "1.19.3-44.1.0",
        classifier = "universal")
    // Logger
    implementation(group = "ch.qos.logback", name = "logback-classic", version = "1.4.5")
    implementation(group = "ch.qos.logback", name = "logback-core", version = "1.4.5")
    // test
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.0")
    // core
    implementation(
        group = "io.github.realyusufismail", name = "realyusufismailcore", version = "1.19-1.0.6")
}

tasks.test { useJUnitPlatform() }

configurations { all { exclude(group = "org.slf4j", module = "slf4j-log4j12") } }

spotless {
    java {
        // Excludes build folder since it contains generated java classes.
        targetExclude("build/**")
        eclipse("4.19.0")
            .configFile("${rootProject.rootDir}/meta/formatting/google-style-eclipse.xml")
    }

    kotlinGradle {
        target("**/*.gradle.kts")
        ktfmt("0.42").dropboxStyle()
        trimTrailingWhitespace()
        indentWithSpaces()
        endWithNewline()
    }
}

tasks.javadoc {
    if (JavaVersion.current().isJava9Compatible) {
        (options as StandardJavadocDocletOptions).addBooleanOption("html5", true)
    }
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
    dependsOn(tasks["spotlessApply"])
}
