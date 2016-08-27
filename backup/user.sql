
create table user_baseinformation(
id int primary key auto_increment,
username varchar(320),
password varchar(9),
nickname varchar(72),
sex varchar(8) default 'girl',
age varchar(3) default '18',
career varchar(64) default '',
email varchar(320) default '',
headportraiturl varchar(320) default '',
longitude varchar(15) default '121.456581',
latitude varchar(15) default '37.494037',
province varchar(30) default '山东省',
city varchar(30) default '烟台市',
rongtoken varchar(220) default '',
vip varchar(3) default '0',
isweixin varchar(4) default 'no',
issina varchar(4) default 'no',
signature varchar(360) default '好好学习，报效祖国',
backphotourl varchar(320) default '/default/img/back.jpg',
education varchar(90) default '本科',
hometown varchar(90) default '山东烟台',
constellation varchar(36) default '兔子',
label varchar(360) default '闲的'
);
create table contactslist(
id int primary key auto_increment,
username varchar(320),
contact varchar(320),
classify varchar(36) default '我的好友'
);
create table useralbum(
id int primary key auto_increment,
url varchar(320) default '',
userinfoid varchar(320) default '1',
photetype varchar(30) default 'image/jpeg',
filename varchar(350) default 'jin.jpg',
size varchar(6) default '0',
sort varchar(3) default '1',
isdel varchar(3) default 'NO'
);
-- 子查询 --
select username,nickname from user_baseinformation where username in (select contact from contactslist where username = '1111');
