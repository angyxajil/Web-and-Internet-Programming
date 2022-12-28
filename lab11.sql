-- 1. Find the names of the students who are not in any group.
select name 
from students
where group_id is null

-- 2. Find the names of the students who are in the group Minnows.
select name
from students
where group_id = (select students.id
from student_groups
where name = "Minnows")

-- 3. List the name, age, parent name, and parent email of the students. The column names of the results should be Name, Age, Parent, and Email. Note that age is calculated as (current year - birth year
select name as "Name", (2022 - birth_year) as "Age",
parent_name as "Parent Name", parent_email as "Parent Email"
from students

-- 4. List the names of the students and the name of the group each student is in. The column names of the results should be Student Name and Group Name. If a student is not in a group, the group name column should show NULL.
select students.name as "Student Name", student_groups.name as "Group Name"
from students
left join student_groups
on students.group_id=student_groups.id
order by students.name;

-- 5.List the names of the groups and the number of students in each group. The result should show 0 for groups that do not have any students
select student_groups.name, count(students.group_id) 
from students inner join N student_groups 
on students.group_id = student_groups.id 
or students.group_id is null
group by student_groups.id