drop database if exists sampledb;
create database sampledb;
use sampledb;

create table sample_table(
    No  int,
    name varchar(50),
    age int,
    Mail varchar(50)
);
insert into sample_table(No,name,age,Mail)
values(1,"Yamada",21,"xxx@yahoo.co.jp");
insert into sample_table(No,name,age,Mail)
values(2,"Sato",39,"yyy@yahoo.co.jp");
insert into sample_table(No,name,age,Mail)
values(3,"Harada",44,"zzz@yahoo.co.jp");