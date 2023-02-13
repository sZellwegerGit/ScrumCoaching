drop database if exists scrum_coaching;
create database scrum_coaching;
use scrum_coaching;

drop table if exists scrumcoach;
create table scrumcoach (id int not null primary key, username varchar(16) not null, name varchar(32) not null, password varchar(32) not null, timestamp datetime);