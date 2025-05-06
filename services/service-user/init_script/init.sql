-- Tạo database và sử dụng database
CREATE DATABASE IF NOT EXISTS user_db;

USE user_db;

-- Tạo bảng users
CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    role ENUM('USER', 'ADMIN') DEFAULT 'USER',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Thêm 10 dữ liệu với role là 'USER', username bắt đầu từ b21dccn001
INSERT INTO users (username, password, email, role) VALUES
('b21dccn001', 'password123', 'b21dccn001@example.com', 'USER'),
('b21dccn002', 'password123', 'b21dccn002@example.com', 'USER'),
('b21dccn003', 'password123', 'b21dccn003@example.com', 'USER'),
('b21dccn004', 'password123', 'b21dccn004@example.com', 'USER'),
('b21dccn005', 'password123', 'b21dccn005@example.com', 'USER'),
('b21dccn006', 'password123', 'b21dccn006@example.com', 'USER'),
('b21dccn007', 'password123', 'b21dccn007@example.com', 'USER'),
('b21dccn008', 'password123', 'b21dccn008@example.com', 'USER'),
('b21dccn009', 'password123', 'b21dccn009@example.com', 'USER'),
('b21dccn010', 'password123', 'b21dccn010@example.com', 'USER');

-- Thêm 1 dữ liệu với role là 'ADMIN'
INSERT INTO users (username, password, email, role) VALUES
('admin', 'adminpassword', 'admin@example.com', 'ADMIN');