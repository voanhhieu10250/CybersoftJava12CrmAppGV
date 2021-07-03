CREATE DATABASE IF NOT EXISTS CRMdb;

USE CRMdb;

CREATE TABLE IF NOT EXISTS role(
	id 				int auto_increment,
    name 			nvarchar(100) not null,
    description 	nvarchar(255),
    primary key (id)
);

CREATE TABLE IF NOT EXISTS user(
	id 				int auto_increment,
    email			varchar(100) not null unique,
    password		varchar(255) not null,
    name 			nvarchar(100) not null,
    address		 	nvarchar(255),
    phone			varchar(50),
    primary key (id)
);

CREATE TABLE IF NOT EXISTS project(
	id 				int auto_increment,
    name 			nvarchar(100) not null,
    description		varchar(255),
    start_date		date,
    end_date		date,
    owner			int,
    primary key (id)
);

CREATE TABLE IF NOT EXISTS project_user(
	project_id			int,
    user_id				int,
    join_date			date,
    role_description	varchar(255),
    primary key (project_id,user_id)
);

CREATE TABLE IF NOT EXISTS task(
	id 				int auto_increment,
    name 			nvarchar(100) not null,
    description 	nvarchar(255),
    start_date		date,
    end_date		date,
    project_id		int,
    user_id			int,
    status_id		int,
    primary key (id)
);