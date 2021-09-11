create table t_rds_user (
id bigint auto_increment primary key comment 'id',
name varchar(32) not null default '' comment 'user name',
account varchar(32) not null default '',
password varchar(128) not null default '',
valid int(1) not null default 0,

ctime bigint not null default 0,
utime bigint not null default 0
)

create table t_rds_database_info (
id bigint auto_increment primary key comment 'id',
host varchar(128) not null default '' comment 'db host',
port int(11) not null default 0,
default_db varchar(128) not null default '',
password varchar(128) not null default '',
valid int(1) not null default 0,

ctime bigint not null default 0,
utime bigint not null default 0
)

