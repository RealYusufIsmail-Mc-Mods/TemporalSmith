pluginManagement {
    repositories {
        maven(url = uri("https://maven.minecraftforge.net/"))
        maven(url = uri("https://maven.parchmentmc.org"))
        mavenCentral()
        gradlePluginPortal()
    }

    plugins { id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0" }
}
