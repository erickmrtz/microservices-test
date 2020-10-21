# Microservices Testing
---
## Requirements: 
- Java 8 (openjdk8u265, jdk8u262)
- Maven

---
## Usage:

Run all projects but in the following order:

1. Registry Service (Port 8080)
2. Product Service (Port 8091)
3. Item Service (Port 8092)
4. Gateway Service (Port 8081)

You can run the servers using ```mvn spring-boot:run``` in separate CLI

---
## Testing the services:

You can use Postman, cURL, Insomnia or any other API tester program. <br>

Endpoint: ```localhost:8081```

Implemented methods:

- GET /items/
- GET /items/{id}/quantities/{quantity}
- GET /products/
- GET /products/{id}