SELECT 'CREATE DATABASE store'
WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'store')\gexec

\connect store

CREATE TABLE IF NOT EXISTS t_categories (
    category_id SERIAL PRIMARY KEY,
    category VARCHAR(255) NOT NULL,
    active BOOLEAN NOT NULL DEFAULT TRUE
);

CREATE TABLE IF NOT EXISTS t_brands (
    brand_id SERIAL PRIMARY KEY,
    brand VARCHAR(255) NOT NULL,
    active BOOLEAN NOT NULL DEFAULT TRUE
);

CREATE TABLE IF NOT EXISTS t_products (
    product_id SERIAL PRIMARY KEY,
    category_id INT,
    brand_id INT,
    name VARCHAR(255) NOT NULL,
    price FLOAT NOT NULL,
    active BOOLEAN NOT NULL DEFAULT TRUE,
    FOREIGN KEY (category_id) REFERENCES t_categories(category_id),
    FOREIGN KEY (brand_id) REFERENCES t_brands(brand_id)
);

CREATE TABLE IF NOT EXISTS t_orders (
    order_id SERIAL PRIMARY KEY,
    product_id INT NOT NULL,
    quantity INT NOT NULL,
    amount FLOAT NOT NULL,
    FOREIGN KEY (product_id) REFERENCES t_products(product_id)
);