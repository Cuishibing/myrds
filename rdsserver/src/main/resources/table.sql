create table t_rds_user (
id bigint auto_increment primary key,
name varchar(32) not null default '',
account varchar(32) not null default '',
password varchar(128) not null default '',
valid int(1) not null default 0,

ctime bigint not null default 0,
utime bigint not null default 0
)