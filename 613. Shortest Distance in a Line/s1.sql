# Write your MySQL query statement below
SELECT MIN(ABS(p1.x - p2.x)) AS shortest
FROM point AS p1
JOIN point AS p2
ON p1.x != p2.x
;
