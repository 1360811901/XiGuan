create table user_baseinformation(
id int primary key auto_increment,
username varchar(320),
password varchar(9),
nickname varchar(72),
sex varchar(8) default 'girl',
age varchar(3) default 18,
career varchar(64) default '',
email varchar(320) default '',
headportraiturl varchar(320) default '',
longitude varchar(15) default '121.456581',
latitude varchar(15) default '37.494037',
province varchar(30) default '山东',
city varchar(30) default '烟台',
rongtoken varchar(90) default '',
vip varchar(3) default 0,
isweixin varchar(4) default 'no',
issina varchar(4) default 'no'
);
insert into user_baseinformation (username,password,nickname) values ('1111','test','1111');
insert into user_baseinformation (username,password,nickname) values ('2222','test','2222');
insert into user_baseinformation (username,password,nickname) values ('3333','test','3333');
insert into user_baseinformation (username,password,nickname) values ('4444','test','4444');
insert into user_baseinformation (username,password,nickname) values ('5555','test','5555');
insert into user_baseinformation (username,password,nickname) values ('6666','test','6666');
insert into user_baseinformation (username,password,nickname) values ('7777','test','7777');
insert into user_baseinformation (username,password,nickname) values ('8888','test','8888');
insert into user_baseinformation (username,password,nickname) values ('9999','test','9999');
insert into user_baseinformation (username,password,nickname) values ('0000','test','0000');
insert into user_baseinformation (username,password,nickname) values ('1234','test','1234');
insert into user_baseinformation (username,password,nickname) values ('4567','test','4567');
insert into user_baseinformation (username,password,nickname) values ('7890','test','7890');
insert into user_baseinformation (username,password,nickname) values ('1100','test','1100');

create table contactslist(
id int primary key auto_increment,
username varchar(320),
contact varchar(320),
classify varchar(36) default '我的好友'
);
insert into contactslist (username,contact) values ('1111','2222');
insert into contactslist (username,contact) values ('1111','3333');
insert into contactslist (username,contact) values ('1111','4444');
insert into contactslist (username,contact) values ('1111','6666');
insert into contactslist (username,contact) values ('1111','5555');
insert into contactslist (username,contact) values ('1111','7777');
insert into contactslist (username,contact) values ('2222','6666');
insert into contactslist (username,contact) values ('2222','8888');
insert into contactslist (username,contact) values ('2222','1111');
insert into contactslist (username,contact) values ('2222','3333');
insert into contactslist (username,contact) values ('1111','9999');

select username,nickname from user_baseinformation where username in (select contact from contactslist where username = '1111');