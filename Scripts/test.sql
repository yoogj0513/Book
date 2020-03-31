-- 회원 등록
select user(), database();
use book;

select * from user;
select * from product;
select * from product where p_no = 1;
select * from cart;

insert into user values
(1, '김가나', 'gana', '12345', 'gana@test.com', now(), true),
(2, '나동현', 'dong', '12345', 'dong@test.com', now(), false);