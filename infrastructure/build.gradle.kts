/*
 * This file was generated by the Gradle 'init' task.
 */

plugins {
    id("ScaffoldingDDD.java-library-conventions")
    alias(libs.plugins.springBoot)

}
apply(plugin = "io.spring.dependency-management")
dependencies {
    implementation(project(":common"))
    implementation(project(":domain"))
    implementation(project(":app"))

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    runtimeOnly("com.h2database:h2")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
}
