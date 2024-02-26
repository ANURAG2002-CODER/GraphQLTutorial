# Spring Boot GraphQL Tutorial

This tutorial provides step-by-step instructions for setting up a Spring Boot project with GraphQL integration, using PostgreSQL as the database backend. It includes instructions for downloading necessary software, setting up the database, linking it to the Spring Boot application, configuring GraphQL, and testing GraphQL queries using Postman.

## Prerequisites

Ensure you have the following software installed on your system:

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html)
- [IntelliJ IDEA](https://www.jetbrains.com/idea/)
- [PostgreSQL](https://www.postgresql.org/download/)

## Setting Up PostgreSQL Database

1. Download and install PostgreSQL from the official website.
2. During installation, set a username and password for the database superuser (usually `postgres`).
3. After installation, start the PostgreSQL service.

## Creating Database and Tables

1. Open a command prompt or terminal window.
2. Access PostgreSQL using the `psql` command:

    ```bash
    psql -U postgres
    ```

3. Enter the superuser password when prompted.
4. Create a new database for the project:

    ```sql
    CREATE DATABASE graphqltutorial;
    ```

5. Connect to the newly created database:

    ```sql
    \c graphqltutorial;
    ```

6. Create necessary tables for the project, such as `Author` and `Tutorial`, using appropriate SQL commands.

## Setting Up Spring Boot Project

1. Open IntelliJ IDEA.
2. Click on "File" > "New" > "Project from Version Control" > "Git".
3. Enter the repository URL and clone the project.
4. Open the cloned project in IntelliJ IDEA.

## Configuring Spring Boot Application

1. Open the `application.properties` file located in `src/main/resources`.
2. Configure the PostgreSQL datasource properties:

    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/graphqltutorial
    spring.datasource.username=postgres
    spring.datasource.password=postgres
    spring.datasource.driver-class-name=org.postgresql.Driver
    ```

3. Configure Hibernate properties:

    ```properties
    spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
    spring.jpa.hibernate.ddl-auto=update
    ```

4. Configure GraphQL servlet mapping:

    ```properties
    graphql.servlet.mapping=/apis/graphql
    ```

## Setting Up GraphQL Resolvers

1. Create resolver classes for GraphQL queries and mutations, such as `AuthorResolver` and `TutorialResolver`.
2. Implement methods in resolver classes to handle GraphQL queries and mutations.

## Testing GraphQL Queries in Postman

1. Open Postman.
2. Set the HTTP method to `POST`.
3. Enter the endpoint URL: `http://localhost:8080/apis/graphql`.
4. Create GraphQL queries and mutations in the request body, for example:

    ```graphql
    mutation {
        createAuthor(name: "Anurag", age: 21) {
            id
            name
        }
    }
    ```

    ```graphql
    query {
        findAllTutorials {
            title
            description
            author {
                id
                name
            }
        }
    }
    ```

5. Send the request and observe the response.

## GraphQL Queries Explained

- `createAuthor`: Mutation to create a new author with specified name and age. Returns the ID and name of the newly created author.
- `findAllTutorials`: Query to fetch all tutorials along with their titles, descriptions, and respective authors' IDs and names.
- `createTutorial`: Mutation to create a new tutorial with specified name, description and author.
- `findAllAuthors`: Query to fetch all authors along with their name and age.
- `countAuthors`: Returns the count of the total number of Authors.
- `countTutorials`: Returns the count of the total number of tutorials.

## Additional Notes

- Customize the GraphQL schema, resolvers, and database operations as per project requirements.
- Ensure proper error handling and input validation in resolver methods.
- Explore GraphQL documentation and resources for advanced usage and optimization.

