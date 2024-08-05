CREATE TABLE PRODUCT(
	NUM INT PRIMARY KEY,
	NAME VARCHAR(500) NOT NULL,
	PRICE INT,
	CNT INT DEFAULT 0
);

INSERT INTO PRODUCT (NUM,NAME,PRICE,CNT) VALUES ((SELECT NVL(MAX(NUM),0)+1 FROM PRODUCT),?,?,?);
-- pk는 관리자가 넣는게 아니고 시스템에서 넣는 것이다. 
-- 현재 테이블에서 가장 큰값 가져와줘 거기다가 +1 할게 !!!
--SELECT MAX(NUM) FROM PRODUCT;
-- MAX(컬럼명) : 해당 컬럼의 최대값
-- 컬럼== 멤버변수 == 속성== property == attribute == 필드
--NVL(왼쪽의 계산값이 NULL이라면, 0)
--NVL(왼쪽의 계산값이 NULL이라면, 오른쪽 인자 값을 반환)

UPDATE PRODUCT SET CNT=CNT-? WHERE NUM=?;
-- 상품번호 몇번인 상품을 이만큼 깍아줘 !!
-- 구매 !!
DELETE FROM PRODUCT WHERE NUM=?;
-- 상품번호가 몇번인 상품 제거해줘

SELECT NUM,NAME,PRICE,CNT FROM PRODUCT WHERE NUM=?; -- 상품번호 몇번인친구 보여줄래 
SELECT NUM,NAME,PRICE,CNT FROM PRODUCT WHERE NAME=?; -- 상품이름이 이거인 친구 보여줄래
SELECT NUM,NAME,PRICE,CNT FROM PRODUCT ORDER BY NUM;
SELECT NUM,NAME,PRICE,CNT FROM PRODUCT WHERE NAME LIKE '%'||?||'%'; -- 이름으로 검색
SELECT NUM,NAME,PRICE,CNT FROM PRODUCT ORDER BY PRICE; -- 가격순 정렬 아무런 멘트가 없어서 자동 오름차순
--data --row--행--튜플--레코드--DTO
SELECT COUNT(*) AS TOTAL FROM PRODUCT; 
-- 별칭(AS)이 없으면 열 이름이 없어서 JAVA에서 rs를 통해 불러올수 없음


DROP TABLE PRODUCT;