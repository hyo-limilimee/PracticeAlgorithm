SELECT c.APNT_NO, a.PT_NAME, c.PT_NO, c.MCDP_CD, b.DR_NAME, c.APNT_YMD
FROM APPOINTMENT c
JOIN PATIENT a
ON a.PT_NO = c.PT_NO
JOIN DOCTOR b
ON b.DR_ID = c.MDDR_ID
WHERE c.MCDP_CD = "CS"
AND APNT_CNCL_YN = 'N'
AND DATE_FORMAT(APNT_YMD,'%Y-%m-%d') = "2022-04-13"
ORDER BY c.APNT_YMD