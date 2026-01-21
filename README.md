# 🎓 Student Management System (Java + JDBC)

A **console-based Student Management System** built using **Core Java and JDBC**. This project demonstrates user authentication and full CRUD operations on student records with proper validation and clean code structure.

---

## 🚀 Features

### 🔐 User Module

* User Registration
* User Login
* Password encryption (basic hashing)

### 👨‍🎓 Student Module

* Add Student
* View Students
* Update Student
* Delete Student

### ✅ Validations

* Email format validation (must be valid & Gmail supported)
* Name validation (minimum length)
* Password validation

### ⚙️ Technical Highlights

* JDBC with MySQL
* DAO Design Pattern
* Prepared Statements (SQL Injection safe)
* Input validation using utility class
* Clean menu-driven flow
* Exception handling

---

## 🛠️ Technologies Used

* **Language:** Java
* **Database:** MySQL
* **Connectivity:** JDBC
* **IDE:** IntelliJ IDEA
* **Version Control:** Git & GitHub

---

## 📂 Project Structure

```
StudentManagementSystem
│
├── src
│   └── com.student
│       ├── dao
│       │   ├── UserDAO.java
│       │   └── StudentDAO.java
│       │
│       ├── model
│       │   ├── User.java
│       │   └── Student.java
│       │
│       ├── util
│       │   ├── DBConnection.java
│       │   ├── InputValidator.java
│       │   └── PasswordUtil.java
│       │
│       └── main
│           └── MainApp.java
│
└── README.md
```

---

## 🗄️ Database Schema

### Database

```sql
CREATE DATABASE student_management;
USE student_management;
```

### Users Table

```sql
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL
);
```

### Students Table

```sql
CREATE TABLE students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    course VARCHAR(50) NOT NULL
);
```

---

## ▶️ How to Run the Project

1. Install **JDK 8 or above**
2. Install **MySQL** and create the database
3. Add **MySQL JDBC Driver (Connector/J)** to project
4. Update DB credentials in `DBConnection.java`
5. Run `MainApp.java`

---

## 🧪 Sample Flow

1. Register a user
2. Login with credentials
3. Choose menu options:

    * Add Student
    * View Students
    * Update Student
    * Delete Student

---

## 🎯 Learning Outcomes

* Hands-on experience with JDBC
* Understanding DAO pattern
* Input validation and exception handling
* Git & GitHub workflow
* Real-world console application structure

---

## 🔮 Future Enhancements

* Convert to **Spring Boot**
* Add REST APIs
* Add role-based authentication
* Use Hibernate / JPA
* Add UI (Web / Desktop)



---


