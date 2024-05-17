show databases;
use inhouse;

drop table if exists team;
create table team
(
    id bigint auto_increment,
    name varchar(100),
    primary key (id)
);

drop table if exists member;
create table member
(
    id bigint auto_increment,
    name varchar(100),
    team_name varchar(100),
    is_manager tinyint(1),
    work_start_date date,
    birthday date,
    primary key (id)
);
