# Smart Product Finder

A Java-based product discovery and price-comparison backend built with **Java 21, Spring Boot, Spring Data JPA, and MySQL**. The project is being developed to help users browse products and compare product prices through REST APIs.

> **Project status:** Backend foundation and product query endpoints are present. Image-based product recognition, external shopping-platform integrations, and a frontend are planned enhancements—not currently claimed as implemented.

## Features

- REST API built with Spring Boot
- Product listing endpoint
- Search products by category
- Search products by name
- Filter products by a minimum and maximum price
- Find the cheapest product
- Sort products by price (low-to-high and high-to-low)
- Spring Data JPA repository layer for database access
- MySQL configuration
- Maven-based project structure

## Tech Stack

| Technology | Purpose |
|---|---|
| Java 21 | Backend language |
| Spring Boot | Application framework |
| Spring Web | REST APIs |
| Spring Data JPA / Hibernate | Persistence and ORM |
| MySQL | Relational database |
| Maven | Dependency management and build |
| Bean Validation | Validation support dependency |

## Project Structure

```text
smart-product-finder/
├── pom.xml
├── README.md
└── src/
    ├── main/
    │   ├── java/com/smartproductfinder/
    │   │   ├── SmartProductFinderApplication.java
    │   │   ├── controller/
    │   │   ├── entity/
    │   │   ├── repository/
    │   │   └── service/
    │   └── resources/
    │       └── application.properties
    └── test/
```

## Prerequisites

Install the following before running the application:

- JDK 21
- Maven (or use the Maven Wrapper if you add one)
- MySQL Server
- Git

## Setup and Run

### 1. Clone the repository

```bash
git clone https://github.com/rahulkryadav007/SmartProductFinder.git
cd SmartProductFinder/smart-product-finder
```

### 2. Create the database

Open MySQL and run:

```sql
CREATE DATABASE smart_product_finder;
```

### 3. Configure database credentials

Open `src/main/resources/application.properties` and configure your local database username and password. **Do not commit real passwords or secrets to GitHub.** Prefer environment variables or an untracked local configuration file.

Example environment-variable based configuration:

```properties
spring.application.name=smart-product-finder
spring.datasource.url=${DB_URL:jdbc:mysql://localhost:3306/smart_product_finder}
spring.datasource.username=${DB_USERNAME:root}
spring.datasource.password=${DB_PASSWORD}
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
server.port=8080
```

Set `DB_URL`, `DB_USERNAME`, and `DB_PASSWORD` in your environment before starting the app, or adjust the defaults for your local setup.

### 4. Run the application

From the `smart-product-finder` directory:

```bash
mvn spring-boot:run
```

The API is configured to run at:

```text
http://localhost:8080
```

## REST API Reference

All endpoints below use the base URL `http://localhost:8080`.

| Method | Endpoint | Description |
|---|---|---|
| GET | `/api/test` | Check whether the backend is running |
| GET | `/api/products` | Retrieve all products |
| GET | `/api/products/search?category=Electronics` | Search products by category |
| GET | `/api/products/name?name=phone` | Search products by name (and/or brand, as implemented in the service) |
| GET | `/api/products/cheapest` | Retrieve the cheapest product |
| GET | `/api/products/price?min=100&max=1000` | Filter products by price range |
| GET | `/api/products/sort/low-to-high` | Sort products from lowest to highest price |
| GET | `/api/products/sort/high-to-low` | Sort products from highest to lowest price |

### Quick test

With the application running, open this URL in a browser or call it with Postman:

```http
GET http://localhost:8080/api/test
```

You can also test the product listing endpoint:

```http
GET http://localhost:8080/api/products
```

The product endpoints require the MySQL database to be configured and available. They may return an empty list if no products have been added yet.

## Roadmap

- [ ] Add product create, update, and delete APIs
- [ ] Add request validation and consistent error responses
- [ ] Add automated tests for service and controller layers
- [ ] Add sample data and API documentation (OpenAPI/Swagger)
- [ ] Build a frontend for product search and comparison
- [ ] Explore image upload and image-based product matching
- [ ] Integrate external shopping sources for live price comparison

## Contributing

Suggestions and improvements are welcome. Fork the repository, create a feature branch, and open a pull request with a clear description of your changes.

## Author

**Rahul Kumar Yadav**

- GitHub: [@rahulkryadav007](https://github.com/rahulkryadav007)
- Project: [SmartProductFinder](https://github.com/rahulkryadav007/SmartProductFinder)

---

If you find this project useful, consider giving the repository a ⭐.
