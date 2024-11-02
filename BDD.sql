create database attendance;

use attendance;

CREATE TABLE roles (
    role_id SERIAL PRIMARY KEY,
    role_name VARCHAR(50) NOT NULL UNIQUE,
    description TEXT,
	status BOOLEAN DEFAULT TRUE
);

CREATE TABLE users (
    user_id SERIAL PRIMARY KEY,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role_id INT REFERENCES roles(role_id) ON DELETE SET NULL,
    status BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE people (
    person_id SERIAL PRIMARY KEY,
    user_id INT REFERENCES users(user_id),
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL, 
    phone VARCHAR(15),
    address VARCHAR(255),
	status BOOLEAN DEFAULT TRUE
);

CREATE TABLE password_resets (
    reset_id SERIAL PRIMARY KEY,
    user_id INT REFERENCES users(user_id) ON DELETE CASCADE,
    token VARCHAR(255) NOT NULL UNIQUE,
    expiration TIMESTAMP NOT NULL,
    used BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
 
CREATE TABLE incomes (
    income_id SERIAL PRIMARY KEY,
    person_id INT REFERENCES people(person_id) ON DELETE CASCADE,
	date DATE NOT NULL,
	time TIME NOT NULL,
    latitude DECIMAL(10, 8),
    longitude DECIMAL(11, 8)
);

CREATE TABLE exits (
    exit_id SERIAL PRIMARY KEY,
    person_id INT REFERENCES people(person_id) ON DELETE CASCADE,
	date DATE NOT NULL,
	time TIME NOT NULL,
    latitude DECIMAL(10, 8),
    longitude DECIMAL(11, 8)
);

