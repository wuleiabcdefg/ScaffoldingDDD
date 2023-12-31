/*
 * This file was generated by the Gradle 'init' task.
 */
plugins {
    id("ScaffoldingDDD.java-common-conventions")
    alias(libs.plugins.springBoot)

}

apply(plugin = "io.spring.dependency-management")
dependencies {
    implementation(project(":adapter"))
    implementation(project(":infrastructure"))
    implementation(project(":domain"))
    implementation(project(":common"))
    implementation(project(":app"))
    implementation("org.springframework.boot:spring-boot-starter-web")
}

//application {
//    // Define the main class for the application.
//    mainClass.set("ScaffoldingDDD.app.App")
//}
