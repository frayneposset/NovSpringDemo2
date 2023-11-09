import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.1.5"
    id("io.spring.dependency-management") version "1.1.3"
    kotlin("jvm") version "1.8.22"
    kotlin("plugin.spring") version "1.8.22"
    kotlin("plugin.jpa") version "1.8.22"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")


    //Kotest
    testImplementation("io.kotest:kotest-runner-junit5-jvm:4.6.1") // for kotest framework
    testImplementation("io.kotest:kotest-assertions-core-jvm:4.6.1") // for kotest core assertions
    testImplementation("io.kotest:kotest-property-jvm:4.6.1") // for property testing

    //MockK
    testImplementation("io.mockk:mockk:1.10.6") // for mocking in Kotlin

    //Spring
    implementation("org.springframework.boot:spring-boot-starter-web:2.5.3") // for web module
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:2.5.3") // for data jpa

    //Jakarta
    implementation("jakarta.servlet:jakarta.servlet-api:4.0.4") // for Servlet API

    developmentOnly("org.springframework.boot:spring-boot-devtools")
    runtimeOnly("com.h2database:h2")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
