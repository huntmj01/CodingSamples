/* 1. (12 points) Write SQLs to create three tables based on given relational schemas and directions below.*/
CREATE TABLE CUSTOMER
        (CustomerID NUMBER(11) NOT NULL,
        CustomerName VARCHAR2(25) NOT NULL,
        CustomerAddr VARCHAR2(30) NOT NULL,
        CONSTRAINT Customer_PK PRIMARY KEY (CustomerID)
        );
        
CREATE TABLE ORDERS
        (OrderID NUMBER(11) NOT NULL,
        CustomerID NUMBER(11) NOT NULL,
        OrderDate DATE DEFAULT SYSDATE NOT NULL,
        CONSTRAINT Order_PK PRIMARY KEY (OrderID),
        CONSTRAINT Order_FK FOREIGN KEY (CustomerID) REFERENCES CUSTOMER(CustomerID) ON DELETE SET NULL);
        
CREATE TABLE PRODUCT
        (ProductID  NUMBER(11) NOT NULL,
        ProductType VARCHAR2(30) CHECK (ProductType IN ('Books','Electronics',
        'Home', 'Clothing')) NOT NULL,
        CONSTRAINT Product_PK PRIMARY KEY (ProductID));
        
CREATE TABLE ORDERLINE
       (OrderID NUMBER(11) NOT NULL,
        ProductID NUMBER(11) NOT NULL,
        OrderQuanity NUMBER(11) NOT NULL,
        CONSTRAINT OrderQuanity_CHK1 CHECK (OrderQuanity > 0),
        CONSTRAINT OrderLine_PK1 PRIMARY KEY (OrderID, ProductID),
        CONSTRAINT OrderLine_FK1 FOREIGN KEY (OrderID) REFERENCES ORDERS(OrderID) ON DELETE CASCADE,
        CONSTRAINT OrderLine_FK2 FOREIGN KEY (ProductID) REFERENCES PRODUCT(ProductID));
        
/* 2. (6 points) Write SQL statements to insert following records into corresponding tables.*/
INSERT INTO CUSTOMER VALUES(1, 'James Park', '1355 S Hines Blvd');
INSERT INTO CUSTOMER VALUES(2, 'Tom Hoffer', '15145 S.W. 17th St.');

INSERT INTO PRODUCT VALUES(711, 'Electronics');
INSERT INTO PRODUCT VALUES(721, 'Books');
INSERT INTO PRODUCT VALUES(722, 'Books');

INSERT INTO ORDERS VALUES (1001, 1, TO_DATE('10/28/2016 18:00', 'mm/dd/yyyy hh24:mi'));
INSERT INTO ORDERS VALUES (1002, 2, TO_DATE('01/01/0001 00:00', 'mm/dd/yyyy hh24:mi'));

INSERT INTO ORDERLINE VALUES (1001, 711, 1);
INSERT INTO ORDERLINE VALUES (1001, 721, 1);
INSERT INTO ORDERLINE VALUES (1002, 722, 3);

/* 3. (2 points) Run a SQL query statement below and check the order date of order number 1002.*/
SELECT * FROM ORDERS;
SELECT OrderDate FROM ORDERS WHERE OrderId = 1002;

/* 4. (4 points) Write SQL statements for followings (1) – (3)*/
UPDATE ORDERLINE SET OrderQuanity = 0 WHERE OrderID =1001 and ProductID=711;
ALTER TABLE ORDERLINE DROP CONSTRAINT OrderQuanity_CHK1;
UPDATE ORDERLINE SET OrderQuanity = 0 WHERE OrderID =1001 and ProductID=711;

/* 5. (4 points) Write SQL statements for followings (1)-(4) and answer for (5).*/
SELECT * FROM ORDERS;
SELECT * FROM ORDERLINE;
UPDATE ORDERLINE SET OrderId = 7772 WHERE OrderId = 1002;
SELECT * FROM ORDERS;
SELECT * FROM ORDERLINE;

/* 6. (4 points) Write SQL statements for followings (1)-(4) and answer for (5).*/
SELECT * FROM ORDERS;
SELECT * FROM ORDERLINE;
DELETE ORDERS WHERE OrderID =1001;
SELECT * FROM ORDERS;
SELECT * FROM ORDERLINE;

/* 7. (4 points) Write SQL statements for followings: */
ALTER TABLE CUSTOMER MODIFY CustomerAddr VARCHAR2(50);
ALTER TABLE PRODUCT ADD ProductPrice NUMBER(11);

/* 8. (4 points) Write SQL statements to remove (drop) all four tables : ORDERS, ORDERLINE,
CUSTOMER, and PRODUCT.*/
DROP TABLE ORDERLINE;
DROP TABLE ORDERS;
DROP TABLE CUSTOMER;
DROP TABLE PRODUCT;


