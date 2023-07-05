# UserProfile

This ReadMe file provides instructions on how to set up and run the Spring Boot application "UserProfile". Before running the application, please follow the steps below.

## Prerequisites
- Java Development Kit (JDK) installed (version 17 or higher)
- Maven installed
- PostgreSQL database installed locally

## Database Setup
1. Create a local PostgreSQL database for the application.
2. Set or change the username and password for the database as per your local configuration. Make note of these credentials for the next steps.

## Configuration
1. Open the `application.properties` file located in the `src/main/resources` directory.
2. Locate the property `spring.datasource.username` and replace the value with the username of your PostgreSQL database.
3. Locate the property `spring.datasource.password` and replace the value with the password of your PostgreSQL database.

## Database Schema Creation
1. In the `application.properties` file, locate the property `spring.jpa.hibernate.ddl-auto` and change its value from `validate` to `create`.
   ```
   spring.jpa.hibernate.ddl-auto=create
   ```
   This configuration will create the necessary database tables when the application starts.

2. Save the `application.properties` file.

## Running the Application
To run the Spring Boot application, execute the following command in the root directory of the project:

```bash
mvn spring-boot:run
```

The application will start and connect to the PostgreSQL database. Once the database tables are created, you can stop the application.

## Updating the Database Schema
1. Open the `application.properties` file located in the `src/main/resources` directory.
2. Locate the property `spring.jpa.hibernate.ddl-auto` and change its value from `create` back to `validate`.
   ```
   spring.jpa.hibernate.ddl-auto=validate
   ```
   This configuration ensures that the database schema is not modified on subsequent application starts.

3. Save the `application.properties` file.

## Additional Configuration
If you need to modify any other configurations for the Spring Boot application, you can refer to the `application.properties` file. It contains various properties that can be customized to fit your requirements.

For further details, please refer to the official [Spring Boot documentation](https://spring.io/projects/spring-boot).

Feel free to reach out if you have any questions or encounter any issues while setting up or running the application.
