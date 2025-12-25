import org.gradle.kotlin.dsl.named
import org.springframework.boot.gradle.tasks.bundling.BootJar

dependencies {
    implementation(project(":first-domain"))
    implementation(project(":second-domain"))
    implementation(project(":third-domain"))

    implementation(libs.spring.boot.starter.web)
}

tasks.named<BootJar>("bootJar") {
    enabled = true
}

tasks.named<Jar>("jar") {
    enabled = false
}
