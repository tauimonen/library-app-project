# library-app-project

React - TypeScript - Spring Boot - MySQL - Docker

## Responsive React front end

- React + TypeScript (npx create-react-app library-app –template typescript)
- Bootstrap + CSS
- Navigation bar
- Explore top books
- Book carousel
- Hero's component
- Library services
- Footer
- In the 1st stage of development only ”logged out” version

## Spring Boot REST API backend

Spring Data REST API for basic read endpoints:

- GET /books - Read a list of books
- GET /books{id} - Read a single book
- Disable POST, PUT, DELETE, PATCH with config file (implement RepositoryRestConfigurer)

Spring Boot 3.1.4 starter project with:

- Java 17
- Maven
- Data JPA
- Data REST Repositories
- MySQL Driver
- Lombok

## MySQL database

SQL scripts in starter files to create a database scema and tables and add books to the database
![database_tables](https://github.com/tauimonen/library-app-project/assets/64781021/747ba619-089b-43b7-9411-d4b7536c415f)

## Containerization

Create Dockerfiles and Docker-compose file for containerization.
