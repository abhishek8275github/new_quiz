use quiz;

create table questionbanks(
qno int primary key,
question varchar(250),
option_1 varchar(250),
option_2 varchar(250),
option_3 varchar(250),
option_4 varchar(250),
answer varchar(250)
);

insert into questionbanks(qno,question,option_1,option_2,option_3,option_4,answer)
values(1,'what is used to find and fix bugs in the Java programs?','JRE','JDK','GIT','JDB','JDB');

insert into questionbanks(qno,question,option_1,option_2,option_3,option_4,answer)
values(2,'An interface with no fields or methods is known as?','Runnable Interface','Marker Interface','Abstract Interface','CharSequence Interface','Marker Interface');

insert into  questionbanks(qno,question,option_1,option_2,option_3,option_4,answer)
values(3,'In which memory a String is stored, when we create a string using new operator?','Stack','String memory','Heap memory','Random storage space','Heap memory');

insert into  questionbanks(qno,question,option_1,option_2,option_3,option_4,answer)
values(4,'Which of the following is a reserved keyword in Java?','object','strictfp','main','system','strictfp');

insert into  questionbanks(qno,question,option_1,option_2,option_3,option_4,answer)
values(5,'In java, jar stands for___?','Java Archive Runner','Java Application Resource','Java Application Runner','None of the above','Java Application Resource');

insert into  questionbanks(qno,question,option_1,option_2,option_3,option_4,answer)
values(6,'What is the initial quantity of the ArrayList list?','5','16','0','100','16');

insert into  questionbanks(qno,question,option_1,option_2,option_3,option_4,answer)
values(7,'What is meant by the classes and objects that dependents on each other?','Tight Coupling','Cohesion','Loose Coupling','None of the above','Tight Coupling');

insert into  questionbanks(qno,question,option_1,option_2,option_3,option_4,answer)
values(8,'how many primitive datatypes present in java?','10','11','15','8','8');

insert into  questionbanks(qno,question,option_1,option_2,option_3,option_4,answer)
values(9,'If a thread goes to sleep?','releases all the locks it has','does not release any locks','releases half of its locks','releases all of its lock except one','does not release any locks');

insert into  questionbanks(qno,question,option_1,option_2,option_3,option_4,answer)
values(10,'Which keyword is used for accessing the features of a package?','package','import','extends','export','import');
 
select * from questionbanks;