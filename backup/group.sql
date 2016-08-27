create table group_baseinformation(
id int primary key auto_increment,
groupid varchar(320),
groupcount varchar(3) default '0',
groupown varchar(320),
groupsummary varchar(320) default '小伙伴们，快来加群啊',
groupheadportraiturl varchar(320) default '',
groupname varchar(32) default '好人群'
);
create table group_memberlist(
id int primary key auto_increment,
username varchar(320),
groupid varchar(320)
);