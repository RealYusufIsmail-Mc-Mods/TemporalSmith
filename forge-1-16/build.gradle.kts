buildscript {
    repositories {
        maven(url = "https://maven.minecraftforge.net")
        mavenCentral()
    }
    dependencies {
        classpath(group = "net.minecraftforge.gradle", name = "ForgeGradle", version = "5.1.+", changing = true)
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.0")
    }
}

plugins {
    kotlin("jvm")
    id("net.minecraftforge.gradle")
    id("org.parchmentmc.librarian.forgegradle") version "1.+"
}

base.archivesName.set("temporalsmith-forge")
project.version = properties["modVersion"] as String
val mcVersion = properties["mcVersion"] as String
var projectId = properties["projectId"] as String
val modId = properties["modId"] as String

java.toolchain.languageVersion = JavaLanguageVersion.of(8)

println("Java: ${System.getProperty("java.version")} JVM: ${System.getProperty("java.vm.version")}(${System.getProperty("java.vendor")}) Arch: ${System.getProperty("os.arch")}")

configure<UserDevExtension> {
    mappings("parchment", "2022.03.06-$mcVersion")

    //accessTransformer("src/main/resources/META-INF/accesstransformer.cfg")

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

            mods { create(base.archivesName.get()) { source(sourceSets["main"]) } }
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


sourceSets {
    main.resources {
        srcDir("src/generated/resources")
    }
}

configurations { compileOnly { extendsFrom(configurations.annotationProcessor.get()) } }

dependencies {
    minecraft("net.minecraftforge:forge:" + properties["forgeVersion"])

    // kotlin forge
    implementation("thedarkcolour:kotlinforforge:" + properties["kotlinForForgeVersion"])

    // Logger
    implementation("ch.qos.logback:logback-classic:" + properties["logbackVersion"])
    implementation("ch.qos.logback:logback-core:" + properties["logbackVersion"])

    // core
    implementation("io.github.realyusufismail:realyusufismailcore:" + properties["coreVersion"])

    // The JEI API is declared for compile time use, while the full JEI artifact is used at runtime
    compileOnly(fg.deobf("mezz.jei:jei-${mcVersion}-common-api:" + properties["jeiVersion"]))
    compileOnly(fg.deobf("mezz.jei:jei-${mcVersion}-forge-api:" + properties["jeiVersion"]))
    runtimeOnly(fg.deobf("mezz.jei:jei-${mcVersion}-forge:" + properties["jeiVersion"]))

    // lombok
    compileOnly("org.projectlombok:lombok:" + properties["lombokVersion"])
    annotationProcessor("org.projectlombok:lombok:" + properties["lombokVersion"])
}

tasks.jar {
    manifest {
        attributes(
            mapOf(
                "Specification-Title" to "realyusufismailcore",
                "Specification-Vendor" to "Yusuf.I",
                "Specification-Version" to "1",
                "Implementation-Title" to project.name,
                "Implementation-Version" to version,
                "Implementation-Vendor" to "Yusuf.I",
                "Implementation-Timestamp" to Date().format("yyyy-MM-dd'T'HH:mm:ssZ")
            )
        )
    }
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
    mainFile.addModLoader("forge")
    mainFile.addGameVersion(mcVersion)
}
