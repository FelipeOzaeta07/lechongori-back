CREATE TABLE sales_lechongori (
    product_id INT PRIMARY KEY AUTO_INCREMENT,
    product_title VARCHAR(255),
    product_description TEXT,
    product_price DECIMAL(10, 2),
    product_slug VARCHAR(255) UNIQUE,
    product_type ENUM('LECHONA', 'TAMAL', 'EMPANADAS', 'CARNE', 'SANCOCHO', 'COSTILLAS')
);

CREATE TABLE product_images (
    product_id INT,
    product_image VARCHAR(255),
    FOREIGN KEY (product_id) REFERENCES product_lechongori(product_id) ON DELETE CASCADE
);

CREATE TABLE sales_lechongori (
    sale_id INT PRIMARY KEY AUTO_INCREMENT,
    sale_date DATE,
    sale_total_value DECIMAL(10, 2)
);

CREATE TABLE sales_product_lechongori (
    id INT PRIMARY KEY AUTO_INCREMENT,
    sales_id INT,
    product_id INT,
    amount_sales_product INT,
    FOREIGN KEY (sales_id) REFERENCES sales_lechongori(sale_id) ON DELETE CASCADE,
    FOREIGN KEY (product_id) REFERENCES product_lechongori(product_id) ON DELETE CASCADE
);