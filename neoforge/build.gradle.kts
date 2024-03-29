plugins {
    kotlin("jvm")
    id("net.neoforged.gradle.userdev") version "7.0.80"
}

project.version = properties["modVersion"] as String

base.archivesName.set("temporalsmith-neoforge")

val mcVersion = properties["mcVersion"] as String
var projectId = properties["projectId"] as String
val modId = properties["modId"] as String

java.toolchain.languageVersion.set(JavaLanguageVersion.of(17))

println(
    """
        Java: ${System.getProperty("java.version")}
        JVM: ${System.getProperty("java.vm.version")} (${System.getProperty("java.vendor")})
        Arch: ${System.getProperty("os.arch")}
    """
        .trimIndent())

accessTransformers.file("src/main/resources/META-INF/accesstransformer.cfg")

runs {
    configureEach {
        systemProperty("forge.logging.markers", "SCAN,REGISTRIES,REGISTRYDUMP")
        systemProperty("forge.logging.console.level", "debug")
        modSource(project.sourceSets.main.get())
    }

    create("client") { systemProperty("forge.enabledGameTestNamespaces", modId) }

    create("server") {
        systemProperty("forge.enabledGameTestNamespaces", modId)
        programArguments.set(listOf("--nogui"))
    }

    create("gameTestServer") { systemProperty("forge.enabledGameTestNamespaces", modId) }

    create("data") {
        workingDirectory(file("run-data"))

        programArguments.addAll(
            "--mod",
            modId,
            "--all",
            "--output",
            file("src/generated/resources/").absolutePath,
            "--existing",
            file("src/main/resources/").absolutePath)
    }
}

sourceSets.main { resources.srcDir("src/generated/resources") }

configurations { compileOnly { extendsFrom(configurations.annotationProcessor.get()) } }

dependencies {
    implementation("net.neoforged:neoforge:" + properties["neoForgeVersion"])

    // kotlin forge
    implementation("thedarkcolour:kotlinforforge-neoforge:" + properties["kotlinForForgeVersion"])

    // Logger
    implementation("ch.qos.logback:logback-classic:" + properties["logbackVersion"])
    implementation("ch.qos.logback:logback-core:" + properties["logbackVersion"])

    // core
    implementation("io.github.realyusufismail:realyusufismailcore-neo:" + properties["coreVersion"])

    // The JEI API is declared for compile time use, while the full JEI artifact is used at runtime
    compileOnly("mezz.jei:jei-${mcVersion}-common-api:" + properties["jeiVersion"])
    compileOnly("mezz.jei:jei-${mcVersion}-forge-api:" + properties["jeiVersion"])
    runtimeOnly("mezz.jei:jei-${mcVersion}-neoforge:" + properties["jeiVersion"])

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

tasks.withType(ProcessResources::class.java) {
    val replaceProperties =
        mapOf(
            "minecraft_version" to mcVersion,
            "minecraft_version_range" to "[1.20.4,1.21)",
            "neo_version" to properties["neoForgeVersion"],
            "neo_version_range" to "[20.4)",
            "loader_version_range" to "[4.7,)",
            "mod_id" to modId,
            "mod_license" to "Apache-2.0",
            "mod_version" to project.version,
            "mod_authors" to "RealYusufIsmail",
            "mod_description" to
                """
                Descend into the boundless realms of TemporalSmith, where time intertwines with the craft of the Aetheric Arsenal. Unleash the power of enchanted swords and tools forged beyond the constraints of time. Explore mystical dimensions, each brimming with unique challenges and treasures. Elevate your Minecraft experience with a fusion of temporal mastery, otherworldly landscapes, and an expansive array of armaments. The journey awaits; delve into the time-woven secrets of TemporalSmith. (A lot of stuff to be added)
            """
                    .trimIndent())

    inputs.properties(replaceProperties)

    filesMatching(listOf("META-INF/mods.toml")) { expand(replaceProperties) }
}
