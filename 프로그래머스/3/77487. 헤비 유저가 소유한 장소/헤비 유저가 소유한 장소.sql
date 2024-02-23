# 헤비유저가 등록한 공간의 정보
# 헤비유저: 공간을 둘 이상 등록한 사람


SELECT ID, NAME, HOST_ID
FROM PLACES
WHERE HOST_ID 
IN (SELECT HOST_ID
      FROM PLACES
      GROUP BY HOST_ID
       HAVING COUNT(HOST_ID) >= 2 
      )
ORDER BY ID;