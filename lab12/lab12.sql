drop table if exists faculty;
drop table if exists department;

create table faculty (
    id          		integer auto_increment primary key,
    name        		varchar(255),
    is_chair    		boolean, 
    department_name   	varchar(255) 
);

create table department(
	id 			integer auto_increment primary key,
    name 		varchar(255) unique 
);

insert into department (name) values ('Computer Science');
insert into department (name) values ('Electrical and Computer Engineering');

SELECT * FROM department;