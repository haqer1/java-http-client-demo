import org.gradle.api.tasks.testing.logging.TestExceptionFormat

plugins {
    java
}

repositories {
    mavenCentral()
}

dependencies {
    // Use JUnit Jupiter for testing.
    testImplementation(libs.junit.jupiter)

    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    testImplementation(libs.wiremock)
    testImplementation(libs.logback.core)
    testImplementation(libs.logback.classic)
}

// Apply a specific Java toolchain to ease working on different environments.
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

tasks.named<Test>("test") {
    testLogging {
        events("standardOut", "standardError", "started", "passed", "skipped", "failed")
    }
    testLogging.showStandardStreams = true
    testLogging.exceptionFormat = TestExceptionFormat.FULL
    // Use JUnit Platform for unit tests.
    useJUnitPlatform()
}
