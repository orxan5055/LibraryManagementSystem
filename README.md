📚 Library Management System
Overview
The Library Management System is a Spring Boot web application that allows users to manage a collection of books. It provides features such as adding, editing, deleting, and viewing books. The application follows MVC 

🚀 Features
Add new books with title and author.

View a list of all books.
Edit existing book details.
Delete books from the collection.
Responsive and modern UI with Bootstrap.
Uses Spring Boot, Hibernate, MySQL, and Thymeleaf.

🛠️ Technologies Used

Backend: Java, Spring Boot, Spring Data JPA, Hibernate
Frontend: Thymeleaf, Bootstrap, HTML, CSS
Database: MySQL
Build Tool: Maven

📂 Project Structure

LibraryManagementSystem/
│── src/
│   ├── main/
│   │   ├── java/com/example/LibraryManagementSystem/
│   │   │   ├── controllers/        # REST Controllers
│   │   │   ├── entities/           # JPA Entities
│   │   │   ├── repositories/       # Spring Data JPA Repositories
│   │   │   ├── services/           # Business Logic Services
│   │   │   ├── LibraryManagementSystemApplication.java  # Main Class
│   │   ├── resources/
│   │   │   ├── templates/          # Thymeleaf templates
│   │   │   ├── static/css/         # CSS files
│   │   │   ├── application.properties  # Database Config
│── pom.xml  # Maven dependencies
│── README.md

⚙️ Installation & Setup

1️⃣ Prerequisites

Ensure you have the following installed:

Java 17+
Maven
MySQL

2️⃣ Clone the Repository

git clone https://github.com/yourusername/LibraryManagementSystem.git
cd LibraryManagementSystem

3️⃣ Configure MySQL Database

Create a database in MySQL:
CREATE DATABASE library_db;
Update src/main/resources/application.properties with your database credentials:
spring.datasource.url=jdbc:mysql://localhost:3306/library_db
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update

4️⃣ Build and Run the Application

mvn spring-boot:run

Access the app at: http://localhost:8080/books

📜 License

This project is licensed under the MIT License.

🤝 Contributing

Feel free to fork the repository, create a feature branch, and submit a pull request!

📬 Contact

Author: Orxan Abıyev
Email: oabiyev54@gmail.com
GitHub: orxan5055
