/* 1. (2 points) List the customer (CustomerID and CustomerName) whose name begins with “C”.*/
SELECT CustomerID, CustomerName FROM CUSTOMER_T WHERE CustomerName LIKE 'C%';

/* 2. (4 points) List the first names of all employees.*/
SELECT SUBSTR(EmployeeName,0,INSTR(EmployeeName, ' ')) AS "First Name" FROM EMPLOYEE_T;

/* 3. (3 points) List customers (CustomerID and CustomerName) who live in California orWashington,
ordered by descending zip code: */
SELECT CustomerId, CustomerName FROM CUSTOMER_T 
WHERE CustomerState LIKE 'CA' OR CustomerState LIKE 'WA' 
ORDER BY CustomerPostalCode DESC;

/* 4. (4 points) List employees who were hired in 1999 as shown below.*/
SELECT EmployeeName, TO_CHAR(EmployeeDateHired, 'Mon dd, YYYY') AS "Employee Hired Date" FROM EMPLOYEE_T 
WHERE EmployeeDateHired BETWEEN '01-JAN-99' AND '31-DEC-99';

/* 5. (4 points) List the number of orders placed per customer as shown below.*/
SELECT CustomerId,COUNT(CustomerId) AS "Total Number Of Orders"
FROM Order_T GROUP BY CustomerId ORDER BY CustomerId;

/* 6. (5 points) For every product that has been ordered, display the product number and the total quantity
ordered. List the most popular product first and the least popular last.*/
SELECT ProductId,COUNT(ProductId) AS "Total Ordered Quanity"
FROM ORDERLINE_T GROUP BY ProductId ORDER BY "Total Ordered Quanity" DESC;

/* 7. (4 points) In the result of Q6, add another column ‘Popularity’ whose value is derived from the total
ordered quantity using the following rule:*/
SELECT ProductId,SUM(ProductId) AS "Total Ordered Quanity", 
      CASE 
          WHEN SUM(ProductId) > 10   THEN 'Best'
          WHEN SUM(ProductId) > 4    THEN 'Good'
          ELSE 'Bad'
       END 
       AS "Popularity"
FROM ORDERLINE_T GROUP BY ProductId ORDER BY("Total Ordered Quanity") DESC;

/* 8. (4 points) List orders which has more than one product item as shown below.*/
SELECT OrderId, SUM(OrderedQuantity) AS "Number of Products" 
FROM ORDERLINE_T 
WHERE OrderedQuantity > 1 
GROUP BY OrderId;

/* 9. (5 points) Display the customer number, customer name, and order number for all customer orders.*/
SELECT c.CustomerId, c.CustomerName, o.OrderId
FROM CUSTOMER_T c JOIN ORDER_T o
ON o.CustomerId = c.CustomerId;

/* 10. (5 points) Display order information made by CustomerID 4. The list includes order number, customer
number, order date, product number, product description, and ordered quantity. (Note: Use one
block query. No nested query)*/
SELECT o.OrderId, c.CustomerId, o.OrderDate, ol.ProductId, p.ProductDescription, ol.OrderedQuantity
FROM CUSTOMER_T c JOIN ORDER_T o
ON o.CustomerId= c.CustomerId
JOIN ORDERLINE_T ol ON ol.OrderId = o.OrderId
JOIN PRODUCT_T p ON p.ProductId = ol.ProductId;

/* 11. (5 points) Display the customer number, name, and order number for all customer orders. For those
customers who do not have any orders, include them in the display once. Display the results in order by
customer number.*/
SELECT c.CustomerId, c.CustomerName, o.OrderId
FROM CUSTOMER_T c LEFT OUTER JOIN ORDER_T o
ON o.CustomerId = c.CustomerId
ORDER BY c.CustomerId;

/* 12. (5 points) List employee name and his/her supervisor name (label this value Supervisor).*/
SELECT e.EmployeeName, s.EmployeeName AS "Supervisor"
FROM EMPLOYEE_T e
JOIN EMPLOYEE_T s ON s.EmployeeSupervisor = e.EmployeeId;

/* 13. (5 points) Display the customer number and customer name who do not have any orders.
(NOTE: Use a nested query structure.)*/
SELECT c.CustomerName, c.CustomerId
FROM CUSTOMER_T c 
WHERE (
  SELECT COUNT(o.CustomerId)
  FROM ORDER_T o 
  WHERE c.CUSTOMERID = o.CUSTOMERID
  ) 
= 0;

/* 14. (5 points) Customer names of customers who have ordered (on same or different orders) BOTH
products 3 (ProductID=3) and 4 (ProductID=4). (HINT: A set operator is needed.)*/
SELECT CustomerName FROM CUSTOMER_T c JOIN (
  SELECT CustomerId FROM CUSTOMER_T
  INTERSECT
  SELECT CustomerId FROM Order_T
  INTERSECT
  SELECT ProductId FROM ORDERLINE_T
  INTERSECT
  SELECT ProductId FROM PRODUCT_T WHERE ProductId =  3 OR ProductId = 4
  ) nq 
ON c.CustomerId = nq.CustomerId ;






