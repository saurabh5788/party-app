drop table if exists PARTY;
create table PARTY
(
   ID integer not null,
   NAME varchar(255) not null,
   EMAIL varchar(255) not null,
   primary key(id)
);