drop database if exists scrum_coaching;
create database scrum_coaching;
use scrum_coaching;

drop table if exists users;
create table users (
    id int not null primary key, 
    username varchar(16) not null, 
    password varchar(32) not null, 
    email varchar(32) not null, 
    timestamp datetime
);

insert into users values (
    1,
    "user1",
    "user",
    "user@user.com",
    CURRENT_TIMESTAMP()
);

insert into users values (
    2,
    "user2",
    "user",
    "user@user.com",
    CURRENT_TIMESTAMP()
);

insert into users values (
    3,
    "user3",
    "user",
    "user@user.com",
    CURRENT_TIMESTAMP()
);

drop table if exists userRating;
create table userRating (
    id int not null primary key,
    userId int not null,
    reliability int not null default 3,
    efficiency int not null default 3,
    teamplayer int not null default 3,
    foreign key (userId) references users(id)
);