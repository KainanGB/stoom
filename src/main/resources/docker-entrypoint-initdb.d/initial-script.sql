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


-- Inserindo dados na tabela t_categories
INSERT INTO t_categories (category) VALUES
('Electronics'),
('Clothing'),
('Home Appliances');

-- Inserindo dados na tabela t_brands
INSERT INTO t_brands (brand) VALUES
('Sony'),
('Nike'),
('Samsung');

-- Inserindo dados na tabela t_products
INSERT INTO t_products (category_id, brand_id, name, price) VALUES
(1, 1, 'Sony TV', 499.99),
(1, 3, 'Samsung Phone', 299.99),
(2, 2, 'Nike Shoes', 79.99),
(3, 3, 'Samsung Refrigerator', 899.99);

-- Inserindo dados na tabela t_orders
INSERT INTO t_orders (product_id, quantity, amount) VALUES
(1, 1, 499.99),
(2, 2, 599.98),
(3, 3, 239.97),
(4, 1, 899.99);
