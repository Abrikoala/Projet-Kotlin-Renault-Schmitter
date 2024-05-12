plugins {
    kotlin("jvm") version "1.6.10"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://repo.spring.io/milestone")

}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}