-- we don't know how to generate schema blog (class Schema) :(
create table users
(
	userid int auto_increment
		primary key,
	username varchar(20) not null,
	password varchar(80) not null,
	nickname varchar(20) default '隐姓埋名' null,
	sex int null,
	age int null,
	image varchar(200) null,
	level int null,
	constraint users_username_uindex
		unique (username)
)
comment '这里存储用户信息的表'
;

create table blogs
(
	blogid int auto_increment
		primary key,
	title varchar(200) not null,
	content text null,
	publishtime varchar(20) not null,
	visitedcount int default '0' null,
	userid int null,
	constraint FK_userid_blog_users
		foreign key (userid) references users (userid)
			on update cascade on delete cascade
)
;


INSERT INTO blog.users (userid, username, password, nickname, sex, age, image, level) VALUES (1, 'tengsir', '123123', '老男孩', 1, 16, 'images/91.gif', 1);
INSERT INTO blog.users (userid, username, password, nickname, sex, age, image, level) VALUES (2, 'jackson', '444444', '杰克逊', 0, 6, 'images/92.gif', 0);
INSERT INTO blog.users (userid, username, password, nickname, sex, age, image, level) VALUES (3, 'tomcat', '888888', '汤姆猫', 1, 5, 'images/93.gif', 0);
INSERT INTO blog.users (userid, username, password, nickname, sex, age, image, level) VALUES (4, 'haohao', '666666', '任职好', 0, 8, 'images/100.gif', 0);
INSERT INTO blog.users (userid, username, password, nickname, sex, age, image, level) VALUES (5, '刘洋真帅', '1111', '刘洋帅', 0, 0, 'images/100.gif', 0);
INSERT INTO blog.users (userid, username, password, nickname, sex, age, image, level) VALUES (6, 'tomcatcat', '111111', '汤姆猫猫', 0, 1, 'images/100.gif', 0);
INSERT INTO blog.users (userid, username, password, nickname, sex, age, image, level) VALUES (7, '孙卫东帅必须承认', '1234567', '哈哈哈哈', 0, 0, 'images/100.gif', 0);
INSERT INTO blog.users (userid, username, password, nickname, sex, age, image, level) VALUES (8, 'jack', 'rose', '杰克', 0, 34, 'upload/e3166875-a96e-4920-9085-92e45f83adbb.jpeg', 0);
INSERT INTO blog.users (userid, username, password, nickname, sex, age, image, level) VALUES (9, '123123', 'gonzo', '1111', 0, 0, 'upload/7/3/8/4/8/2/b/5/-/2/d/2/c/-/4/9/a/8/-/9/0/b/d/-/5/1/8/3/b/0/4/9/7/8/1/0/738482b5-2d2c-49a8-90bd-5183b0497810.jpeg', 0);
INSERT INTO blog.users (userid, username, password, nickname, sex, age, image, level) VALUES (10, '韩国萨大V', '123456', 'sda', 1, 16, 'upload/b/c/d/d/3/b/6/4/-/6/c/a/0/-/4/5/6/a/-/a/2/5/e/-/5/2/2/6/c/d/a/e/4/2/2/4/bcdd3b64-6ca0-456a-a25e-5226cdae4224.jpeg', 0);
INSERT INTO blog.users (userid, username, password, nickname, sex, age, image, level) VALUES (11, 'gqr', '123456', '喷火龙', 0, 7, 'upload/8/3/6/7/9/4/b/1/-/b/3/1/6/-/4/e/0/b/-/b/b/f/b/-/c/5/6/d/d/5/e/2/5/b/0/5/836794b1-b316-4e0b-bbfb-c56dd5e25b05.jpeg', 0);
INSERT INTO blog.users (userid, username, password, nickname, sex, age, image, level) VALUES (12, 'ke''ai''ke''ai', '123', 'keaikeai', 1, 20, 'upload/4/b/6/2/c/3/4/3/-/7/d/b/1/-/4/0/e/4/-/a/8/2/6/-/c/c/f/b/6/7/d/a/5/0/d/d/4b62c343-7db1-40e4-a826-ccfb67da50dd.jpeg', 0);
INSERT INTO blog.users (userid, username, password, nickname, sex, age, image, level) VALUES (13, 'fdsfdsf', '3213123', 'ewsfd', 0, 0, 'upload/f/7/1/2/7/4/6/0/-/8/5/3/6/-/4/3/8/2/-/a/b/e/d/-/4/d/3/5/7/4/0/0/d/3/4/6/f7127460-8536-4382-abed-4d357400d346.jpeg', 0);
INSERT INTO blog.users (userid, username, password, nickname, sex, age, image, level) VALUES (14, '137641', '123456', '孙卫东最帅', 0, 0, 'upload/7/7/7/a/b/2/f/7/-/c/e/f/6/-/4/5/e/8/-/8/e/1/3/-/8/7/5/9/c/5/b/a/1/3/1/0/777ab2f7-cef6-45e8-8e13-8759c5ba1310.jpeg', 0);
INSERT INTO blog.users (userid, username, password, nickname, sex, age, image, level) VALUES (15, 'hhhh', '111', 'hhhhhh', 1, 3, 'upload/4/b/0/5/6/6/1/c/-/2/d/f/4/-/4/9/2/2/-/9/7/8/2/-/7/1/f/b/9/f/8/2/9/f/c/b/4b05661c-2df4-4922-9782-71fb9f829fcb.jpeg', 0);
INSERT INTO blog.users (userid, username, password, nickname, sex, age, image, level) VALUES (16, 'zml', '123', 'Ambation', 1, 0, 'upload/c/7/a/c/b/b/c/c/-/f/e/c/d/-/4/d/7/2/-/9/e/2/9/-/b/8/7/2/a/6/9/f/0/c/1/c/c7acbbcc-fecd-4d72-9e29-b872a69f0c1c.jpeg', 0);
INSERT INTO blog.users (userid, username, password, nickname, sex, age, image, level) VALUES (17, 'sword', 'sword', 'sword', 0, 0, 'upload/f/8/3/1/5/4/a/d/-/6/7/2/1/-/4/4/0/9/-/a/1/9/a/-/b/a/d/6/a/e/e/5/e/4/d/d/f83154ad-6721-4409-a19a-bad6aee5e4dd.jpeg', 0);
INSERT INTO blog.users (userid, username, password, nickname, sex, age, image, level) VALUES (18, '1212', '1212', '1212', 0, 16, 'upload/a/e/2/5/6/0/4/5/-/1/7/4/e/-/4/f/4/6/-/9/6/f/4/-/b/c/b/a/b/b/2/b/6/a/2/1/ae256045-174e-4f46-96f4-bcbabb2b6a21.jpeg', 0);
INSERT INTO blog.users (userid, username, password, nickname, sex, age, image, level) VALUES (19, '周艳红', '123456', '周艳红', 1, 17, 'upload/9/d/d/3/f/9/3/7/-/b/1/8/f/-/4/e/9/a/-/a/f/3/b/-/b/2/f/6/2/4/a/c/9/0/f/f/9dd3f937-b18f-4e9a-af3b-b2f624ac90ff.jpeg', 0);
INSERT INTO blog.users (userid, username, password, nickname, sex, age, image, level) VALUES (20, 'alloces', '123456', 'alloces', 0, 0, 'upload/c/4/c/7/f/4/8/c/-/2/c/b/5/-/4/e/8/6/-/9/a/b/3/-/c/4/1/2/5/b/b/6/1/b/6/9/c4c7f48c-2cb5-4e86-9ab3-c4125bb61b69.jpeg', 0);
INSERT INTO blog.users (userid, username, password, nickname, sex, age, image, level) VALUES (21, '古拉啦', '123456', '乌拉拉少女', 1, 18, 'upload/9/0/6/d/7/0/f/5/-/b/8/5/9/-/4/7/4/e/-/b/7/5/c/-/1/b/3/6/9/0/5/0/4/2/2/4/906d70f5-b859-474e-b75c-1b3690504224.jpeg', 0);
INSERT INTO blog.users (userid, username, password, nickname, sex, age, image, level) VALUES (22, '6465984', '123456', '123456', 0, 18, 'upload/6/6/6/b/6/6/f/4/-/3/2/2/d/-/4/1/b/a/-/9/e/6/7/-/0/1/6/f/2/4/0/7/b/f/b/8/666b66f4-322d-41ba-9e67-016f2407bfb8.png', 0);
INSERT INTO blog.users (userid, username, password, nickname, sex, age, image, level) VALUES (23, '刘洋你咋这么帅', '123', '刘洋你咋这么帅', 0, 14, 'upload/d/a/9/8/9/6/7/2/-/5/8/3/7/-/4/c/5/c/-/9/4/7/1/-/e/3/9/5/7/d/6/e/a/1/0/3/da989672-5837-4c5c-9471-e3957d6ea103.jpeg', 0);
INSERT INTO blog.users (userid, username, password, nickname, sex, age, image, level) VALUES (24, 'wdas', 'sdas', 'sadfaf', 0, 0, 'upload/7/9/d/a/6/e/4/2/-/a/6/9/5/-/4/2/e/b/-/8/a/4/b/-/7/d/7/3/3/0/8/f/5/1/5/9/79da6e42-a695-42eb-8a4b-7d73308f5159.jpeg', 0);
INSERT INTO blog.users (userid, username, password, nickname, sex, age, image, level) VALUES (25, 'haha', '1111111', '1111', 0, 15, 'upload/a/1/c/4/0/8/f/7/-/6/6/1/4/-/4/6/a/0/-/a/3/3/8/-/8/d/2/1/1/4/7/4/1/4/7/1/a1c408f7-6614-46a0-a338-8d2114741471.jpeg', 0);
INSERT INTO blog.users (userid, username, password, nickname, sex, age, image, level) VALUES (26, 'jamesli', '', 'nana', 0, 1, 'upload/3/b/4/b/a/7/f/7/-/5/4/6/3/-/4/8/3/5/-/8/9/4/0/-/1/c/0/f/a/d/7/b/d/d/5/2/3b4ba7f7-5463-4835-8940-1c0fad7bdd52.octet-stream', 0);
INSERT INTO blog.users (userid, username, password, nickname, sex, age, image, level) VALUES (27, 'admin', 'admin', '守护全世界最好的孙卫东', 0, 11, 'upload/0/3/3/8/e/e/7/b/-/3/d/b/3/-/4/0/9/8/-/b/7/3/5/-/f/a/8/b/5/1/5/7/6/2/1/0/0338ee7b-3db3-4098-b735-fa8b51576210.jpeg', 0);
INSERT INTO blog.users (userid, username, password, nickname, sex, age, image, level) VALUES (28, '123', '123', '123', 0, 0, 'upload/e/8/4/6/e/e/4/3/-/d/b/5/1/-/4/3/4/8/-/8/d/d/7/-/d/c/3/a/9/0/7/d/5/c/9/1/e846ee43-db51-4348-8dd7-dc3a907d5c91.jpeg', 0);
INSERT INTO blog.users (userid, username, password, nickname, sex, age, image, level) VALUES (29, 'qqq123', '123456', 'hell0', 0, 0, 'upload/7/1/0/3/f/a/d/2/-/5/b/8/4/-/4/2/5/c/-/9/d/3/5/-/4/7/a/a/f/1/7/d/1/d/3/e/7103fad2-5b84-425c-9d35-47aaf17d1d3e.octet-stream', 0);
INSERT INTO blog.users (userid, username, password, nickname, sex, age, image, level) VALUES (30, '2016117', '123456', '123456', 0, 12, 'upload/1/d/3/c/7/0/f/f/-/c/d/2/2/-/4/7/8/9/-/9/7/1/3/-/2/8/4/1/1/4/0/3/7/1/0/0/1d3c70ff-cd22-4789-9713-284114037100.octet-stream', 0);
INSERT INTO blog.users (userid, username, password, nickname, sex, age, image, level) VALUES (31, 'ZRX', '123456', '小强', 0, 0, 'upload/f/3/a/e/5/e/7/a/-/f/b/3/4/-/4/4/b/d/-/b/5/8/5/-/1/8/b/3/a/f/b/a/d/2/6/0/f3ae5e7a-fb34-44bd-b585-18b3afbad260.jpeg', 0);
INSERT INTO blog.users (userid, username, password, nickname, sex, age, image, level) VALUES (32, '刘洋征婚官方', '123456', '123456', 0, 21, 'upload/6/4/6/c/c/f/6/4/-/b/c/0/f/-/4/3/f/8/-/9/6/a/2/-/1/3/6/b/4/7/a/8/5/f/e/d/646ccf64-bc0f-43f8-96a2-136b47a85fed.jpeg', 0);
INSERT INTO blog.users (userid, username, password, nickname, sex, age, image, level) VALUES (33, 'stone', '123456', '哈哈哈', 0, 0, 'upload/7/f/4/e/1/8/7/c/-/5/9/5/6/-/4/2/b/9/-/b/e/a/c/-/5/4/a/a/0/b/2/c/5/7/c/2/7f4e187c-5956-42b9-beac-54aa0b2c57c2.png', 0);
INSERT INTO blog.users (userid, username, password, nickname, sex, age, image, level) VALUES (35, '', '', '', 0, 0, 'upload/c/e/8/5/0/2/a/3/-/3/7/1/5/-/4/e/7/e/-/8/0/b/4/-/b/5/4/9/a/e/c/8/b/8/6/d/ce8502a3-3715-4e7e-80b4-b549aec8b86d.octet-stream', 0);
INSERT INTO blog.users (userid, username, password, nickname, sex, age, image, level) VALUES (36, '校草孙卫东', '111111', '1', 0, 0, 'upload/7/b/7/9/1/a/4/d/-/a/b/9/9/-/4/5/4/5/-/a/9/d/3/-/f/b/8/4/7/a/8/3/2/3/8/4/7b791a4d-ab99-4545-a9d3-fb847a832384.octet-stream', 0);


