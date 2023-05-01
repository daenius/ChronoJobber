repositories {
    mavenCentral()
}

private val kotlinVersion = "1.8.21"
private val kotestVersion = "5.6.1"

plugins {
    kotlin("jvm") version "1.8.21"
    application
}

private val kotestPkgs = listOf(
    "io.kotest:kotest-runner-junit5:$kotestVersion",
    "io.kotest:kotest-assertions-core:$kotestVersion",
    "io.kotest:kotest-property:$kotestVersion"
)

dependencies {
    kotestPkgs.map { testImplementation(it) }
    implementation(kotlin("stdlib-jdk8"))
}

kotlin {
    jvmToolchain(17)
}

tasks {
    withType<Test>().configureEach {
        useJUnitPlatform()
    }
}
