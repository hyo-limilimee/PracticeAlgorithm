SELECT CAR_ID,
MAX(CASE WHEN "2022-10-16" BETWEEN DATE_FORMAT(START_DATE,"%Y-%m-%d") 
    AND DATE_FORMAT(END_DATE,"%Y-%m-%d")
            THEN "대여중"
            ELSE "대여 가능"
        END) AVAILABILITY
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
GROUP BY CAR_ID
ORDER BY CAR_ID DESC