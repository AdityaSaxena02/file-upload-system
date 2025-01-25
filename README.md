# File Upload System

This project is a file upload management system built with Spring Boot. It allows users to upload, view, and delete files.

## Features:
- Upload files with a description
- Retrieve a list of uploaded files
- Delete uploaded files
- Files are stored locally in an `uploads/` directory
- Spring Boot application with JPA for data persistence

## Technologies Used:
- Java 17
- Spring Boot
- JPA (Java Persistence API)
- H2 Database (in-memory for simplicity)
- HTML and JSP for the frontend

## How to Run:
1. Clone the repository:
   ```bash
   git clone https://github.com/AdityaSaxena02/file-upload-system.git

   Navigate to the project directory:

cd file-upload-system
Run the Spring Boot application:
mvn spring-boot:run
Access the application at http://localhost:8080 in your browser.
Endpoints:
POST /upload: Upload a file with a description.
GET /files: List all uploaded files.
DELETE /delete/{id}: Delete a file by ID.
Future Enhancements:
Add user authentication and authorization.
Implement file download feature.
Add file size and type validation.
