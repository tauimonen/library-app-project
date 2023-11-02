# library-app-project

Java - Spring Boot - TypeScript/JavaScript - React - MySQL - Docker

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

## Authentication

- Create a developer account at okta.com
Add OpenID Connect client app in Okta: Create a new application in the Developer Account.
Select option for OIDC: Open ID connect > Single-Page Application
- Set up app configurarion for OpenID Connect (clientId & issuer)
- Install Okta SDK dependecies: Sign-In Widged, Okta React SDK, Okta JavaScript SDK
- Integrate Okta Sign-In Widged
- Add Configurarions to our application 
- Create new Security Routes & Navigation Login/Logout (OAuth 2.0 API)

## Security

- Create localhost.conf
- Generate key and self-signed certificate with OpenSSL
- Place the .env file
- Change HTTP -> HTTPS and add "set HTTPS=true" to the start script
- When deploying the application change the certificate to the one provided by the hosting service

## Containerization

Create Dockerfiles and Docker-compose file for containerization.
