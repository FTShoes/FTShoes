create database	ftshoes; 
use ftshoes;

/*--TABLE ROLE*/
CREATE TABLE IF NOT EXISTS roles (
   Role_id VARCHAR(100) NOT NULL,
   NameRole VARCHAR(30) NOT NULL,
   description VARCHAR(255),
   CONSTRAINT pk_role PRIMARY KEY(role_id)
);

/*--TABLE MEMBER*/
CREATE TABLE IF NOT EXISTS employees (
	Employees_id VARCHAR(100) NOT NULL,
    NameEmployees VARCHAR(100) NOT NULL,
    Email VARCHAR(100) NOT NULL,
    Phone VARCHAR(20),
    Address VARCHAR(255),
    GenderEmployees VARCHAR(20),
    Role_id VARCHAR (100) NOT NULL,
    password VARCHAR(100) NOT NULL,
    CONSTRAINT pk_employees PRIMARY KEY(Employees_id),
    CONSTRAINT fk_employees_role FOREIGN KEY (Role_id) REFERENCES roles(Role_id) ON DELETE CASCADE
);

/*--TABLE PRODUCER(NHA SAN XUAT)*/
CREATE TABLE IF NOT EXISTS producer (
	Producer_id VARCHAR(100) NOT NULL,
    NameProducer VARCHAR(100) NOT NULL,
    Phone	VARCHAR(20),
    Address VARCHAR(255),
    CONSTRAINT pk_producer PRIMARY KEY(Producer_id)
);

/*--TABLE PRODUCT(SAN PHAM)*/
CREATE TABLE IF NOT EXISTS product (
	Product_id VARCHAR(100) NOT NULL,
    NameProduct VARCHAR(100) NOT NULL,
    Producer_id VARCHAR(100) NOT NULL,
    TypeProduct VARCHAR(100),
    Size INT,
    AmountProduct VARCHAR(100) NOT NULL,
	Price DECIMAL(19,2),
    DayInput DATE,
    CONSTRAINT pk_product PRIMARY KEY(Product_id),
    CONSTRAINT fk_product_producer FOREIGN KEY (Producer_id) REFERENCES producer(Producer_id) ON DELETE CASCADE
);

/*--TABLE SALE INVOICES (HOA DON)*/
CREATE TABLE IF NOT EXISTS saleInvoices (
	Sale_id VARCHAR(100) NOT NULL,
    Employees_id VARCHAR(100) NOT NULL,
    Customer_id VARCHAR(100) NOT NULL,
    NameCustomer VARCHAR(100) NOT NULL,
    PhoneCustomer VARCHAR(20),
    DayOutput DATE,
    TotalMoney DECIMAL(19,2),
    TotalInput Decimal(19,2),
    TolalOutput Decimal(19,2),
    CONSTRAINT pk_saleInvoices PRIMARY KEY(Sale_id ),
    CONSTRAINT fk_pk_saleInvoices_employees FOREIGN KEY (Employees_id) REFERENCES employees(Employees_id) ON DELETE CASCADE
);

/*--TABLE DETAIL INVOICES (CHI TIET HOA DON) */
CREATE TABLE IF NOT EXISTS detailInvoices (
	Sale_id VARCHAR(100) NOT NULL,
    Product_id VARCHAR(100) NOT NULL,
    Amount INT,
    Price DECIMAL(19,2),
    Total DECIMAL(19,2),
    CONSTRAINT fk_pk_detailInvoices_saleInvoices FOREIGN KEY (Sale_id) REFERENCES saleInvoices(Sale_id) ON DELETE CASCADE,
    CONSTRAINT fk_pk_detailInvoices_product FOREIGN KEY (Product_id) REFERENCES product(Product_id) ON DELETE CASCADE  
);

SELECT * FROM ftshoes.roles;
SELECT * FROM ftshoes.employees;
SELECT * FROM ftshoes.producer;
SELECT * FROM ftshoes.product;
SELECT * FROM ftshoes.saleInvoices;
SELECT * FROM ftshoes.detailInvoices;

INSERT INTO `ftshoes`.`roles` (`Role_id`, `NameRole`, `description`) VALUES ('123', 'MANAGER', 'quan li');
INSERT INTO `ftshoes`.`roles` (`Role_id`, `NameRole`, `description`) VALUES ('234', 'USER', 'nhan vien');


