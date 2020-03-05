create user kingofC identified by takato114514 account unlock;
grant dba to kingofC;

connect kingofC/takato114514

create sequence thread_SEQUENCE
start with 1
increment by 1
maxvalue 1000
;

create table Thread_table
(
Thread_id NUMBER(8) NOT NULL,
title VARCHAR2(500) NOT NULL,
t_name VARCHAR2(100) NOT NULL,
t_contents VARCHAR2(500) NOT NULL,
name VARCHAR2(100),
thread_time date default sysdate,
primary key(thread_id)
);

create sequence res_SEQUENCE
start with 1
increment by 1
maxvalue 1000
;

create table res_table
	(
		res_id number(8) NOT NULL,
		thread_id NUMBER(8) NOT NULL,
		res_name VARCHAR2(100) NOT NULL,
		res_contents VARCHAR2(300) NOT NULL,
		res_time date default sysdate,
		primary key(res_id),
		FOREIGN key (thread_id) references Thread_table(thread_id)
	);

exit