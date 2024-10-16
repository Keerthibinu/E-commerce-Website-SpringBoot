# E-Commerce Website using Spring Boot

## Overview
This is an E-commerce website built using Spring Boot for the backend and JSP for the frontend, with MySQL as the database. It provides functionalities for both customers and admins, supporting user management, product browsing, shopping cart operations, and an admin panel for managing users, products, and categories.

## Technology Stack
- **Frontend:** JSP
- **Backend:** Java, Spring Boot, Spring Data JPA
- **Database:** MySQL
- **Security:** Spring Security

## Users
1. **Customers (Normal Users)**
2. **Admin Users**

## Functionalities
### For Customers
- **User Management:** Register, log in/out, and manage profiles.
- **Product Management:** Browse products, search and view product details.
- **Shopping Cart:** Add products, view cart, and proceed with checkout.
- **Search & Filter:** Filter products by name, category, price, and availability.

### For Admins
- **Admin Panel:** Manage users, products, and categories.

## Database Schema
1. **Users:** UserId, Username, Email, Password, Address
2. **Products:** ProductId, Name, CategoryId, Description, Price, Stock
3. **Categories:** CategoryId, Name
4. **Cart:** CartId, UserId, ProductId, Quantity, DateTime
5. **Payments:** PaymentId, UserId, PaymentMethod, Amount, PaymentDate

## Project Structure Overview
The project is divided into packages such as `controller`, `models`, `repository`, and `services`. The controllers handle the HTTP requests, services manage business logic, and repositories handle database interactions. The application uses JSP for views, Spring Security for authentication, and Spring Data JPA for database operations.

### Pages:
- User registration, login, profile, product browsing, cart, payment pages for customers.
- Admin dashboard with product and category creation pages.

## How to Run
1. Clone the repository.
2. Set up MySQL and create the database.
3. Update the `application.properties` file with your database connection details.
4. Run the application using Maven
5. Access the site at `http://localhost:8080`.
