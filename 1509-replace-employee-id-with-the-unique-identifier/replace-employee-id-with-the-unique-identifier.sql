# Write your MySQL query statement below
Select name , unique_id FROM Employees
LEFT JOIN EmployeeUNI
on Employees.id = EmployeeUNI.id