INSERT INTO blog.blogs (blogid, title, content, publishtime, visitedcount, userid) VALUES (1, 'java中空指针的解决颁发', '空指针问题如何解决，今天听小心心', '2019-01-01 12:12:12', 0, null);
INSERT INTO blog.blogs (blogid, title, content, publishtime, visitedcount, userid) VALUES (2, 'C#语言中的问题', '经常遇到的问题啊', '2019-03-05 01:23:34', 0, null);
INSERT INTO blog.blogs (blogid, title, content, publishtime, visitedcount, userid) VALUES (3, '那些年遇到的bug', '当地时间晚6时30分许，专机抵达罗马菲乌米奇诺机场。习近平和夫人彭丽媛步出舱门，礼兵敬礼致意，意大利农业旅游部部长等高级官员在舷梯旁热情迎接。习近平和彭丽媛沿红地毯前行。礼兵肃立在红地毯两侧，行注目礼。

　　习近平代表中国政府和中国人民，向意大利政府和人民致以诚挚问候和良好祝愿。习近平指出，中意建交49年来，两国关系经受住时间和国际风云变幻的考验，双方秉承互尊互信、互利共赢原则，不断推进中意友好和合作，成为不同社会制度、文化背景、发展阶段国家发展双边关系的典范。中意务实合作硕果累累，为两国人民带来了实实在在的利益；人文交流丰富多彩，增进了彼此了解和友谊。

　　习近平指出，我期待着同马塔雷拉总统、孔特总理等意大利领导人会谈会见，共同描绘中意关系未来发展蓝图。相信在双方共同努力下，中意全面战略伙伴关系必将拥有更加美好的明天。

　　丁薛祥、杨洁篪、王毅、何立峰等陪同人员同机抵达。

　　中国驻意大利大使李瑞宇也到机场迎接。

　　在结束对意大利的国事访问后，习近平还将对摩纳哥、法国进行国事访问。', '2019-03-05 01:23:55', 123, null);