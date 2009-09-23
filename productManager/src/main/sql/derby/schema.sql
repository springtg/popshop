drop table RESOURCES_AUTHORITIES;
drop table ROLES_AUTHORITIES;
drop table USERS_ROLES;
drop table RESOURCES;
drop table AUTHORITIES;
drop table USERS;
drop table ROLES;

create table USERS (
ID integer primary key GENERATED ALWAYS as IDENTITY,
LOGIN_NAME varchar(20) not null unique,
PASSWORD varchar(20),
NAME varchar(20),
EMAIL varchar(30)
);

create unique index USERS_LOGIN_NAME_INDEX on USERS(LOGIN_NAME);

create table ROLES (
ID integer primary key GENERATED ALWAYS as IDENTITY,
NAME varchar(20) not null unique
);

create table USERS_ROLES (
USER_ID integer not null,
ROLE_ID integer not null,
FOREIGN KEY (ROLE_ID) references ROLES(ID),
FOREIGN KEY (USER_ID) references USERS(ID)
);

CREATE TABLE AUTHORITIES (
ID integer primary key GENERATED ALWAYS as IDENTITY,
NAME varchar(20) not null,
DISPLAY_NAME varchar(20) not null
);

create table ROLES_AUTHORITIES (
ROLE_ID integer not null,
AUTHORITY_ID integer not null,
FOREIGN KEY (ROLE_ID) references ROLES(ID),
FOREIGN KEY (AUTHORITY_ID) references AUTHORITIES(ID)
);

CREATE TABLE RESOURCES (
ID integer primary key GENERATED ALWAYS as IDENTITY,
RESOURCE_TYPE varchar(20) not null,
VALUE varchar(255) not null,
ORDER_NUM float not null
);

create table RESOURCES_AUTHORITIES (
AUTHORITY_ID integer not null,
RESOURCE_ID integer not null,
FOREIGN KEY (AUTHORITY_ID) references AUTHORITIES(ID),
FOREIGN KEY (RESOURCE_ID) references RESOURCES(ID)
);