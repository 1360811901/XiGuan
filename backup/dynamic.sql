create table user_dynamics(
id int  primary key auto_increment,
dnid varchar(320),
username varchar(320),
content text ,
utime varchar(60) default '',
longitude varchar(15) default '121.456581',
latitude varchar(15) default '37.494037',
province varchar(30) default '山东',
city varchar(30) default '烟台',
clickonlike varchar(9) default '0',
commentnumber varchar(9) default '0',
utype varchar(25) default 'personal',
destination varchar(320) default '烟台',
begintime varchar(26) default '201607201420',
overtime varchar(26) default '201607201820'
);
create table dynamic_photo(
id int primary key auto_increment,
url varchar(320) default '',
dynamicid varchar(320) default '1',
photetype varchar(30) default 'image/jpeg',
filename varchar(350) default 'jin.jpg',
size varchar(6) default '0'
);
create table comment(
id int primary key auto_increment,
dynamicid varchar(320),
username varchar(320),
ctime varchar(60) default '',
content text 
);
create table focuson(
id int primary key auto_increment,
username varchar(320),
focuson_username varchar(320),
ftime varchar(60) default '',
focusonnumber varchar(9) default '0',
fansnumber varchar(9) default '0'
);