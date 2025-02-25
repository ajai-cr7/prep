- https://leetcode.com/studyplan/top-sql-50/

Important Concepts: 
- Window Functions!
- Stored Procedures!

Note:
- Take 3 hours to read concepts and take notes!
- See you tube and linkedIn and solve atleast 25 FAQ on SQL!
- Write and See A Lot of Queries!

Here are some tricky SQL interview questions!

1. Find the second-highest salary in a table without using LIMIT or TOP.
2. Write a SQL query to find all employees who earn more than their managers.
3. Find the duplicate rows in a table without using GROUP BY.
4. Write a SQL query to find the top 10% of earners in a table.
5. Find the cumulative sum of a column in a table.
6. Write a SQL query to find all employees who have never taken a leave.
7. Find the difference between the current row and the next row in a table.
8. Write a SQL query to find all departments with more than one employee.
9. Find the maximum value of a column for each group without using GROUP BY.
10. Write a SQL query to find all employees who have taken more than 3 leaves in a month.

These questions are designed to test your SQL skills, including your ability to write efficient queries, think creatively, and solve complex problems.

Here are the answers to these questions:

1. SELECT MAX(salary) FROM table WHERE salary NOT IN (SELECT MAX(salary) FROM table)
2. SELECT e1.* FROM employees e1 JOIN employees e2 ON e1.manager_id = (link unavailable) WHERE e1.salary > e2.salary
3. SELECT * FROM table WHERE rowid IN (SELECT rowid FROM table GROUP BY column HAVING COUNT(*) > 1)
4. SELECT * FROM table WHERE salary > (SELECT PERCENTILE_CONT(0.9) WITHIN GROUP (ORDER BY salary) FROM table)
5. SELECT column, SUM(column) OVER (ORDER BY rowid) FROM table
6. SELECT * FROM employees WHERE id NOT IN (SELECT employee_id FROM leaves)
7. SELECT *, column - LEAD(column) OVER (ORDER BY rowid) FROM table
8. SELECT department FROM employees GROUP BY department HAVING COUNT(*) > 1
9. SELECT MAX(column) FROM table WHERE column NOT IN (SELECT MAX(column) FROM table GROUP BY group_column)
10. SELECT * FROM employees WHERE id IN (SELECT employee_id FROM leaves GROUP BY employee_id HAVING COUNT
