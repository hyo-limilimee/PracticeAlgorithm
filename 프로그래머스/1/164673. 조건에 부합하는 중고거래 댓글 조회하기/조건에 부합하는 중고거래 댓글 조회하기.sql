SELECT T1.TITLE
     , T1.BOARD_ID
     , T2.REPLY_ID
     , T2.WRITER_ID
     , T2.CONTENTS
     , DATE_FORMAT(T2.CREATED_DATE, '%Y-%m-%d')    AS CREATED_DATE
  FROM USED_GOODS_BOARD    AS T1
  JOIN USED_GOODS_REPLY    AS T2 
  ON T2.BOARD_ID = T1.BOARD_ID
 WHERE DATE_FORMAT(T1.CREATED_DATE, '%Y%m') = '202210'
 ORDER BY T2.CREATED_DATE, T1.TITLE