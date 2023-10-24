import java.net.URL
import org.jetbrains.dokka.base.DokkaBase
import org.jetbrains.dokka.base.DokkaBaseConfiguration
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories { mavenCentral() }

    dependencies {
        val properties = project.properties

        classpath("org.jetbrains.dokka:dokka-base:1.9.0")
        classpath("io.github.realyusufismail:jconfig:1.0.8")
    }
}


plugins {
    kotlin("jvm") version "1.9.10"
    kotlin("plugin.allopen") version "1.9.10"
    id("com.diffplug.spotless") version "6.20.0"
    id("org.jetbrains.dokka") version "1.9.0"
    jacoco // code coverage reports
}

repositories {
    mavenCentral()
}

dependencies {
    val properties = project.properties


    // test
    testImplementation("org.junit.jupiter:junit-jupiter:" + properties["junitVersion"])
}


tasks {
    withType<JavaCompile> {
        options.encoding = "UTF-8"
    }

    withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "17"
    }

    test {
        useJUnitPlatform()
        finalizedBy(jacocoTestReport)
    }


    jacocoTestReport {
        group = "Reporting"
        description = "Generate Jacoco coverage reports after running tests."
        reports {
            xml.required.set(true)
            html.required.set(true)
        }
        finalizedBy("jacocoTestCoverageVerification")
    }

    dokkaHtml {
        dokkaSourceSets.configureEach {
            includes.from("package.md")
            jdkVersion.set(17)
            sourceLink {
                localDirectory.set(file("src/main/kotlin"))
                remoteUrl.set(URL("https://github.com/RealYusufIsmail-Mc-Mods/Armour-and-Tools-Mod/blob/forge/src/main/kotlin"))
                remoteLineSuffix.set("#L")
            }
            sourceLink {
                localDirectory.set(file("src/main/java"))
                remoteUrl.set(URL("https://github.com/RealYusufIsmail-Mc-Mods/Armour-and-Tools-Mod/blob/forge/src/main/java"))
                remoteLineSuffix.set("#L")
            }
            sourceLink {
                localDirectory.set(file("src/main/resources"))
                remoteUrl.set(URL("https://github.com/RealYusufIsmail-Mc-Mods/Armour-and-Tools-Mod/blob/neoforge/src/main/java"))
                remoteLineSuffix.set("#L")
            }
            sourceLink {
                localDirectory.set(file("src/main/resources"))
                remoteUrl.set(URL("https://github.com/RealYusufIsmail-Mc-Mods/Armour-and-Tools-Mod/blob/forge/src/main/kotlin"))
                remoteLineSuffix.set("#L")
            }
            pluginConfiguration<DokkaBase, DokkaBaseConfiguration> {
                footerMessage = "Copyright © 2023 RealYusufIsmail MC Mods"
            }
        }
    }
}

subprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "org.jetbrains.kotlin.plugin.allopen")
    apply(plugin = "com.diffplug.spotless")
    apply(plugin = "org.jetbrains.dokka")
    apply(plugin = "jacoco")

    group = "io.github.realyusufismail"

    configurations { compileOnly { extendsFrom(configurations.annotationProcessor.get()) } }

    sourceSets {
        named("main") {
            resources.srcDir("src/generated/resources")
        }
    }

    repositories {
        mavenCentral()
    }

    dependencies {
        // Lombok
        compileOnly("org.projectlombok:lombok:${properties["lombokVersion"]}")
        annotationProcessor("org.projectlombok:lombok:${properties["lombokVersion"]}")

        // Test dependencies
        testImplementation("org.junit.jupiter:junit-jupiter:${properties["junitVersion"]}")
    }

    tasks {
        withType<Test> {
            useJUnitPlatform()
            finalizedBy(jacocoTestReport)
        }

        jacocoTestReport {
            group = "Reporting"
            description = "Generate Jacoco coverage reports after running tests."
            reports {
                xml.required.set(true)
                html.required.set(true)
            }
            finalizedBy("jacocoTestCoverageVerification")
        }

        withType<JavaCompile> {
            options.encoding = "UTF-8"
            dependsOn(named("spotlessApply"))
        }

        withType<KotlinCompile> {
            kotlinOptions.jvmTarget = "17"
            dependsOn(named("spotlessApply"))
        }

        javadoc {
            if (JavaVersion.current().isJava9Compatible) {
                (options as StandardJavadocDocletOptions).addBooleanOption("html5", true)
            }
        }

        spotless {
            kotlin {
                // Excludes build folder since it contains generated Java classes.
                targetExclude("build/**")
                ktfmt("0.42").dropboxStyle()

                licenseHeader(
                    """
                    /*
                     * Copyright 2023 RealYusufIsmail.
                     *
                     * Licensed under the Apache License, Version 2.0 (the "License");
                     * you may not use this file except in compliance with the License.
                     * You may obtain a copy of the License at
                     * http://www.apache.org/licenses/LICENSE-2.0
                     * Unless required by applicable law or agreed to in writing, software
                     * distributed under the License is distributed on an "AS IS" BASIS,
                     * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
                     * See the License for the specific language governing permissions and
                     * limitations under the License.
                     */
                    """.trimIndent()
                )
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
                    """
                    /*
                     * Copyright 2023 RealYusufIsmail.
                     *
                     * Licensed under the Apache License, Version 2.0 (the "License");
                     * you may not use this file except in compliance with the License.
                     * You may obtain a copy of the License at
                     * http://www.apache.org/licenses/LICENSE-2.0
                     * Unless required by applicable law or agreed to in writing, software
                     * distributed under the License is distributed on an "AS IS" BASIS,
                     * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
                     * See the License for the specific language governing permissions and
                     * limitations under the License.
                     */
                    """.trimIndent()
                )
            }
        }
    }

    java {
        toolchain {
            withJavadocJar()
            withSourcesJar()
            languageVersion.set(JavaLanguageVersion.of(17))
        }
    }
}
