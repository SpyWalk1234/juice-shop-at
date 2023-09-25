plugins {
    java
}
dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.3"))
    testImplementation(platform("io.cucumber:cucumber-bom:7.12.1"))

    testImplementation("io.cucumber:cucumber-java")
    testImplementation("io.cucumber:cucumber-junit-platform-engine")
    testImplementation("org.junit.platform:junit-platform-suite")
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation ("org.seleniumhq.selenium:selenium-java:2.41.0")
    implementation ("io.cucumber:cucumber-jvm:6.7.0")

}

repositories {
    mavenLocal()
    mavenCentral()
}

tasks.withType<Test> {
    useJUnitPlatform()
    // Work around. Gradle does not include enough information to disambiguate
    // between different examples and scenarios.
    systemProperty("cucumber.junit-platform.naming-strategy", "long")
}

