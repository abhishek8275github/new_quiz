use quiz;

create table students(
 id int  auto_increment primary key,
 firstname varchar(250),
 lastname varchar(250),
 score int,
 grade varchar(50)
 );

select * from students;