INSERT INTO `ftshoes`.`employees` (`Employees_id`, `NameEmployees`, `Email`, `Phone`, `Address`, `GenderEmployees`, `Role_id`, `password`) 
			VALUES ('nv1', 'nva', 'nva@gmail.com', '0123456789', '38/2 nguyen van troi', 'nam', '123', 'nva');
INSERT INTO `ftshoes`.`employees` (`Employees_id`, `NameEmployees`, `Email`, `Phone`, `Address`, `GenderEmployees`, `Role_id`, `password`) 
			VALUES ('nv2', 'nvb', 'nvb@gmail.com', '0907633999', '38/2 nguyen van troi, Q.PN TPHCM', 'nu', '234', 'nvb');
            
            
INSERT INTO `ftshoes`.`producer` (`Producer_id`, `NameProducer`, `Phone`, `Address`) VALUES ('pro01', 'CTy ABC', '00000000001', 'Q10, TPHCM');
INSERT INTO `ftshoes`.`producer` (`Producer_id`, `NameProducer`, `Phone`, `Address`) VALUES ('pro02', 'CTy DEF001', '09876567890', '185 Hoang Van Thu Q.PN TPHCM');
INSERT INTO `ftshoes`.`producer` (`Producer_id`, `NameProducer`, `Phone`, `Address`) VALUES ('pro03', 'CTy DEF001', '09876561234', '186 Hoang Van Thu Q.PN TPHCM');
INSERT INTO `ftshoes`.`producer` (`Producer_id`, `NameProducer`, `Phone`, `Address`) VALUES ('pro04', 'CTy Dsdfb', '09876243232', '187 Hoang Van Thu Q.PN TPHCM');


INSERT INTO `ftshoes`.`product` (`Product_id`, `NameProduct`, `Producer_id`, `TypeProduct`, `Size`, `AmountProduct`, `Price`, `DayInput`) VALUES ('sp01', 'giay ', 'pro01', 'giay nam', '40', '20', '400000', '2019/10/25');
INSERT INTO `ftshoes`.`product` (`Product_id`, `NameProduct`, `Producer_id`, `TypeProduct`, `Size`, `AmountProduct`, `Price`, `DayInput`) VALUES ('sp02', 'vo', 'pro01', 'phu kien', '35', '20', '20000', '2019/12/05');
INSERT INTO `ftshoes`.`product` (`Product_id`, `NameProduct`, `Producer_id`, `TypeProduct`, `Size`, `AmountProduct`, `Price`, `DayInput`) VALUES ('sp03', 'giay ', 'pro02', 'giay nam', '40', '20', '400000', '2019/10/25');
INSERT INTO `ftshoes`.`product` (`Product_id`, `NameProduct`, `Producer_id`, `TypeProduct`, `Size`, `AmountProduct`, `Price`, `DayInput`) VALUES ('sp04', 'giay ', 'pro03', 'giay nu', '35', '10', '2000000', '2018/1/25');
INSERT INTO `ftshoes`.`product` (`Product_id`, `NameProduct`, `Producer_id`, `TypeProduct`, `Size`, `AmountProduct`, `Price`, `DayInput`) VALUES ('sp05', 'giay ', 'pro04', 'giay nam', '40', '20', '400000', '2017/10/05');


INSERT INTO `ftshoes`.`saleInvoices` (`Sale_id`, `Employees_id`, `Customer_id`, `NameCustomer`, `PhoneCustomer`, `DayOutput`, `TotalMoney`, `TotalInput`, `TolalOutput`) VALUES ('hd0001', 'nv1', '1234567890', 'le van A ', '09090909', '2019/02/26', '5000000', '6000000', '100000');


INSERT INTO `ftshoes`.`detailInvoices` (`Sale_id`, `Product_id`, `Amount`, `Price`, `Total`) VALUES ('hd0001', 'sp01', '5', '20000', '100000');
INSERT INTO `ftshoes`.`detailInvoices` (`Sale_id`, `Product_id`, `Amount`, `Price`, `Total`) VALUES ('hd0001', 'sp01', '5', '20000', '100000');


