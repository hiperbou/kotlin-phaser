plugins {
    kotlin("multiplatform") version "1.7.10"
    id("convention.publication")
}

group = "io.github.hiperbou.phaser"
version = "2.6.2-01"

repositories {
    mavenCentral()
}

kotlin {
    js(LEGACY) {
        browser {
        }
    }
    sourceSets {
        val jsMain by getting
    }
}
