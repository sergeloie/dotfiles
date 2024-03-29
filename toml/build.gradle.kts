/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Java application project to get you started.
 * For more details on building Java & JVM projects, please refer to https://docs.gradle.org/8.5/userguide/building_java_projects.html in the Gradle documentation.
 */

plugins {
    // Apply the application plugin to add support for building a CLI application in Java.
    application
    alias(libs.plugins.freefairLombokPLugin)
    alias(libs.plugins.benManesVersionsPlugin)
    alias(libs.plugins.johnrengelmanShadowPlugin)
    alias(libs.plugins.patrikerdesUseLatestVersionsPlugin)
    alias(libs.plugins.littlerobotsVersionCatalogUpdatePlugin)
    alias(libs.plugins.springFrameworkPlugin)
    alias(libs.plugins.springDependencyManagementPlugin)
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {
//  Use JUnit Jupiter for testing.
    implementation(libs.bundles.springStudy)
    testImplementation(libs.bundles.junitBundle)
    testImplementation(platform(libs.junitBom))

//  testImplementation(libs.jupiter)
    testImplementation(libs.spring.boot.starter.test)
    compileOnly(libs.lombok)
    annotationProcessor(libs.lombok)
    implementation(libs.bundles.jacksonBundle)
//  implementation(libs.bundles.springBundle)

    testRuntimeOnly(libs.junit.platform.launcher)
}

// Apply a specific Java toolchain to ease working on different environments.
java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(20))
    }
}

application {
    // Define the main class for the application.
    mainClass.set("org.example.Main")
}

tasks.named<Test>("test") {
    // Use JUnit Platform for unit tests.
    useJUnitPlatform()
}

