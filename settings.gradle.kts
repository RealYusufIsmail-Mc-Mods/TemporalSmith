pluginManagement {
    repositories {
        maven(url = uri("https://maven.minecraftforge.net/"))
        maven(url = uri("https://maven.parchmentmc.org"))
        mavenCentral()
        gradlePluginPortal()
    }

    plugins { id("net.minecraftforge.gradle") }
}
