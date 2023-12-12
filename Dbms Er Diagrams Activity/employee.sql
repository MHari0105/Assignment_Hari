create database employee_details;
use employee_details;

create table employee(
	emp_id int primary key auto_increment,
    ename varchar(30) not null,
    job_desc varchar(20),
    salary int, 
    branch_id int,
    constraint fk_branch_id foreign key(branch_id) references branch(branch_id)
);

create table branch(
	branch_id int primary key auto_increment,
    location varchar(20),
    address varchar(20)
);

alter table branch modify location varchar(20) not null;

insert into branch(location, address) values ("chennai", "ambathur");
insert into branch(location, address) values ("coimbatore", "sitra");
insert into branch(location, address) values ("hyderabad", "romoji");

select * from branch;employeeemp_id

insert into employee(ename, job_desc, salary, branch_id) values ("ram", "admin", 100000, 2);
insert into employee(ename, job_desc, salary, branch_id) values ("harini", "manager", 250000, 2);
insert into employee(ename, job_desc, salary, branch_id) values ("george", "sales", 200000, 1);
insert into employee(ename, job_desc, salary, branch_id) values ("ramya", "sales", 130000, 2);
insert into employee(ename, job_desc, salary, branch_id) values ("meena", "hr", 200000, 3);
insert into employee(ename, job_desc, salary, branch_id) values ("ashok", "manager", 300000, 1);
insert into employee(ename, job_desc, salary, branch_id) values ("abdul", "hr", 200000, 1);
insert into employee(ename, job_desc, salary, branch_id) values ("ramya", "engineer", 100000, 2);
insert into employee(ename, job_desc, salary, branch_id) values ("raghu", "ceo", 800000, 3);
insert into employee(ename, job_desc, salary, branch_id) values ("aravind", "manager", 280000, 3);

select * from employee;