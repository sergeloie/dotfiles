
plugins {
    application
    idea
    java
    jacoco
    checkstyle
    id("se.patrikerdes.use-latest-versions") version "0.2.18"
    id("com.github.ben-manes.versions") version "0.49.0"
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

repositories {
    mavenCentral()
    google()
}

dependencies {

    implementation ("org.apache.commons:commons-lang3:3.13.0")

    implementation ("com.fasterxml.jackson.core:jackson-core:2.16.0-rc1")
    implementation ("com.fasterxml.jackson.core:jackson-databind:2.16.0-rc1")
    implementation ("com.fasterxml.jackson.core:jackson-annotations:2.16.0-rc1")

    implementation("com.google.guava:guava:32.1.3-jre")
    
    implementation("info.picocli:picocli:4.7.5")

    testImplementation("org.junit.jupiter:junit-jupiter-params:5.10.1")
    testImplementation("org.slf4j:slf4j-log4j12:2.0.9")
    testImplementation("org.assertj:assertj-core:3.24.2")
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.1")

    testRuntimeOnly("org.junit.platform:junit-platform-launcher:1.10.1")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

application {
    mainClass.set("io.hexlet.App")
}

tasks.test {
    useJUnitPlatform()
    minHeapSize = "1024m"
    maxHeapSize = "4096m"
}

tasks.shadowJar {
    mergeServiceFiles()
}

tasks.jacocoTestReport {
    reports {
        xml.required = true
        html.outputLocation = layout.buildDirectory.dir("jacocoHtml")
    }
}

jacoco {
    reportsDirectory = layout.buildDirectory.dir("customJacocoReportDir")
}
