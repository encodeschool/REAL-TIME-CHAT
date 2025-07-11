﻿# 📱 Real-Time Chat Application
![Java Real time Chat Introduction-Обложка](https://github.com/user-attachments/assets/0eb9db88-6e1f-4d62-8098-abd8584dcc31)

A full-stack Java-based chat application built with:

- **Java 17+**
- **Spring Boot 3**
- **Spring Security**
- **PostgreSQL**
- **Spring Data JPA**
- **WebSocket (STOMP over SockJS)**
- **Thymeleaf (for UI)**
- **JS & CSS**

---

## ✨ Features

✅ User Registration and Login  
✅ Real-Time Messaging with WebSocket  
✅ Persistent Chat History in PostgreSQL  
✅ Secure Password Hashing with BCrypt  
✅ RESTful API for managing users and messages  
✅ Web UI with Thymeleaf

---

## 🛠️ Tech Stack

- **Backend**: Spring Boot, Spring Security, WebSocket, JPA/Hibernate
- **Database**: PostgreSQL
- **Frontend**: Thymeleaf
- **Build Tool**: Maven

---

## 🚀 Getting Started

### 1️⃣ Clone the repository

```bash
git clone https://github.com/your-username/your-repo-name.git
cd your-repo-name
```

### 2️⃣ Configure PostgreSQL
Create a database:

``` sql
CREATE DATABASE chat_app;
```

Update src/main/resources/application.yml:

``` properties
spring.application.name=simple-chat

# Postgres Configuration
spring.datasource.url=jdbc:postgresql://localhost:5432/DB_NAME
spring.datasource.password=PASSWORD
spring.datasource.username=USERNAME
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update

# Port
server.port=8088
```

### 3️⃣ Build and run

``` bash
./mvnw spring-boot:run
```

App will run on http://localhost:8080.

---
## 🗂️ Project Structure

```css
src/
 └── main/
     ├── java/com/example/chatapp
     │   ├── controller
     │   ├── model
     │   ├── repository
     │   ├── service
     │   ├── security
     │   └── websocket
     └── resources/
         ├── templates/
         └── static/
```

---
## 💬 How It Works

✅ Users register and authenticate with JWT <br>
✅ Messages are sent and received in real-time via WebSocket <br>
✅ Messages are saved to PostgreSQL <br>
✅ Secure endpoints with Spring Security <br>
✅ UI uses Bootstrap for responsive design <br>

---

## 🤝 Contributing
Pull requests welcome! For major changes, please open an issue first to discuss what you would like to change.

### 📌 Author
Built with ❤️ by <a href="http://encode.uz">Nurmukhammad Ergashev</a>

---

## ❤️ Subscribe

### 📹 Video
Subscribe & Watch Tutorial: <a href="https://youtu.be/MncQe6y3VGg">Our YouTube Channel</a>
