![image](https://github.com/user-attachments/assets/dd74930e-1545-4ed3-b1aa-f714b4b245ff)

# Spring Boot 3.0 Security with JWT Implementation

This project demonstrates the implementation of **security using Spring Boot 3.0** and **JSON Web Tokens (JWT)**. It includes user registration and login with JWT authentication, password encryption using BCrypt, role-based authorization, and much more.

---

## Features

- **User Registration & Login**: Secure user registration and login with JWT authentication.
- **Password Encryption**: Uses **BCrypt** to encrypt passwords for secure storage.
- **Role-Based Authorization**: Implements **Spring Security** for role-based access control.
- **Access Denied Handling**: Customized access-denied handling for user feedback.
- **Logout Mechanism**: Secure token invalidation for logging out users.
- **Refresh Tokens**: JWT refresh tokens for session management and token regeneration.

---

## Technologies

- **Spring Boot 3.0**
- **Spring Security**
- **JSON Web Tokens (JWT)**
- **BCrypt**
- **Maven**
- **PostgreSQL** (Database)

---

## Getting Started

### Prerequisites

Before you begin, ensure you have the following installed on your local machine:

- **JDK 17+**: Ensure Java 17 or higher is installed.
- **Maven 3+**: Maven is required to build the project.

### Setting Up PostgreSQL Database

1. **Install PostgreSQL** (if not already installed). You can download it from [here](https://www.postgresql.org/download/).

2. **Create the Database**:
   
   To create the `jwt_security` database, open PostgreSQL and run the following SQL command:

   ```sql
   CREATE DATABASE jwt_security;

## make sure your applcaiton.yml is updated
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/jwt_security
    username: your_postgres_username
    password: your_postgres_password
  jpa:
    hibernate:
      ddl-auto: update
  datasource:
    driver-class-name: org.postgresql.Driver

## make sure your pom.xml looks like this

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt</artifactId>
    <version>0.11.5</version>
</dependency>
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
</dependency>


## clone repo
git clone https://github.com/FaizanDhankwala/SpringBoot-Authentication-with-JWT-Implementation.git

## Navigate to the Project Directory
cd SpringBoot-Authentication-with-JWT-Implementation
(all in cmd)

## Build the Project
Use Maven to build the project:
mvn clean install

## Run the Project
After building the project, you can run it using:
mvn spring-boot:run

