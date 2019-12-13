drop database if exists mydb;
create database mydb charset=utf8;
use mydb;
create table `user`(
  id int primary key auto_increment,
  name varchar(50),
  password varchar(50)
);
insert into    `user`(name,password) value ('admin','admin');
insert into    `user`(name,password) value ('test','test');
insert into    `user`(name,password) value ('test','test');
insert into    `user`(name,password) value ('test','test');
insert into    `user`(name,password) value ('test','test');
insert into    `user`(name,password) value ('test','test');
insert into    `user`(name,password) value ('test','test');
insert into    `user`(name,password) value ('test','test');

show databases;

select * from user

