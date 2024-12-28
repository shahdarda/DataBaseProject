create database sac;
use sac;
-- Drop tables if they exist
DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS Customer;
DROP TABLE IF EXISTS orderT;
DROP TABLE IF EXISTS order_item;
DROP TABLE IF EXISTS delivery;
DROP TABLE IF EXISTS purchase;
DROP TABLE IF EXISTS material;
CREATE TABLE Customer (
    c_id INT PRIMARY KEY,
    c_name VARCHAR(255),
    email VARCHAR(255),
    address VARCHAR(255),
    phone VARCHAR(30)
);

INSERT INTO Customer (c_id, c_name, email, address, phone)
VALUES
    (1, 'John Doe', 'john.doe@example.com', '123 Main St, Cityville', '555-1234'),
    (2, 'Jane Smith', 'jane.smith@example.com', '456 Oak St, Townsville', '555-5678'),
    (3, 'Bob Johnson', 'bob.johnson@example.com', '789 Pine St, Villagetown', '555-9012');

drop table purchase;
CREATE TABLE purchase (

    pr_id INT primary key,
    o_id int,
    FOREIGN KEY (o_id) REFERENCES orderT (or_id) ON DELETE CASCADE ON UPDATE CASCADE ,
     payment_confirmation varchar(20),
    payment_method VARCHAR(20),
    transaction_status VARCHAR(20)
);


INSERT INTO purchase (pr_id, o_id, payment_confirmation, transaction_status, payment_method)
VALUES
    (101, 1, 'Confirmed', 'Success', 'Credit Card'),
    (102, 2, 'Confirmed', 'Pending', 'Cash'),
    (103, 3, 'Confirmed', 'Failed', 'Bank Transfer');
	select * from purchase where payment_confirmation= 'Success';
	select * from purchase where pr_id= 101;
    select * from purchase;
    insert into purchase (pr_id, o_id, payment_confirmation, transaction_status, payment_method)
    values
    (104, 4, 'not Confirmed', 'Success', 'Credit Card');
    select * from purchase where o_id = '4' and payment_confirmation= 'Not Confirmed' and transaction_status= 'Success' and payment_method= 'Credit Card';

INSERT INTO purchase (pr_id, o_id, payment_confirmation, transaction_status, payment_method)
VALUES
    
    (105, 1, 'Confirmed', 'Success', 'Credit Card'),
    (106, 2, 'Confirmed', 'Pending', 'Cash'),
    (107, 3, 'Confirmed', 'Success', 'Cash'),
    (108, 4, 'Not Confirmed', 'Pending', 'Credit Card'),
    (109, 5, 'Not Confirmed', 'Pending', 'Cash');


CREATE TABLE orderT(
    or_id INT PRIMARY KEY,
    cu_id int,
    FOREIGN KEY (cu_id) REFERENCES Customer (c_id) ON DELETE CASCADE ON UPDATE CASCADE ,
    Odate DATE,
    total_amount DECIMAL(10, 2) );


INSERT INTO orderT (or_id, cu_id, Odate, total_amount)
VALUES
    (1, 1, '2024-01-01', 100.50),
    (2, 2, '2024-01-02', 75.20),
    (3, 1, '2024-01-03', 150.75),
    (4, 3, '2024-01-04', 200.00);

    drop table orderT;
    Insert into orderT (or_id, cu_id, Odate, total_amount)  values(5,'1','2024-01-02','526.45');
 select * from purchase;
    create table material(
M_id int(32) not Null, 
M_name varchar(64) default Null,
`supplier contact info` varchar(64) default Null,
`unit cost` int(32) default Null,
`stock quantity` int(32) default Null,
supplier varchar(64) default Null,
Description varchar(64) default Null
);

