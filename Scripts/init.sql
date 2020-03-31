-- 온라인서점
DROP SCHEMA IF EXISTS book;

-- 온라인서점
CREATE SCHEMA book;

-- 사용자
CREATE TABLE book.user (
	u_no       INT         NOT NULL COMMENT '식별자', -- 식별자
	u_name     VARCHAR(20) NOT NULL COMMENT 'name', -- name
	u_id       VARCHAR(20) NOT NULL COMMENT 'id', -- id
	u_password VARCHAR(25) NOT NULL COMMENT 'password', -- password
	u_email    VARCHAR(40) NOT NULL COMMENT 'email', -- email
	u_regDate  DATETIME    NOT NULL COMMENT '등록날짜', -- 등록날짜
	u_isMgr    BOOLEAN     NOT NULL COMMENT '관리자여부' -- 관리자여부
)
COMMENT '사용자';

-- 사용자
ALTER TABLE book.user
	ADD CONSTRAINT PK_user -- 사용자 기본키
		PRIMARY KEY (
			u_no -- 식별자
		);

ALTER TABLE book.user
	MODIFY COLUMN u_no INT NOT NULL AUTO_INCREMENT COMMENT '식별자';

-- 장바구니
CREATE TABLE book.cart (
	c_no    INT NOT NULL COMMENT '식별자', -- 식별자
	c_count INT NOT NULL COMMENT '상품갯수', -- 상품갯수
	u_no    INT NOT NULL COMMENT '사용자 식별자', -- 사용자 식별자
	p_no    INT NOT NULL COMMENT '상품 식별자' -- 상품 식별자
)
COMMENT '장바구니';

-- 장바구니
ALTER TABLE book.cart
	ADD CONSTRAINT PK_cart -- 장바구니 기본키
		PRIMARY KEY (
			c_no -- 식별자
		);

ALTER TABLE book.cart
	MODIFY COLUMN c_no INT NOT NULL AUTO_INCREMENT COMMENT '식별자';

-- 상품
CREATE TABLE book.product (
	p_no        INT          NOT NULL COMMENT '식별자', -- 식별자
	p_name      VARCHAR(100) NOT NULL COMMENT '이름', -- 이름
	p_price     INT          NOT NULL COMMENT '가격', -- 가격
	p_writer    VARCHAR(30)  NOT NULL COMMENT '저자', -- 저자
	p_regDate   DATETIME     NOT NULL COMMENT '등록날짜', -- 등록날짜
	p_detail    TEXT         NOT NULL COMMENT '상세설명', -- 상세설명
	p_publisher VARCHAR(50)  NOT NULL COMMENT '출판사', -- 출판사
	p_type      VARCHAR(20)  NOT NULL COMMENT '책종류', -- 책종류
	p_file      VARCHAR(100) NOT NULL COMMENT '이미지' -- 이미지
)
COMMENT '상품';

-- 상품
ALTER TABLE book.product
	ADD CONSTRAINT PK_product -- 상품 기본키
		PRIMARY KEY (
			p_no -- 식별자
		);

ALTER TABLE book.product
	MODIFY COLUMN p_no INT NOT NULL AUTO_INCREMENT COMMENT '식별자';

-- 장바구니
ALTER TABLE book.cart
	ADD CONSTRAINT FK_user_TO_cart -- 사용자 -> 장바구니
		FOREIGN KEY (
			u_no -- 사용자 식별자
		)
		REFERENCES book.user ( -- 사용자
			u_no -- 식별자
		);

-- 장바구니
ALTER TABLE book.cart
	ADD CONSTRAINT FK_product_TO_cart -- 상품 -> 장바구니
		FOREIGN KEY (
			p_no -- 상품 식별자
		)
		REFERENCES book.product ( -- 상품
			p_no -- 식별자
		);