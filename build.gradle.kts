plugins {
    id("java")
    id("jacoco")}

group = "com.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
    finalizedBy(tasks.jacocoTestReport)
}

jacoco {
    toolVersion = "0.8.11"
}

tasks.jacocoTestReport {
    dependsOn(tasks.test) // asegura que las pruebas se ejecuten primero

    reports {
        xml.required.set(false)
        html.required.set(true)
        csv.required.set(false)
    }

    classDirectories.setFrom(
        fileTree("build/classes/java/main") {
            include("com/example/plateGenerator/**")
        }
    )

    sourceDirectories.setFrom(files("src/main/java"))
    executionData.setFrom(files("build/jacoco/test.exec"))
}