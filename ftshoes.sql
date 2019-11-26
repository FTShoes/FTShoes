create database	ftshoes; 
use ftshoes;

/*--TABLE ROLE*/
CREATE TABLE IF NOT EXISTS roles (
   role_id VARCHAR(100) NOT NULL,
   nameRole VARCHAR(30) NOT NULL,
   description VARCHAR(255),
   CONSTRAINT pk_role PRIMARY KEY(role_id)
);

/*--TABLE MEMBER*/
CREATE TABLE IF NOT EXISTS employees (
	employees_id VARCHAR(100) NOT NULL,
    nameEmployees VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    phone VARCHAR(20),
    address VARCHAR(255),
    genderEmployees VARCHAR(20),
    role_id VARCHAR (100) NOT NULL,
    password VARCHAR(100) NOT NULL,
    CONSTRAINT pk_employees PRIMARY KEY(employees_id),
    CONSTRAINT fk_employees_role FOREIGN KEY (role_id) REFERENCES roles(role_id) ON DELETE CASCADE
);

/*--TABLE PRODUCER(NHA SAN XUAT)*/
CREATE TABLE IF NOT EXISTS producer (
	producer_id VARCHAR(100) NOT NULL,
    nameProducer VARCHAR(100) NOT NULL,
    phone	VARCHAR(20),
    address VARCHAR(255),
    CONSTRAINT pk_producer PRIMARY KEY(producer_id)
);

/*--TABLE PRODUCT(SAN PHAM)*/
CREATE TABLE IF NOT EXISTS product (
	product_id VARCHAR(100) NOT NULL,
    nameProduct VARCHAR(100) NOT NULL,
    producer_id VARCHAR(100) NOT NULL,
    typeProduct VARCHAR(100),
    size INT,
    amountProduct INT,
	price DECIMAL(19,2),
    dayInput DATE,
    CONSTRAINT pk_product PRIMARY KEY(product_id),
    CONSTRAINT fk_product_producer FOREIGN KEY (producer_id) REFERENCES producer(producer_id) ON DELETE CASCADE
);

/*--TABLE SALE INVOICES (HOA DON)*/
CREATE TABLE IF NOT EXISTS saleInvoices (
	sale_id VARCHAR(100) NOT NULL,
    employees_id VARCHAR(100) NOT NULL,
    customer_id VARCHAR(100) NOT NULL,
    nameCustomer VARCHAR(100) NOT NULL,
    phoneCustomer VARCHAR(20),
    dayOutput DATE,
    totalMoney DECIMAL(19,2),
    totalInput Decimal(19,2),
    tolalOutput Decimal(19,2),
    CONSTRAINT pk_saleInvoices PRIMARY KEY(sale_id ),
    CONSTRAINT fk_pk_saleInvoices_employees FOREIGN KEY (employees_id) REFERENCES employees(employees_id) ON DELETE CASCADE
);

/*--TABLE DETAIL INVOICES (CHI TIET HOA DON) */
CREATE TABLE IF NOT EXISTS detailInvoices (
	sale_id VARCHAR(100) NOT NULL,
    product_id VARCHAR(100) NOT NULL,
    amount INT,
    price DECIMAL(19,2),
    total DECIMAL(19,2),
    CONSTRAINT fk_pk_detailInvoices_saleInvoices FOREIGN KEY (sale_id) REFERENCES saleInvoices(sale_id) ON DELETE CASCADE,
    CONSTRAINT fk_pk_detailInvoices_product FOREIGN KEY (product_id) REFERENCES product(product_id) ON DELETE CASCADE  
);

SELECT * FROM ftshoes.roles;
SELECT * FROM ftshoes.employees;
SELECT * FROM ftshoes.producer;
SELECT * FROM ftshoes.product;
SELECT * FROM ftshoes.saleInvoices;
SELECT * FROM ftshoes.detailInvoices;

INSERT INTO `ftshoes`.`roles` (`role_id`, `nameRole`, `description`) VALUES ('123', 'MANAGER', 'quan li');
INSERT INTO `ftshoes`.`roles` (`role_id`, `nameRole`, `description`) VALUES ('234', 'USER', 'nhan vien');