INSERT INTO material (M_id, M_name, `supplier contact info`, `unit cost`, `stock quantity`, supplier, `Description`)
VALUES
  (1, 'White Fabric', 'Supplier_A_Contact@example.com', 5, 200, 'Supplier_A', 'High-quality white fabric for various uses'),
  (2, 'Black Fabric', 'Supplier_B_Contact@example.com', 6, 180, 'Supplier_B', 'Durable black fabric suitable for multiple applications'),
  (3, 'Buttons', 'Supplier_C_Contact@example.com', 1, 500, 'Supplier_C', 'Assorted buttons for bags'),
  (4, 'Keyhooks', 'Supplier_D_Contact@example.com', 2, 300, 'Supplier_D', 'Sturdy keyhooks for bags'),
  (5, 'Underlay Black', 'Supplier_E_Contact@example.com', 8, 100, 'Supplier_E', 'Black underlay for various craftings'),
  (6, 'Underlay White', 'Supplier_F_Contact@example.com', 8, 120, 'Supplier_F', 'White underlay for creative designs'),
  (7, 'Vaslien', 'Supplier_G_Contact@example.com', 15, 50, 'Supplier_G', 'Premium Vaslien material'),
  (8, 'Scarfs', 'Supplier_H_Contact@example.com', 7, 150, 'Supplier_H', 'Fashionable scarfs in different colors and patterns');
  
  CREATE TABLE IF NOT EXISTS delivery (
    delivery_Id INT PRIMARY KEY,
    order_id INT,
	FOREIGN KEY (order_id) REFERENCES orderT (or_id) ON DELETE CASCADE ON UPDATE CASCADE,
    delivery_Date DATE,
    estimated_Delivery_Time VARCHAR(50),
    delivery_Statuse VARCHAR(50),
    shipping_Company VARCHAR(50),
    delivery_Address VARCHAR(255)
);

-- Insert random data into the table
INSERT INTO delivery (delivery_Id, order_Id, delivery_Date, estimated_Delivery_Time, delivery_Statuse, shipping_Company, delivery_Address)
VALUES
    (1, 101, '2024-01-22', '14:00:00', 'In Transit', 'Express Shipping Co.', '456 Maple St, Citytown'),
    (2, 102, '2024-01-23', '10:30:00', 'Delivered', 'Swift Couriers', '789 Oak St, Villageland');
-- Create the product table
CREATE TABLE product (
    pid INT,
    pname VARCHAR(32),
    price INT,
    stock_quantity INT,
    description VARCHAR(255),
    PRIMARY KEY (pid)
);

-- Insert data into the product table
INSERT INTO product (pid, pname, price, stock_quantity, description)
VALUES
    (1, 'Bags', 50, 100, 'A top-notch handmade tote bag, carefully crafted with quality materials for lasting style and durability!'),
    (2, 'Twillies', 20, 150, 'Tie twillies around the handles for an instant style upgrade!'),
    (3, 'Pins', 15, 200, 'Small, mighty accessories for effortlessly styling bags with a personal touch!');
CREATE TABLE order_item (
    pid INT,
    or_id INT,
    quantity INT,
    subtotal DOUBLE,
    FOREIGN KEY (pid) REFERENCES product (pid) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (or_id) REFERENCES orderT (or_id) ON DELETE CASCADE ON UPDATE CASCADE,
    PRIMARY KEY (pid, or_id)
);

-- Insert data into the order_item table
INSERT INTO order_item (pid, or_id, quantity, subtotal)
VALUES
    (1, 1, 2, 100.00),
    (2, 1, 1, 20.00),
    (3, 1, 3, 45.00),
    (2, 2, 2, 40.00),
    (3, 2, 1, 15.00),
    (1, 3, 1, 50.00),
    (2, 3, 2, 40.00),
    (3, 3, 4, 60.00);
    
    select * from order_item;
    select count(*) from purchase p where transaction_status= 'Pending' ;
    select * from purchase;
SELECT * FROM delivery JOIN orderT ON orderT.or_id = delivery.order_Id JOIN customer ON customer.address = delivery.delivery_Address;

select c.address from delivery d Join orderT o on o.or_id = d.order_Id 
Join Customer c on c.c_id = o.cu_id;
select sum(ot.subtotal) from order_item ot Join orderT o on o.or_id = ot.or_id where o.or_id = ot.or_id ;
select * from orderT;
CREATE TABLE production(
    pid INT,
    m_id INT,
    FOREIGN KEY (pid) REFERENCES product (pid) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (m_id) REFERENCES material (M_id) ON DELETE CASCADE ON UPDATE CASCADE,
    PRIMARY KEY (pid, M_id)
);
update material m
 set `stock quantity` = `stock quantity` - 1 
where m.M_id = 1;


