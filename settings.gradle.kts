rootProject.name = "TemporalSmith"

pluginManagement {
    repositories {
        maven(url = uri("https://maven.minecraftforge.net/"))
        maven(url = uri("https://maven.parchmentmc.org"))
        maven(url = uri("https://maven.neoforged.net/releases"))
        maven(url = uri("https://repo.spongepowered.org/repository/maven-public/"))
        mavenCentral()
        gradlePluginPortal()
    }

    plugins {
        id("org.gradle.toolchains.foojay-resolver-convention") version "0.7.0"
        id("org.spongepowered.mixin") version "0.7.0"
    }
}

include("forge")

include("forge-1-16")

include("neoforge")
