import net.minecraftforge.gradle.userdev.UserDevExtension

plugins {
    kotlin("jvm") version "1.9.10"
    id("net.neoforged.gradle") version "[6.0.18,6.2)"
    id("org.parchmentmc.librarian.forgegradle") version "1.+"
}

project.version = properties["modVersion"] as String

base.archivesName.set("armourandtoolsmod-neoforge")

val mcVersion = properties["mcVersion"] as String
var projectId = properties["projectId"] as String
val modId = properties["modId"] as String

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

            mods { create(modId) { source(sourceSets["main"]) } }
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

            mods { create(modId) { source(sourceSets["main"]) } }
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

            mods { create(modId) { source(sourceSets["main"]) } }
        }

        create("data") {
            workingDirectory(file("run-data"))
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
                modId,
                "--all",
                "--output",
                file("src/generated/resources/"),
                "--existing",
                file("src/main/resources/"))

            mods { create(modId) { source(sourceSets["main"]) } }

            // 'runData' is renamed to 'runDataGenerator' to make it more clear what it does.
            taskName = "runDataGenerator"
        }
    }
}

sourceSets.main { resources.srcDir("src/generated/resources") }

configurations { compileOnly { extendsFrom(configurations.annotationProcessor.get()) } }

dependencies {
    minecraft("net.neoforged:forge:${mcVersion}-" + properties["neoForgeVersion"])

    // kotlin forge
    implementation("thedarkcolour:kotlinforforge:" + properties["kotlinForForgeVersion"])

    // Logger
    implementation("ch.qos.logback:logback-classic:" + properties["logbackVersion"])
    implementation("ch.qos.logback:logback-core:" + properties["logbackVersion"])

    // core
    implementation("io.github.realyusufismail:realyusufismailcore-neo:" + properties["coreVersion"])

    // The JEI API is declared for compile time use, while the full JEI artifact is used at runtime
    compileOnly(fg.deobf("mezz.jei:jei-${mcVersion}-common-api:" + properties["jeiVersion"]))
    compileOnly(fg.deobf("mezz.jei:jei-${mcVersion}-forge-api:" + properties["jeiVersion"]))
    runtimeOnly(fg.deobf("mezz.jei:jei-${mcVersion}-forge:" + properties["jeiVersion"]))

    // lombok
    compileOnly("org.projectlombok:lombok:" + properties["lombokVersion"])
    annotationProcessor("org.projectlombok:lombok:" + properties["lombokVersion"])
}

tasks.create("cfPublish", net.darkhax.curseforgegradle.TaskPublishCurseForge::class) {
    group = "CurseForge"
    dependsOn("build")
    disableVersionDetection()

    val token =
        if (project.findProperty("curseforge.token") != null)
            project.property("curseforge.token") as String
        else ""
    apiToken = token

    val jar = file("build/libs/${base.archivesName.get()}-${project.version}.jar")

    // The main file to upload
    val mainFile = upload(projectId, jar)
    mainFile.changelog = file("CHANGELOG.md").readText()
    mainFile.changelogType = "markdown"
    mainFile.releaseType = "release"
    mainFile.addEmbedded("kotlin-for-forge")
    mainFile.addEmbedded("realyusufismail-core")
    mainFile.addJavaVersion("Java 17")
    mainFile.addModLoader("NeoForge")
    mainFile.addGameVersion(mcVersion)
}
