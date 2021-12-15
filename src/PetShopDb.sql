DROP DATABASE IF EXISTS PetShop;
CREATE DATABASE IF NOT EXISTS PetShop;
SHOW DATABASES;
USE PetShop;
#-------------------------------
DROP TABLE IF EXISTS User;
CREATE TABLE IF NOT EXISTS User(
	UserId VARCHAR(6),
	UserPassword VARCHAR(10),
  	UserName VARCHAR (30) NOT NULL DEFAULT 'Unknown',
  	CONSTRAINT PRIMARY KEY (UserId)
);
SHOW TABLES ;
DESCRIBE User;
#--------------------------------
DROP TABLE IF EXISTS Manager;
CREATE TABLE IF NOT EXISTS Manager(
    MaId VARCHAR(6),
	MaName VARCHAR(30) NOT NULL DEFAULT 'Unknown',
	MaPassword VARCHAR(10),
  	CONSTRAINT PRIMARY KEY (MaId)
);
SHOW TABLES ;
DESCRIBE Manager;
#---------------------------------
DROP TABLE IF EXISTS `Order`;
CREATE TABLE IF NOT EXISTS `Order`(
    orderId VARCHAR(15),
    CustId VARCHAR(15),
    orderDate DATE,
    time VARCHAR(15),
    cost DOUBLE,
    CONSTRAINT PRIMARY KEY (orderId),
    CONSTRAINT FOREIGN KEY (CustId) REFERENCES Customer(CustId) ON DELETE CASCADE ON UPDATE CASCADE
    );
SHOW TABLES ;
DESCRIBE `Order`;
#--------------------------------------
DROP TABLE IF EXISTS `Order`;
CREATE TABLE IF NOT EXISTS `Order`(
   OrderId VARCHAR(9),
   OrderDate VARCHAR(9),
   CustId VARCHAR(6),
   OrderTime VARCHAR(10),
   cost DOUBLE,

   CONSTRAINT PRIMARY KEY (OrderId),
   CONSTRAINT FOREIGN KEY (CustId) REFERENCES Customer(CustId) ON DELETE CASCADE ON UPDATE CASCADE
);
SHOW TABLES ;
DESCRIBE `Order`;
#--------------------------------------
DROP TABLE IF EXISTS `Order Detail`;
CREATE TABLE IF NOT EXISTS `Order Detail`(

    orderId VARCHAR(15),
    OrderDesc VARCHAR(20),
    price DOUBLE,
    CONSTRAINT PRIMARY KEY (orderId)
    );
SHOW TABLES ;
DESCRIBE `Order Detail`;
#--------------------------------------
DROP TABLE IF EXISTS Bill;
CREATE TABLE IF NOT EXISTS Bill(
	BillId VARCHAR(9),
	BillTuype VARCHAR(19),
	BillAmount VARCHAR(10),
	BillDate VARCHAR(10),
	CONSTRAINT PRIMARY KEY (BillId)
);
SHOW TABLES;
DESCRIBE Bill;
#--------------------------------------
DROP TABLE IF EXISTS PetCategory;
CREATE TABLE IF NOT EXISTS PetCategory(
	PetCateId VARCHAR(6),
	PetVerite VARCHAR(10),
 	CONSTRAINT PRIMARY KEY (PetCateId)
);
SHOW TABLES ;
DESCRIBE PetCategory;
#--------------------------------------
DROP TABLE IF EXISTS Pet;
CREATE TABLE IF NOT EXISTS Pet(
   	PetId VARCHAR (6),
   	PetSize VARCHAR(10),
   	PetName VARCHAR (30) NOT NULL DEFAULT 'Unknown',
   	PetPrice VARCHAR(10),
	PetDesc VARCHAR(18),
	PetCateId VARCHAR(6),
  	CONSTRAINT PRIMARY KEY (PetId),
	CONSTRAINT FOREIGN KEY (PetCateId) REFERENCES PetCategory (PetCateId) ON DELETE CASCADE ON UPDATE CASCADE
);
SHOW TABLES ;
DESCRIBE Pet;
#--------------------------------------
DROP TABLE IF EXISTS FoodCategory;
CREATE TABLE IF NOT EXISTS FoodCategory(
	FoodCateId VARCHAR(6),
	FoodVerite VARCHAR(10),

 	CONSTRAINT PRIMARY KEY (FoodCateId)
);
SHOW TABLES ;
DESCRIBE FoodCategory;
#--------------------------------------
DROP TABLE IF EXISTS PetFood;
CREATE TABLE IF NOT EXISTS PetFood(
   	PetFId VARCHAR (6),
   	PetFName VARCHAR (10) NOT NULL DEFAULT 'Unknown',
   	PetFPrice VARCHAR(10),
	PetFDesc VARCHAR(18),
	PetProSize VARCHAR(9),
	FoodCateId VARCHAR(6),
  	CONSTRAINT PRIMARY KEY (PetFId),
	CONSTRAINT FOREIGN KEY (FoodCateId) REFERENCES FoodCategory (FoodCateId) ON DELETE CASCADE ON UPDATE CASCADE
);
SHOW TABLES ;
DESCRIBE PetFood;
#-------------------------------------
DROP TABLE IF EXISTS Productcategory;
CREATE TABLE IF NOT EXISTS ProductCategory(
	ProCateId VARCHAR(6),
	ProVerite VARCHAR(15),
 	CONSTRAINT PRIMARY KEY (ProCateId)
);
SHOW TABLES ;
DESCRIBE Productcategory;
#--------------------------------------
DROP TABLE IF EXISTS PetProduct;
CREATE TABLE IF NOT EXISTS PetProduct(
   	PetPId VARCHAR (6),
   	PetPName VARCHAR (10) NOT NULL DEFAULT 'Unknown',
   	PetPPrice VARCHAR(10),
	PetPDesc VARCHAR(18),
	PetProSize VARCHAR(9),
	ProCateId VARCHAR(6),
  	CONSTRAINT PRIMARY KEY (PetPId),
	CONSTRAINT FOREIGN KEY (ProCateId) REFERENCES ProductCategory (ProCateId) ON DELETE CASCADE ON UPDATE CASCADE
);
SHOW TABLES ;
DESCRIBE PetProduct;
-----------------------
INSERT INTO PetCategory VALUES ("P001","Dog");
INSERT INTO PetCategory VALUES ("P002","Cat");
INSERT INTO PetCategory VALUES ("P003","Fish");
INSERT INTO PetCategory VALUES ("P004","Bird");

INSERT INTO FoodCategory VALUES ("F001","DogFood");
INSERT INTO FoodCategory VALUES ("F002","CatFood");
INSERT INTO FoodCategory VALUES ("F003","FishFood");
INSERT INTO FoodCategory VALUES ("F004","BirdFood");

INSERT INTO Productcategory VALUES ("PC001","DogProduct");
INSERT INTO Productcategory VALUES ("PC002","CatProduct");
INSERT INTO Productcategory VALUES ("PC003","FishProduct");
INSERT INTO Productcategory VALUES ("PC004","BirdProduct");

INSERT INTO Manager VALUES ("M001","Ravidu",1234);



INSERT INTO Item VALUES ("I001","Lemon puf","Small","110.00","10");








