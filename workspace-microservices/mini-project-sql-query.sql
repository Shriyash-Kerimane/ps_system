
create table USERS (
USERID integer not null,
USERNAME varchar(15),
primary key (USERID)
);

create table CONTACTS (
CONTACTID integer not null, 
CONTACTTAG varchar(15),
CITY varchar(15),
PINCODE varchar(15),
EMAIL varchar(30),
USERID integer,
primary key (CONTACTID)
);

insert into USERS (USERID,USERNAME) values (111,'Shriyash');
insert into USERS (USERID,USERNAME) values (222,'Pratamesh');
insert into USERS (USERID,USERNAME) values (333,'Nagabhushan');

alter table CONTACTS change EMAIL EMAIL longtext;

insert into CONTACTS (CONTACTID,CONTACTTAG,CITY,PINCODE,EMAIL,USERID) values (100,'home','Sirsi','581402','shriyashkerimane@everywhere.com',111);
insert into CONTACTS (CONTACTID,CONTACTTAG,CITY,PINCODE,EMAIL,USERID) values (101,'office','Bangalore','560037','shriyashkerimane@everywhere.com',111);
insert into CONTACTS (CONTACTID,CONTACTTAG,CITY,PINCODE,EMAIL,USERID) values (102,'school','Sirsi','581401','shriyashkerimane@everywhere.com',111);
insert into CONTACTS (CONTACTID,CONTACTTAG,CITY,PINCODE,EMAIL,USERID) values (103,'home','Mumbai','400078','pratameshkerimane@everywhere.com',222);
insert into CONTACTS (CONTACTID,CONTACTTAG,CITY,PINCODE,EMAIL,USERID) values (104,'office','Mumbai','400012','pratameshkerimane@everywhere.com',222);
insert into CONTACTS (CONTACTID,CONTACTTAG,CITY,PINCODE,EMAIL,USERID) values (105,'school','Sirsi','581401','pratameshkerimane@everywhere.com',222);
insert into CONTACTS (CONTACTID,CONTACTTAG,CITY,PINCODE,EMAIL,USERID) values (106,'home','Sirsi','581402','nagabhushankerimane@everywhere.com',333);
insert into CONTACTS (CONTACTID,CONTACTTAG,CITY,PINCODE,EMAIL,USERID) values (107,'school','Sirsi','581401','nagabhushankerimane@everywhere.com',333);
insert into CONTACTS (CONTACTID,CONTACTTAG,CITY,PINCODE,EMAIL,USERID) values (108,'office','Gurgaon','122016','nagabhushankerimane@everywhere.com',333);
commit;