INSERT INTO `ftshoes`.`employees` (`employees_id`, `nameEmployees`, `email`, `phone`, `address`, `genderEmployees`, `role_id`, `password`) 
			VALUES ('nv1', 'nva', 'nva@gmail.com', '0123456789', '38/2 nguyen van troi', 'nam', '123', 'nva');
INSERT INTO `ftshoes`.`employees` (`employees_id`, `nameEmployees`, `email`, `phone`, `address`, `genderEmployees`, `role_id`, `password`) 
			VALUES ('nv2', 'nvb', 'nvb@gmail.com', '0907633999', '38/2 nguyen van troi, Q.PN TPHCM', 'nu', '234', 'nvb');
            
            
INSERT INTO `ftshoes`.`producer` (`producer_id`, `nameProducer`, `phone`, `address`) VALUES ('pro01', 'CTy ABC', '00000000001', 'Q10, TPHCM');
INSERT INTO `ftshoes`.`producer` (`producer_id`, `nameProducer`, `phone`, `address`) VALUES ('pro02', 'CTy DEF001', '09876567890', '185 Hoang Van Thu Q.PN TPHCM');
INSERT INTO `ftshoes`.`producer` (`producer_id`, `nameProducer`, `phone`, `address`) VALUES ('pro03', 'CTy DEF001', '09876561234', '186 Hoang Van Thu Q.PN TPHCM');
INSERT INTO `ftshoes`.`producer` (`producer_id`, `nameProducer`, `phone`, `address`) VALUES ('pro04', 'CTy Dsdfb', '09876243232', '187 Hoang Van Thu Q.PN TPHCM');


INSERT INTO `ftshoes`.`product` (`product_id`, `nameProduct`, `producer_id`, `typeProduct`, `size`, `amountProduct`, `price`, `dayInput`) VALUES ('sp01', 'giay ', 'pro01', 'giay nam', '40', '20', '400000', '2019/10/25');
INSERT INTO `ftshoes`.`product` (`product_id`, `nameProduct`, `producer_id`, `typeProduct`, `size`, `amountProduct`, `price`, `dayInput`) VALUES ('sp02', 'vo', 'pro01', 'phu kien', '35', '20', '20000', '2019/12/05');
INSERT INTO `ftshoes`.`product` (`product_id`, `nameProduct`, `producer_id`, `typeProduct`, `size`, `amountProduct`, `price`, `dayInput`) VALUES ('sp03', 'giay ', 'pro02', 'giay nam', '40', '20', '400000', '2019/10/25');
INSERT INTO `ftshoes`.`product` (`product_id`, `nameProduct`, `producer_id`, `typeProduct`, `size`, `amountProduct`, `price`, `dayInput`) VALUES ('sp04', 'giay ', 'pro03', 'giay nu', '35', '10', '2000000', '2018/1/25');
INSERT INTO `ftshoes`.`product` (`product_id`, `nameProduct`, `producer_id`, `typeProduct`, `size`, `amountProduct`, `price`, `dayInput`) VALUES ('sp05', 'giay ', 'pro04', 'giay nam', '40', '20', '400000', '2017/10/05');


INSERT INTO `ftshoes`.`saleInvoices` (`sale_id`, `employees_id`, `customer_id`, `nameCustomer`, `phoneCustomer`, `dayOutput`, `totalMoney`, `totalInput`, `tolalOutput`) VALUES ('hd0001', 'nv1', '1234567890', 'le van A ', '09090909', '2019/02/26', '5000000', '6000000', '100000');


INSERT INTO `ftshoes`.`detailInvoices` (`sale_id`, `product_id`, `amount`, `price`, `total`) VALUES ('hd0001', 'sp01', '5', '20000', '100000');
INSERT INTO `ftshoes`.`detailInvoices` (`sale_id`, `product_id`, `amount`, `price`, `total`) VALUES ('hd0001', 'sp01', '5', '20000', '100000');
INSERT INTO `ftshoes`.`detailInvoices` (`sale_id`, `product_id`, `amount`, `price`, `total`) VALUES ('hd0001', 'sp02', '6', '20000', '120000');


