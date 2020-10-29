DROP TABLE IF EXISTS product_category;
DROP TABLE IF EXISTS product_sales;
DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS admin;

CREATE TABLE product_category (
  id INT AUTO_INCREMENT PRIMARY KEY, 
  name VARCHAR(250) NOT NULL
);

CREATE INDEX product_category_name ON product_category(name);

CREATE TABLE product_sales (
  id INT  AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(250) NOT NULL UNIQUE, 
  description VARCHAR(250) NOT NULL, 
  startDate DATE, 
  endDate DATE
);

CREATE TABLE product (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  description VARCHAR(250) NOT NULL,
  cost DOUBLE NOT NULL,
  categoryId INT NOT NULL,
  brand VARCHAR(50) NOT NULL,
  onSale BOOLEAN NOT NULL, 
  saleId INT
);

ALTER TABLE product ADD FOREIGN KEY (categoryId) REFERENCES product_category(id);
ALTER TABLE product ADD FOREIGN KEY (saleId) REFERENCES product_sales(id);

CREATE INDEX product_name ON product(name);

CREATE TABLE admin (
  id INT AUTO_INCREMENT PRIMARY KEY,
  forename VARCHAR(50) NOT NULL, 
  surname VARCHAR(50) NOT NULL, 
  email VARCHAR(100) NOT NULL UNIQUE, 
  password VARCHAR(50) NOT NULL,
  role VARCHAR(50) NOT NULL
);

CREATE INDEX admin_email ON admin(email);