create database quiz;

use quiz;

create table questionbank(
Q_id int primary key,
Question varchar(250),
O_A varchar(250),
O_B VARCHAR(250),
O_C varchar(250),
O_D varchar(250),
C_Ans varchar(250)
);

insert into  questionbank(Q_id,Question,O_A,O_B,O_C,O_D,C_Ans)
values(1,'what is used to find and fix bugs in the Java programs?','JRE','JDK','GIT','JDB','JDB');

insert into  questionbank(Q_id,Question,O_A,O_B,O_C,O_D,C_Ans)
values(2,'An interface with no fields or methods is known as?','Runnable Interface','Marker Interface','Abstract Interface','CharSequence Interface','Marker Interface');

insert into  questionbank(Q_id,Question,O_A,O_B,O_C,O_D,C_Ans)
values(3,'In which memory a String is stored, when we create a string using new operator?','Stack','String memory','Heap memory','Random storage space','Heap memory');

insert into  questionbank(Q_id,Question,O_A,O_B,O_C,O_D,C_Ans)
values(4,'Which of the following is a reserved keyword in Java?','object','strictfp','main','system','strictfp');

insert into  questionbank(Q_id,Question,O_A,O_B,O_C,O_D,C_Ans)
values(5,'In java, jar stands for___?','Java Archive Runner','Java Application Resource','Java Application Runner','None of the above','None of the above');

insert into  questionbank(Q_id,Question,O_A,O_B,O_C,O_D,C_Ans)
values(6,'What is the initial quantity of the ArrayList list?','5','16','0','100','16');

insert into  questionbank(Q_id,Question,O_A,O_B,O_C,O_D,C_Ans)
values(7,'What is meant by the classes and objects that dependents on each other?','Tight Coupling','Cohesion','Loose Coupling','None of the above','Tight Coupling');

insert into  questionbank(Q_id,Question,O_A,O_B,O_C,O_D,C_Ans)
values(8,'how many primitive datatypes present in java?','10','11','15','8','8');

insert into  questionbank(Q_id,Question,O_A,O_B,O_C,O_D,C_Ans)
values(9,'If a thread goes to sleep?','releases all the locks it has','does not release any locks','releases half of its locks','releases all of its lock except one','It does not release any locks');

insert into  questionbank(Q_id,Question,O_A,O_B,O_C,O_D,C_Ans)
values(10,'Which keyword is used for accessing the features of a package?','package','import','extends','export','import');

select * from questionbank;