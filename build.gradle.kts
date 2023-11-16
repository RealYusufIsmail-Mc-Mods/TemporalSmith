import java.net.URL
import org.jetbrains.dokka.base.DokkaBase
import org.jetbrains.dokka.base.DokkaBaseConfiguration
import org.jetbrains.dokka.gradle.DokkaTask
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories { mavenCentral() }

    dependencies {
        classpath("org.jetbrains.dokka:dokka-base:1.9.0")
        classpath("io.github.realyusufismail:jconfig:1.0.8")
    }
}

plugins {
    kotlin("jvm") version "1.9.10"
    kotlin("plugin.allopen") version "1.9.20"
    id("com.diffplug.spotless") version "6.20.0"
    id("org.jetbrains.dokka") version "1.9.0"
    id("net.darkhax.curseforgegradle") version "1.1.16"
    jacoco // code coverage reports
}

project.group = "io.github.realyusufismail"

allprojects {
    repositories {
        maven { url = uri("https://thedarkcolour.github.io/KotlinForForge/") }
        maven { url = uri("https://maven.blamejared.com") }
        maven { url = uri("https://dvs1.progwml6.com/files/maven/") }
        maven { url = uri("https://modmaven.dev") }
        maven { url = uri("https://dl.cloudsmith.io/public/geckolib3/geckolib/maven/") }
        mavenCentral()
    }

    configurations { all { exclude(group = "org.slf4j", module = "slf4j-log4j12") } }
}

subprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "jacoco")
    apply(plugin = "com.diffplug.spotless")

    dependencies {
        // Json
        implementation(
            "com.fasterxml.jackson.module:jackson-module-kotlin:" + properties["jacksonVersion"])

        // test
        testImplementation("org.junit.jupiter:junit-jupiter:" + properties["junitVersion"])
    }

    tasks.test {
        useJUnitPlatform()
        finalizedBy(tasks.jacocoTestReport) // report is always generated after tests run
    }

    tasks.jacocoTestReport {
        group = "Reporting"
        description = "Generate Jacoco coverage reports after running tests."
        reports {
            xml.required.set(true)
            html.required.set(true)
        }
        finalizedBy("jacocoTestCoverageVerification")
    }

    spotless {
        kotlin {
            // Excludes build folder since it contains generated java classes.
            targetExclude("build/**")
            ktfmt("0.42").dropboxStyle()

            licenseHeader(
                """/*
 * Copyright 2023 RealYusufIsmail.
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

        java {
            target("**/*.java")
            googleJavaFormat()
            trimTrailingWhitespace()
            indentWithSpaces()
            endWithNewline()
            licenseHeader(
                """/*
 * Copyright 2023 RealYusufIsmail.
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
    }
}

spotless {
    kotlin {
        // Excludes build folder since it contains generated java classes.
        targetExclude("build/**")
        ktfmt("0.42").dropboxStyle()

        licenseHeader(
            """/*
 * Copyright 2023 RealYusufIsmail.
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

    java {
        target("**/*.java")
        googleJavaFormat()
        trimTrailingWhitespace()
        indentWithSpaces()
        endWithNewline()
        licenseHeader(
            """/*
 * Copyright 2023 RealYusufIsmail.
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

tasks.getByName("dokkaHtml", DokkaTask::class) {
    dokkaSourceSets.configureEach {
        includes.from("package.md")
        jdkVersion.set(17)
        sourceLink {
            localDirectory.set(file("src/main/kotlin"))
            remoteUrl.set(
                URL(
                    "https://github.com/RealYusufIsmail-Mc-Mods/Armour-and-Tools-Mod/blob/main/src/main/kotlin"))
            remoteLineSuffix.set("#L")
        }

        sourceLink {
            localDirectory.set(file("src/main/java"))
            remoteUrl.set(
                URL(
                    "https://github.com/RealYusufIsmail-Mc-Mods/Armour-and-Tools-Mod/blob/main/src/main/java"))
            remoteLineSuffix.set("#L")
        }

        pluginConfiguration<DokkaBase, DokkaBaseConfiguration> {
            footerMessage = "Copyright © 2023 RealYusufIsmail MC Mods"
        }
    }
}
