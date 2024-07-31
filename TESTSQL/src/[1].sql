-- Q1
-- 제품 테이블(PRODUCT)을 다음의 제약조건들을 모두 만족할 수 있도록 생성하세요.
-- 1) 제품 번호(PID)는 PK 입니다.
-- 2) 제품 이름(NAME),가격(PRICE),카테고리(CATEGORY)는 NULL 을 허용하지않습니다.
-- 3) 제품 재고(CNT)는 0 을 기본 값으로 가집니다.
CREATE TABLE PRODUCT (
    PID INT PRIMARY KEY, -- 제품 번호(PID)는 PK 입니다.
    NAME VARCHAR(50) NOT NULL, -- 제품 이름(NAME), 가격(PRICE), 카테고리(CATEGORY)는 NULL을 허용하지 않습니다.
    PRICE DECIMAL(10,2) NOT NULL, -- 가격
    CATEGORY VARCHAR(20) NOT NULL, -- 카테고리
    CNT INT DEFAULT 0 -- 제품 재고(CNT)는 0을 기본 값으로 가집니다.
);
-- Q2
-- 제품 테이블에 제품 번호가 11 부터 20 까지 순차적으로 적용될 수 있도록 10 개의 제품을 등록하세요.
INSERT INTO PRODUCT (PID, NAME, PRICE, CATEGORY, CNT) VALUES (11,'운동화',59000,'신발',10);
INSERT INTO PRODUCT (PID, NAME, PRICE, CATEGORY, CNT) VALUES (12,'실내화',9900,'신발',24);
INSERT INTO PRODUCT (PID, NAME, PRICE, CATEGORY, CNT) VALUES (13,'샌들',28000,'신발',30);
INSERT INTO PRODUCT (PID, NAME, PRICE, CATEGORY, CNT) VALUES (14,'콜라',1200,'음료',100);
INSERT INTO PRODUCT (PID, NAME, PRICE, CATEGORY, CNT) VALUES (15,'사이다',900,'음료',95);
INSERT INTO PRODUCT (PID, NAME, PRICE, CATEGORY, CNT) VALUES (16,'단팥빵',1500,'빵',20);
INSERT INTO PRODUCT (PID, NAME, PRICE, CATEGORY, CNT) VALUES (17,'소보로',1400,'빵',21);
INSERT INTO PRODUCT (PID, NAME, PRICE, CATEGORY, CNT) VALUES (18,'도너츠',1300,'빵',22);
INSERT INTO PRODUCT (PID, NAME, PRICE, CATEGORY, CNT) VALUES (19,'만화책',23000,'도서',70);
INSERT INTO PRODUCT (PID, NAME, PRICE, CATEGORY, CNT) VALUES (20,'장편소설',21800,'도서',120);
-- Q3
-- 제품 DB 에 등록된 제품들의 모든 컬럼을 출력해주세요.
SELECT PID,NAME,PRICE,CATEGORY,CNT FROM PRODUCT;
-- Q4
-- 다음과 같은 결과가 나오도록 SQL 문을 작성해 보세요.
-- PRODUCT 에서 제품 이름이 세 글자 이상인 제품 정보를 출력합니다.
-- NAME 은 첫 글자와 마지막 글자만 보여 주고 나머지 글자를 * 기호로 출력합니다.
-- 이 NAME 을 MASKING_NAME 이라는 별칭으로 출력해주세요.
SELECT PID, SUBSTR(NAME,1,1) || LPAD('*', LENGTH(NAME) -2, '*') || SUBSTR(NAME, LENGTH(NAME), 1) AS MASKING_NAME, PRICE, CATEGORY, CNT FROM PRODUCT WHERE LENGTH(NAME)>=3;
-- Q5
-- PRODUCT 테이블을 사용하여 다음과 같이 NAME 에 '화'가 들어가는 제품 데이터를 모두 출력하는 SQL 문을 작성해 보세요.
-- 단 PID 에 대하여 오름차순 정렬한 결과로 출력하세요.
SELECT * FROM PRODUCT WHERE NAME LIKE '%화%'ORDER BY PID;
-- Q6
-- PRODUCT 테이블을 사용하여 '신발' 카테고리에 존재하고 있는 제품 중에 가격이 10000원 이상인 제품의 제품 번호, 이름, 가격, 카테고리를 출력하는 SQL 문을 작성해 보세요.
SELECT PID, NAME, PRICE, CATEGORY FROM PRODUCT WHERE CATEGORY = '신발' AND PRICE>=10000;
-- Q7
-- 제품 DB 를 삭제하세요.
DROP TABLE PRODUCT;
