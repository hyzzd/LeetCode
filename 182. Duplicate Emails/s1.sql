# Write your MySQL query statement below
SELECT Email
FROM (
    SELECT Email, COUNT(Email) AS Temp
    FROM Person 
    GROUP BY Email
) AS Ali
WHERE Temp > 1
;
