-- Create user to connect to the database
create user 'myuser'@'localhost' identified by 'xxxx';
grant all on *.* to 'myuser'@'localhost';

-- Create the database if it doesn't exist
CREATE DATABASE IF NOT EXISTS loginapp;
USE loginapp;

-- Create the users table if it doesn't exist
CREATE TABLE IF NOT EXISTS users (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(100) NOT NULL,
    name VARCHAR(100) NOT NULL,
    role_id INT NOT NULL,
    FOREIGN KEY (role_id) REFERENCES roles(role_id)
);

CREATE TABLE IF NOT EXISTS roles (
    role_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL
);

INSERT INTO roles (name) VALUES ('User');
INSERT INTO roles (name) VALUES ('Manager');

INSERT INTO users (username, password, name, role_id) VALUES ('john_user', 'user123', 'John User', 1);
INSERT INTO users (username, password, name, role_id) VALUES ('jane_manager', 'manager123', 'Jane Manager', 2);


-- Display table data
SELECT * FROM users;
SELECT * FROM roles;
