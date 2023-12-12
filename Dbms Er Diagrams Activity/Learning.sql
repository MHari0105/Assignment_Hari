create database Learning;
use Learning;

create table employee(
	empId int primary key,
    eName varchar(30),
    jobDesc varchar(20),
    salary int
);

-- add constraints in ename
alter table employee
modify ename varchar(30) not null;

-- to drop constaint 
alter table employee
modify ename varchar(30);

-- add default constraint
alter table employee 
alter jobDesc set default 'unassigned';

-- drop default constraint
alter table employee
alter jobDesc drop default;

-- add cehck constraint
alter table employee
add constraint check_salary check(salary > 100000);

-- drop check constraint
alter table employee
drop check check_salary;


create table branch(
	brId int primary key auto_increment,
    brName varchar(30) not null,
    address varchar(50)
);

-- add new column in a existing table
alter table employee
add brId int;

-- set a column as foregin key
/* on delete can have two values 1.cascaed and 2.set null
	set null - the foriegn key rwo removed from the inheritated table and every values are set null on that particular row
    cascade - deletes the entire row while droping foreign key 
*/
alter table employee
add constraint fk_brId foreign key(brId) references branch(brId) on delete cascade;

-- remove constraint
alter table employee
drop foreign key fk_brId;

-- Indexes
create index name_index on employee(eName);

-- Drop Index
alter table employee
drop index name_index;

-- 	joins - Used to join and display 2 tables, using forigen key
select employee.empId, employee.eName 
from employee join branch
on employee.fk_brId = branch.brId;

-- inner join : show only the perfect matches of the table
-- left join : first shows all the perfect matches and also shows the remaining columns of the left table
-- right join : shows the columns of the right table and shows all the perfect matches

-- while seeing in venn diagram take two circles employee and branch
-- join / inner join shows the intersected columns
-- left join shows the whole left circle i.e. employee circle
-- right join shows the whole right circle i.e. branch circle
-- full join shows the union but not yet applicable in mysql
-- cross join : one to all other of each table

select b.brId, count(e.empId) No_of_employees
from branch as b
join employee as e
on b.brId = e.fk_brId
group by e.empId;


-- subqueries : query inside another query
-- 1. find the branc id of a city using employee table
select * from employee
where brId = (select brId from branch where brName = "Chennai");

-- 2. find employee with minimum salary
select * from employee 
where salary = (select min(salary) from employee);



