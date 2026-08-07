# Write your MySQL query statement below
Select product_name , year , price
FROM Product
INNER JOIN Sales
on Sales.product_id = Product.product_id