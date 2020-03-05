create table Thread_table
(
thread_id NUMBER(8) NOT NULL,
title VARCHAR2(500) NOT NULL,
tname VARCHAR2(100) NOT NULL,
content VARCHAR2(500) NOT NULL,
name VARCHAR2(100),
thread_time date default sysdate,
primary key(thread_id)
);
--create table  p354

create sequence thread_sequence
start with 1
increment by 1
maxvalue 1000
;

insert into Thread_table
	(thread_id , title , tname , content , name)
	values(thread_sequence.nextval,'ウンチ','ウンチ','ウンチ','ウンチ');

create table res_table
	(
		thread_id NUMBER(8) NOT NULL,
		rname VARCHAR2(100) NOT NULL,
		res_content VARCHAR2(300) NOT NULL,
		res_time date default sysdate,
		FOREIGN key (thread_id) references Thread_table(thread_id)
	);

insert into res_table
	(thread_id , rname , res_contnt)
	values(1,'ウンチ','ウンチ');

Drop table Thread_table;
Drop  sequence thread_sequence;
Drop table res_table;