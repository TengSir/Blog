create table users
(
  userid   int auto_increment
    primary key,
  username varchar(20)                not null,
  password varchar(80)                not null,
  nickname varchar(20) default '隐姓埋名' null,
  sex      int                        null,
  age      int                        null,
  image    varchar(200)               null,
  level    int                        null,
  constraint users_username_uindex
  unique (username)
)
  comment '这里存储用户信息的表';

create table blogs
(
  blogid       int auto_increment
    primary key,
  title        varchar(200)    not null,
  content      text            null,
  publishtime  varchar(20)     not null,
  visitedcount int default '0' null,
  userid       int             null,
  constraint FK_userid_blog_users
  foreign key (userid) references users (userid)
    on update cascade
    on delete cascade
);

