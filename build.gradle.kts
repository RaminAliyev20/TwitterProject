plugins {
	java
	id("org.springframework.boot") version "3.1.0"
	id("io.spring.dependency-management") version "1.1.0"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test")

	runtimeOnly("org.postgresql:postgresql")
	implementation("org.liquibase:liquibase-core")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-validation")


//	//swagger
//	implementation ("io.springfox:springfox-boot-starter:3.0.0")

	//swagger
	implementation("org.springdoc:springdoc-openapi-data-rest:1.6.0")
	implementation("org.springdoc:springdoc-openapi-ui:1.6.0")
	implementation("org.springdoc:springdoc-openapi-kotlin:1.6.0")

	//mapper
	implementation("org.mapstruct:mapstruct-jdk8:1.3.0.Final")
	annotationProcessor("org.mapstruct:mapstruct-jdk8:1.5.3.Final")
	annotationProcessor("org.mapstruct:mapstruct-processor:1.3.0.Final")

	//security
		implementation("org.springframework.boot:spring-boot-starter-security")
		testImplementation("org.springframework.security:spring-security-test")
		implementation("io.jsonwebtoken:jjwt-api:0.11.5")
		runtimeOnly("io.jsonwebtoken:jjwt-impl:0.11.5")
		runtimeOnly("io.jsonwebtoken:jjwt-jackson:0.11.5")

	// https://mvnrepository.com/artifact/io.jsonwebtoken/jjwt-api

	//	implementation("io.jsonwebtoken:jjwt-api:0.12.5")
//	runtimeOnly("io.jsonwebtoken:jjwt-impl:0.12.5")
//	runtimeOnly("io.jsonwebtoken:jjwt-jackson:0.12.5")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
