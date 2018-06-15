# Write your MySQL query statement below
SELECT w1.Id
FROM Weather AS w1, Weather AS w2
WHERE w1.Temperature > w2.Temperature
AND w1.RecordDate = w2.RecordDate + INTERVAL 1 DAY
