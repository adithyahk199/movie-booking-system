-- Movie Ticket Booking System Database
-- Database: movie_booking

CREATE DATABASE IF NOT EXISTS movie_booking;

USE movie_booking;

-- =========================================
-- Movies Table
-- =========================================

CREATE TABLE IF NOT EXISTS movies (
    movie_id INT NOT NULL AUTO_INCREMENT,
    title VARCHAR(100) NOT NULL,
    genre VARCHAR(50) DEFAULT NULL,
    language VARCHAR(30) DEFAULT NULL,
    duration INT DEFAULT NULL,
    release_date DATE DEFAULT NULL,
    PRIMARY KEY (movie_id)
) ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;


-- =========================================
-- Shows Table
-- =========================================

CREATE TABLE IF NOT EXISTS shows (
    show_id INT NOT NULL AUTO_INCREMENT,
    movie_id INT DEFAULT NULL,
    show_date DATE DEFAULT NULL,
    show_time TIME DEFAULT NULL,
    screen_no INT DEFAULT NULL,
    ticket_price DECIMAL(10,2) DEFAULT NULL,
    PRIMARY KEY (show_id),
    KEY movie_id (movie_id),
    CONSTRAINT shows_ibfk_1
        FOREIGN KEY (movie_id)
        REFERENCES movies (movie_id)
) ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;


-- =========================================
-- Customers Table
-- =========================================

CREATE TABLE IF NOT EXISTS customers (
    customer_id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) DEFAULT NULL,
    phone VARCHAR(15) DEFAULT NULL,
    PRIMARY KEY (customer_id),
    UNIQUE KEY email (email)
) ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;


-- =========================================
-- Bookings Table
-- =========================================

CREATE TABLE IF NOT EXISTS bookings (
    booking_id INT NOT NULL AUTO_INCREMENT,
    customer_id INT DEFAULT NULL,
    show_id INT DEFAULT NULL,
    seats INT DEFAULT NULL,
    total_amount DECIMAL(10,2) DEFAULT NULL,
    booking_date TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (booking_id),
    KEY customer_id (customer_id),
    KEY show_id (show_id),
    CONSTRAINT bookings_ibfk_1
        FOREIGN KEY (customer_id)
        REFERENCES customers (customer_id),
    CONSTRAINT bookings_ibfk_2
        FOREIGN KEY (show_id)
        REFERENCES shows (show_id)
) ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;