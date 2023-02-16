import io.gitlab.arturbosch.detekt.Detekt
import net.minecraftforge.gradle.userdev.UserDevExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.8.0"
    kotlin("plugin.allopen") version "1.8.10"
    id("com.diffplug.spotless") version "6.14.0"
    id("net.minecraftforge.gradle") version "5.1.+"
    id("org.parchmentmc.librarian.forgegradle") version "1.+"
    id("io.gitlab.arturbosch.detekt") version "1.22.0"
    jacoco // code coverage reports
}

project.group = "io.github.realyusufismail"

project.version = "1.19.3-1.0.0.alpha.8"

base.archivesName.set("armourandtoolsmod")

println(
    """
        Java: ${System.getProperty("java.version")}
        JVM: ${System.getProperty("java.vm.version")} (${System.getProperty("java.vendor")})
        Arch: ${System.getProperty("os.arch")}
    """
        .trimIndent())

configure<UserDevExtension> {
    mappings("parchment", "2022.12.18-1.19.3")

    runs {
        create("client") {
            workingDirectory(file("run"))

            // add mixin
            property("mixin.env.remapRefMap", "true")
            property(
                "mixin.env.refMapRemappingFile", "${projectDir}/build/createSrgToMcp/output.srg")

            // Recommended logging data for a userdev environment
            property("forge.logging.markers", "SCAN,REGISTRIES,REGISTRYDUMP")

            // Recommended logging level for the console
            property("forge.logging.console.level", "debug")

            mods { create(base.archivesName.get()) { source(sourceSets["main"]) } }
        }

        create("server") {
            workingDirectory(file("run"))

            // add mixin
            property("mixin.env.remapRefMap", "true")
            property(
                "mixin.env.refMapRemappingFile", "${projectDir}/build/createSrgToMcp/output.srg")

            // Recommended logging data for a userdev environment
            property("forge.logging.markers", "SCAN,REGISTRIES,REGISTRYDUMP")

            // Recommended logging level for the console
            property("forge.logging.console.level", "debug")

            mods { create(base.archivesName.get()) { source(sourceSets["main"]) } }
        }

        create("gameTestServer") {
            workingDirectory(file("run"))

            // add mixin
            property("mixin.env.remapRefMap", "true")
            property(
                "mixin.env.refMapRemappingFile", "${projectDir}/build/createSrgToMcp/output.srg")

            // Recommended logging data for a userdev environment
            property("forge.logging.markers", "SCAN,REGISTRIES,REGISTRYDUMP")

            // Recommended logging level for the console
            property("forge.logging.console.level", "debug")

            mods { create(base.archivesName.get()) { source(sourceSets["main"]) } }
        }

        create("data") {
            workingDirectory(file("run"))
            // add mixin
            property("mixin.env.remapRefMap", "true")
            property(
                "mixin.env.refMapRemappingFile", "${projectDir}/build/createSrgToMcp/output.srg")

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

            // 'runData' is renamed to 'runDataGenerator' to make it more clear what it does.
            taskName = "runDataGenerator"
        }
    }
}

sourceSets.main { resources.srcDir("src/generated/resources") }

repositories {
    maven { url = uri("https://thedarkcolour.github.io/KotlinForForge/") }
    maven { url = uri("https://maven.blamejared.com") }
    mavenCentral()
}

dependencies {
    "minecraft"(
        group = "net.minecraftforge",
        name = "forge",
        version = "1.19.3-44.1.0",
        classifier = "universal")
    // kotlin forge
    implementation("thedarkcolour:kotlinforforge:4.0.0")
    // Logger
    implementation(group = "ch.qos.logback", name = "logback-classic", version = "1.4.5")
    implementation(group = "ch.qos.logback", name = "logback-core", version = "1.4.5")
    // test
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.2")
    // core
    implementation(
        group = "io.github.realyusufismail", name = "realyusufismailcore", version = "1.19-1.0.7")
    // Patchouli
    compileOnly(fg.deobf("vazkii.patchouli:Patchouli:1.19.3-78:api"))
    runtimeOnly(fg.deobf("vazkii.patchouli:Patchouli:1.19.3-78"))
}

tasks.test {
    useJUnitPlatform()
    finalizedBy(tasks.jacocoTestReport) // report is always generated after tests run
}

configurations { all { exclude(group = "org.slf4j", module = "slf4j-log4j12") } }

spotless {
    kotlin {
        // Excludes build folder since it contains generated java classes.
        targetExclude("build/**")
        ktfmt("0.42").dropboxStyle()

        licenseHeader(
            """/*
 * Copyright 2022 RealYusufIsmail.
 *
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *
 * you may not use this file except in compliance with the License.
 *
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */ """)
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

java {
    toolchain {
        withJavadocJar()
        withSourcesJar()

        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

tasks.withType<KotlinCompile> { kotlinOptions.jvmTarget = "17" }

tasks.jacocoTestReport {
    group = "Reporting"
    description = "Generate Jacoco coverage reports after running tests."
    reports {
        xml.required.set(true)
        html.required.set(true)
    }
    finalizedBy("jacocoTestCoverageVerification")
}

detekt {
    config = files("gradle/config/detekt.yml")
    baseline = file("gradle/config/detekt-baseline.xml")
    allRules = false
}

tasks.withType<Detekt>().configureEach {
    reports {
        xml.required.set(true)
        html.required.set(true)
    }
}
