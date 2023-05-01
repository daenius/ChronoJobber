repositories {
    mavenCentral()
}

private val kotlinVersion = "1.8.21"
private val kotlinCoroutinesVersion = "1.7.0-RC"
private val kotestVersion = "5.6.1"

plugins {
    kotlin("jvm") version "1.8.21"
    application
}

private val kotestPkgs = listOf(
    "io.kotest:kotest-runner-junit5:$kotestVersion",
    "io.kotest:kotest-assertions-core:$kotestVersion",
    "io.kotest:kotest-property:$kotestVersion",
    "io.kotest:kotest-property:$kotestVersion"
)

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$kotlinCoroutinesVersion")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:$kotlinCoroutinesVersion")
    kotestPkgs.map { testImplementation(it) }
}

kotlin {
    jvmToolchain(17)
}

application {
    mainClass.set("com.chronojobber.MainKt")
}

tasks {
    withType<Test>().configureEach {
        useJUnitPlatform()
    }
}
