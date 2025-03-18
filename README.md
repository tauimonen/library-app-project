# Library App Project

## Overview
Library App Project is a full-stack web application that allows users to explore books, manage authentication, and process payments. It is built using Java (Spring Boot) for the backend and React with TypeScript for the frontend. The application uses MySQL as the database and Docker for containerization.

## Technologies Used
- **Frontend:** React, TypeScript, Bootstrap, CSS
- **Backend:** Spring Boot (Java 17), Spring Data REST, MySQL
- **Security:** Okta Authentication (OIDC, OAuth 2.0)
- **Payments:** Stripe API Integration
- **Containerization:** Docker, Docker Compose

## Features
### Frontend
- Responsive UI using React and Bootstrap
- Navigation bar
- Book exploration with carousel and top books
- Library services and footer
- Authentication with Okta
- Payment integration with Stripe

### Backend
- REST API with Spring Boot
- Read-only book endpoints using Spring Data REST:
  - `GET /books` - Retrieve a list of books
  - `GET /books/{id}` - Retrieve a single book
- Authentication via Okta (OAuth 2.0, OpenID Connect)
- Secure API routes
- Payment processing with Stripe

### Database
- MySQL database schema creation using SQL scripts
- Book table with sample data

### Security
- HTTPS configuration with OpenSSL self-signed certificates
- OAuth 2.0 authentication via Okta
- Secure environment variable storage using `.env` file

### Containerization
- Dockerfiles for frontend and backend services
- Docker Compose for managing multi-container setup

## Setup & Installation
### Prerequisites
- Node.js & npm (for frontend)
- Java 17 & Maven (for backend)
- MySQL Server
- Docker (optional for containerization)

### Frontend Setup
1. Navigate to the frontend directory:
   ```sh
   cd frontend
   ```
2. Install dependencies:
   ```sh
   npm install
   ```
3. Start the React application:
   ```sh
   npm start
   ```

### Backend Setup
1. Navigate to the backend directory:
   ```sh
   cd backend
   ```
2. Configure database connection in `application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/library_db
   spring.datasource.username=root
   spring.datasource.password=yourpassword
   ```
3. Run the Spring Boot application:
   ```sh
   mvn spring-boot:run
   ```

### Authentication Setup
1. Create a developer account at [Okta](https://developer.okta.com/).
2. Register an OpenID Connect (OIDC) application.
3. Configure `clientId` and `issuer` in the environment file:
   ```properties
   OKTA_CLIENT_ID=your-client-id
   OKTA_ISSUER=https://your-okta-domain/oauth2/default
   ```

### Payment Setup
1. Register for a [Stripe Developer Account](https://stripe.com/).
2. Retrieve API keys and configure them in the backend.
3. Install Stripe SDK in frontend:
   ```sh
   npm install @stripe/react-stripe-js @stripe/stripe-js
   ```

### Running with Docker
1. Build and start the containers:
   ```sh
   docker-compose up --build
   ```
2. Access the application at `http://localhost:3000`.

## Usage
1. Browse available books.
2. Log in using Okta authentication.
3. Checkout and pay using Stripe.
4. Securely manage user authentication and payments.

## License
This project is licensed under the MIT License.

## Contact
For any inquiries, please contact the project maintainer at [your-email@example.com](mailto:your-email@example.com).


