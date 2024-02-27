plugins {
    java
    jacoco
    id(libs.plugins.patrikerdesUseLatestVersionsPlugin.get().pluginId) version libs.plugins.patrikerdesUseLatestVersionsPlugin.get().version.displayName
    id(libs.plugins.freefairLombokPLugin.get().pluginId) version libs.plugins.freefairLombokPLugin.get().version.displayName
    id(libs.plugins.benManesVersionsPlugin.get().pluginId) version libs.plugins.benManesVersionsPlugin.get().version.displayName
    id(libs.plugins.johnrengelmanShadowPlugin.get().pluginId) version libs.plugins.johnrengelmanShadowPlugin.get().version.displayName
    id(libs.plugins.littlerobotsVersionCatalogUpdatePlugin.get().pluginId) version libs.plugins.littlerobotsVersionCatalogUpdatePlugin.get().version.displayName
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform(libs.junitBom))
    testImplementation(libs.jupiter)
    testImplementation(libs.spring.boot.starter.test)
    compileOnly(libs.lombok)
    annotationProcessor(libs.lombok)
    implementation(libs.bundles.jacksonBundle)
    implementation(libs.bundles.springBundle)

    testRuntimeOnly(libs.junit.platform.launcher)
}

tasks.test {
    useJUnitPlatform()
}

