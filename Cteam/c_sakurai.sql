create user kingofC identified by takato114514 account unlock;
grant dba to kingofC;

create table Thread_table
(
Thread_id NUMBER(8) NOT NULL,
title VARCHAR2(500) NOT NULL,
t_name VARCHAR2(100) NOT NULL,
t_contents VARCHAR2(500) NOT NULL,
name VARCHAR2(100),
Thread_time DATE default sysdate,
primary key(Thread_id)
);

create sequence thread_sequence
start with 1
increment by 1
maxvalue 1000
;

insert into Thread_table
	(thread_id , title , t_name , t_contents )
	values(thread_sequence.nextval,'あああ','あああ','あああ');
insert into Thread_table
	(thread_id , title , t_name , t_contents )
	values(thread_sequence.nextval,'いいい','いいい','いいい');
insert into Thread_table
	(thread_id , title , t_name , t_contents )
	values(thread_sequence.nextval,'ううう','ううう','ううう');



create table res_table
	(
		Res_id NUMBER(8) NOT NULL,
		Thread_id NUMBER(8) NOT NULL,
		Res_name VARCHAR2(100) NOT NULL,
		Res_contents VARCHAR2(500) NOT NULL,
		Res_time DATE default sysdate,
		PRIMARY KEY(Res_id),
		FOREIGN key (thread_id) references Thread_table(thread_id)
	);

create sequence res_sequence
start with 1
increment by 1
maxvalue 1000
;


insert into res_table
	(res_id , thread_id , Res_name , Res_contents)
	values(res_sequence.nextval, 1,'あああ','あああ');
insert into res_table
	(res_id , thread_id , Res_name , Res_contents)
	values(res_sequence.nextval, 1, 'いいい','いいい');
insert into res_table
	(res_id , thread_id , Res_name , Res_contents)
	values(res_sequence.nextval, 1, 'ううう','ううう');


