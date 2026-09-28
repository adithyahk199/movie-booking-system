
# 🎬 Movie Ticket Booking System

A Java-based Movie Ticket Booking System built using **Java, JDBC, Maven, and MySQL**.

The application provides a simple menu-driven console interface for managing movies, shows, customers, and ticket bookings.

---

## 🚀 Features

- Add movies
- View all movies
- Add movie shows
- View all shows
- Add customers
- View all customers
- Book movie tickets
- Automatically calculate total ticket amount
- Store booking date automatically
- MySQL database integration using JDBC
- Maven-based project structure

---

## 🛠️ Technologies Used

- **Java**
- **JDBC**
- **MySQL**
- **Maven**
- **Git & GitHub**
- **Eclipse IDE**

---

## 📂 Project Structure

```text
Movie/
├── database/
│   └── movie_booking.sql
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/pwioi/movie/
│   │   │       ├── App.java
│   │   │       │
│   │   │       ├── config/
│   │   │       │   └── DBConnectivity.java
│   │   │       │
│   │   │       ├── dao/
│   │   │       │   ├── BookingDAO.java
│   │   │       │   ├── CustomerDAO.java
│   │   │       │   ├── MovieDAO.java
│   │   │       │   └── ShowDAO.java
│   │   │       │
│   │   │       ├── model/
│   │   │       │   ├── Booking.java
│   │   │       │   ├── Customer.java
│   │   │       │   ├── Movie.java
│   │   │       │   └── Show.java
│   │   │       │
│   │   │       └── service/
│   │   │           └── BookingService.java
│   │   │
│   │   └── resources/
│   │       └── dbconfig.properties
│   │
│   └── test/
│
├── pom.xml
├── .gitignore
└── README.md
---

## 🗄️ Database

The project uses a MySQL database named:

```text
movie_booking
```

### Tables

```text
movies
shows
customers
bookings
```

### Relationships

```text
movies
   │
   │ movie_id
   ↓
shows
   │
   │ show_id
   ↓
bookings
   ↑
   │ customer_id
customers
```

The complete database schema is available in:

```text
database/movie_booking.sql
```

---

## ⚙️ Database Setup

The SQL script automatically creates the database and required tables.

Run the SQL file using MySQL:

```sql
SOURCE /path/to/Movie/database/movie_booking.sql;
```

Or open `database/movie_booking.sql` in MySQL Workbench and execute it.

---

## 🔐 Database Configuration

Create the following file:

```text
src/main/resources/dbconfig.properties
```

Add your MySQL credentials:

```properties
dburl=jdbc:mysql://localhost:3306/movie_booking
dbuser=root
dbpassword=YOUR_PASSWORD
```

Replace `YOUR_PASSWORD` with your MySQL password.

> Do not upload your actual `dbconfig.properties` file to GitHub.

The file is excluded using `.gitignore`.

---

## 📦 Maven Dependency

The project uses MySQL Connector/J:

```xml
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <version>9.4.0</version>
</dependency>
```

Maven automatically downloads the required dependency.

---

## ▶️ How to Run

### 1. Clone the repository

```bash
git clone https://github.com/adithyahk199/movie-booking-system.git
```

### 2. Open the project

Open the project in Eclipse or another Java IDE.

### 3. Set up the database

Run:

```text
database/movie_booking.sql
```

### 4. Configure database credentials

Create:

```text
src/main/resources/dbconfig.properties
```

and add your MySQL username and password.

### 5. Run the application

Run:

```text
src/main/java/com/pwioi/movie/App.java
```

---

## 🎟️ Application Menu

```text
======================================
     MOVIE TICKET BOOKING SYSTEM
======================================
1. Add Movie
2. View Movies
3. Add Show
4. View Shows
5. Add Customer
6. View Customers
7. Book Ticket
8. Exit
======================================
```

---

## 🧩 Architecture

The project follows a layered structure:

```text
App
 │
 ↓
Service
 │
 ↓
DAO
 │
 ↓
JDBC
 │
 ↓
MySQL Database
```

### Model

Contains Java classes representing database entities.

### DAO

Handles database operations such as:

- Insert
- Select
- Retrieve by ID

### Service

Contains application/business logic such as calculating the total booking amount.

### Config

Handles MySQL database connectivity.

---

## 🔮 Future Improvements

Possible future improvements include:

- Update and delete movies
- Update and delete shows
- Cancel bookings
- Seat availability management
- Search movies
- Search shows by date
- Admin login
- Customer login
- Graphical user interface
- Web-based interface
- REST API
- Online payment integration

---

## 👨‍💻 Author

**Adithya H K**

---

## 📄 License

This project is created for learning and educational purposes.