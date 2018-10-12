/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/9/15 17:28:53                           */
/*==============================================================*/


drop table if exists my_topics;

drop table if exists news_feed;

drop table if exists topics;

drop table if exists user_info;

DROP TABLE IF EXISTS author;

/*==============================================================*/
/* Table: my_topics                                             */
/*==============================================================*/
create table my_topics
(
   my_topic_id          int not null,
   my_topic_name        varchar(50) not null,
   my_topic_type        smallint not null,
   primary key (my_topic_id)
);

alter table my_topics comment '订阅主题';

/*==============================================================*/
/* Table: news_feed                                             */
/*==============================================================*/
create table news_feed
(
   feedId               int not null auto_increment,
   feed_title            varchar(50) not null,
   feed_url              varchar(50) not null,
   feed_img              varchar(50) not null,
   update_time           timestamp not null,
   feed_topic            varchar(50) not null,
   feed_type             numeric(10,0) not null,
	 feed_thumbnail				 VARCHAR(50) not null,
   primary key (feed_id)
);


INSERT INTO news_feed VALUES(null,"家长开跑车接送孩子","www.baidu.com","www.baidu.com",null,"0",1,"www.baidu.com");
SELECT * FROM news_feed;

alter TABLE news_feed ADD feed_thumbnail VARCHAR(50) AFTER feed_type;

alter table news_feed comment '新闻列表';

/*==============================================================*/
/* Table: topics                                                */
/*==============================================================*/
create table topics
(
   topic_id             int not null auto_increment,
   topic_name           varchar(50) not null,
   topic_type           smallint not null,
   primary key (topic_id)
);

alter table topics comment '主题：展示不同地区或者';

/*==============================================================*/
/* Table: users                                                  */
/*==============================================================*/
create table user_info
(
   user_id              int not null auto_increment,
   user_name            char(16),
   sex                  char(4),
	 uuid									VARCHAR(50),
   user_pwd             varchar(50),
   mobile               char(11),
   user_email           varchar(50),
   gen_time             timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
   login_time           timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
   last_login_time      timestamp DEFAULT CURRENT_TIMESTAMP,
   token                varchar(50),
 
   primary key (user_id)
);

INSERT INTO user_info (user_id,mobile,user_pwd,uuid,token,gen_time) VALUES(null,"15201329688","afddfdafddaf","ewqrwrqeeeq","qrreqrqeqrwrewq",null);
SELECT * FROM user_info;
alter TABLE user_info ADD uuid VARCHAR(40) AFTER user_name;

/*==============================================================*/
/* Table: author                                           */
/*==============================================================*/
CREATE TABLE author
(
		user_id							 	int NOT NULL,
		author_img						VARCHAR(50),
		author_url						VARCHAR(50),
		author_user_name			VARCHAR(50),
		primary key (user_id)
);

SELECT * FROM news_feed ORDER BY update_time DESC LIMIT 10;



















