# Login App Java
Creating a simple Login Application using Java as the backend language.

## About Project
loginapp is a simple login web application created with the use of Spring Boot framework and Bootstrap for user interaction. 

## Features

- User registration and authentication.
- Persistent login using cookies.
- Role-based access control.
- User-friendly UI design with Bootstrap.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or later
- Maven

### Installation

1. Clone this repository to your local machine:

   ```bash
   git clone https://github.com/your-username/login-app.git

2. Run the login-app.sql script in the src/main/resources/static/sql folder to create the database schema in your local database.

## Usage 
1. Run the application using Maven. (I use Eclipse IDE, so I ran it as a Spring Boot Application)
   ```bash
   mvn spring-boot:run
3. Open a web browser and go to: http://localhost:8080/login
4. Log in with existing credentials.

## Configuration
* The application's database configuration is defined in src/main/resources/application.properties.

## Technologies Used
* Spring Boot
* Spring Data JPA
* Thymeleaf
* Bootstrap


