import net.minecraftforge.gradle.common.util.RunConfig
import net.minecraftforge.gradle.userdev.UserDevExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.9.10"
    kotlin("plugin.allopen") version "1.9.10"
    id("eclipse")
    id("net.minecraftforge.gradle") version "[6.0.14,6.2)"
    id("org.parchmentmc.librarian.forgegradle") version "1.+"
    id("net.darkhax.curseforgegradle") version "1.1.16"
    id("com.diffplug.spotless") version "6.20.0"
    id("org.jetbrains.dokka") version "1.9.0"
    jacoco // code coverage reports
}

project.version = "1.20.1-1.0.7.beta1"

base.archivesName.set("armourandtoolsmod")

val mcVersion = "1.20.1"
var projectId = "480779"

java.toolchain.languageVersion.set(JavaLanguageVersion.of(17))

// Print Java and JVM information
println(
    """
    Java: ${System.getProperty("java.version")}
    JVM: ${System.getProperty("java.vm.version")} (${System.getProperty("java.vendor")})
    Arch: ${System.getProperty("os.arch")}
    """
        .trimIndent())

configure<UserDevExtension> {
    mappings("parchment", "2023.09.03-$mcVersion")

    accessTransformer("src/main/resources/META-INF/accesstransformer.cfg")

    runs {
        fun createMixinCommon(runConfig: RunConfig) {
            // add mixin
            runConfig.property("mixin.env.remapRefMap", "true")
            runConfig.property(
                "mixin.env.refMapRemappingFile", "${projectDir}/build/createSrgToMcp/output.srg")

            // Recommended logging data for a userdev environment
            runConfig.property("forge.logging.markers", "SCAN,REGISTRIES,REGISTRYDUMP")

            // Recommended logging level for the console
            runConfig.property("forge.logging.console.level", "debug")
        }

        create("client") {
            workingDirectory(file("run"))
            createMixinCommon(this)
            mods { create(base.archivesName.get()) { source(sourceSets["main"]) } }
        }

        create("server") {
            workingDirectory(file("run"))
            createMixinCommon(this)
            mods { create(base.archivesName.get()) { source(sourceSets["main"]) } }
        }

        create("gameTestServer") {
            workingDirectory(file("run"))
            createMixinCommon(this)
            mods { create(base.archivesName.get()) { source(sourceSets["main"]) } }
        }

        create("data") {
            workingDirectory(file("run-data"))
            createMixinCommon(this)
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

sourceSets { named("main") { resources.srcDir("src/generated/resources") } }

repositories {
    maven { url = uri("https://thedarkcolour.github.io/KotlinForForge/") }
    maven { url = uri("https://maven.blamejared.com") }
    maven { url = uri("https://dvs1.progwml6.com/files/maven/") }
    maven { url = uri("https://modmaven.dev") }
    maven { url = uri("https://dl.cloudsmith.io/public/geckolib3/geckolib/maven/") }
    mavenCentral()
}

dependencies {
    minecraft("net.minecraftforge:forge:" + properties["forgeVersion"])

    // kotlin forge
    implementation("thedarkcolour:kotlinforforge:" + properties["kotlinForForgeVersion"])

    // Logger
    implementation("ch.qos.logback:logback-classic:" + properties["logbackVersion"])
    implementation("ch.qos.logback:logback-core:" + properties["logbackVersion"])

    // Other mods
    implementation("io.github.realyusufismail:realyusufismailcore:" + properties["coreVersion"])
    compileOnly(fg.deobf("mezz.jei:jei-${mcVersion}-common-api:" + properties["jeiVersion"]))
    compileOnly(fg.deobf("mezz.jei:jei-${mcVersion}-forge-api:" + properties["jeiVersion"]))
    runtimeOnly(fg.deobf("mezz.jei:jei-${mcVersion}-forge:" + properties["jeiVersion"]))
}

tasks.create("cfPublish", net.darkhax.curseforgegradle.TaskPublishCurseForge::class) {
    group = "CurseForge"
    dependsOn("build")
    disableVersionDetection()

    val token = project.findProperty("curseforge.token") as String? ?: ""
    apiToken = token

    val jar = file("build/libs/${base.archivesName.get()}-${project.version}.jar")
    val mainFile = upload(projectId, jar)
    mainFile.changelog = file("CHANGELOG.md").readText()
    mainFile.changelogType = "markdown"
    mainFile.releaseType = "release"
    mainFile.addEmbedded("kotlin-for-forge")
    mainFile.addEmbedded("realyusufismail-core")
    mainFile.addJavaVersion("Java 17")
    mainFile.addModLoader("forge")
    mainFile.addGameVersion(mcVersion)
}

tasks.withType<KotlinCompile> { kotlinOptions.jvmTarget = "17" }

tasks.javadoc {
    if (JavaVersion.current().isJava9Compatible) {
        (options as StandardJavadocDocletOptions).addBooleanOption("html5", true)
    }
}

java {
    withJavadocJar()
    withSourcesJar()
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
    dependsOn(tasks["spotlessApply"])
}
