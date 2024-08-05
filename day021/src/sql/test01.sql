--주석
/*
 * 여러줄 주석
*/ 

--SQL == 스크립트어 == 인터프린터 언어 == 내가 지정한 부분만 수행된다.
--테이블 SQL 생성 CREATE 삭제 DROP 변경 ALTER 잘쓰이지 않는다. 테이블 변경을 할때는 설계를 다시해야한다.
--DB / 배열리스트 / 데이터 묶음 / DTO N 여러개 공간
-- SQL은 대소문자 구분을 안해서 가독성을 위해 대문자로 작성하는게 관례이다.
--데이터 SQL 추가 INSERT 변경 UPDATE 삭제 DELETE 출력 SELECT
--NULL이면 안됨/ 한글자당 3바이트
--속성,필드,attribute,property,멤버변수 작성
CREATE TABLE PRODUCT(
  NUM INT PRIMARY KEY,
  NAME VARCHAR(150) NOT NULL, 
  PRICE INT,
  CNT INT DEFAULT 0
);
-- 테이블은 똑같은 이름으로 여러개 만들수 없습니다.
-- 컬럼(COLUMN) 제약조건
INSERT INTO PRODUCT VALUES(11,'콜라',1200,10); -- 순서대로 넣어주어야 된다.
INSERT INTO PRODUCT (NUM,NAME,PRICE,CNT) VALUES(12,'콜라',1200,10); -- 보편적으로 이렇게 쓴다.
INSERT INTO PRODUCT (NUM,NAME,PRICE) VALUES(13,'사이다',700); -- DEFALUT 값이 들어가서 실행된다.
INSERT INTO PRODUCT (NUM,NAME,PRICE) VALUES(14,'라면',700); 
INSERT INTO PRODUCT (NUM,NAME,PRICE) VALUES(15,'신라면',700); 
INSERT INTO PRODUCT (NUM,NAME,PRICE) VALUES(16,'다이제',700); 
INSERT INTO PRODUCT (NUM,NAME,PRICE,CNT) VALUES(14,700,700); -- NULL이 되면 안되서 에러

SELECT * FROM PRODUCT WHERE NAME LIKE '%라%';
SELECT * FROM PRODUCT WHERE NAME LIKE '%이%';
SELECT * FROM PRODUCT; -- 이렇게 잘안쓴다 절대 쓰지마라
SELECT NUM,NAME,PRICE,CNT FROM PRODUCT;
SELECT NUM,NAME,CNT FROM PRODUCT;
SELECT * FROM PRODUCT WHERE PRICE>=1000;
SELECT * FROM PRODUCT ORDER BY NUM DESC; --ASC
SELECT * FROM PRODUCT WHERE PRICE>=1000 ORDER BY NUM DESC;


DROP TABLE PRODUCT;