--用户表
create table t_user(
	id BIGINT PRIMARY KEY auto_increment COMMENT '用户编号',
	phone VARCHAR(11) COMMENT '用户联系方式',
	password varchar(18) COMMENT '用户登录密码',
	name varchar(20) COMMENT '用户昵称',
	realname varchar(10) comment '用户真实姓名',
	sex varchar(2) COMMENT '用户性别',
	age int COMMENT '用户年龄',
	qqopenid varchar(36) COMMENT 'QQopenid',
	wbopenid varchar(36) COMMENT '微博openid',
	wxopenid varchar(36) COMMENT '微信openid',
	isVip int COMMENT '是否是vip，0代表过客，1代表vip用户',
	money DOUBLE COMMENT '账户余额',
	status int COMMENT '是否启用，0代表启用，1代表禁用',
	create_time datetime COMMENT '创建时间'

);
--用户消费记录表
create table t_moneyItem(
	id BIGINT PRIMARY key auto_increment COMMENT '消费编号',
	user_id BIGINT COMMENT '用户编号',
	money DOUBLE COMMENT '消费金额',
	type int COMMENT '消费类型：0：充值，1：消费，2：赏金',
	issucc int COMMENT '消费状态，0：成功,1:失败',
	remark varchar(200) COMMENT '备注',
	create_time datetime COMMENT '消费时间'
);
--图书类型表
create table t_bookType(
	id BIGINT PRIMARY key auto_increment COMMENT '图书类型编号',
	name varchar(20) COMMENT '图书类型名称',
  introduction  varchar(100) COMMENT '图书类型简介',
	status int COMMENT '图书类型状态',
	create_time datetime COMMENT '图书类型创建时间'

);
--图书表
DROP TABLE IF EXISTS `t_books`;
create table t_books(
	id BIGINT PRIMARY key auto_increment COMMENT '图书编号',
	name varchar(50) COMMENT '图书名称',
	title varchar(50) COMMENT '图书标题',
	introduction  varchar(100) COMMENT '图书简介',
	book_type_id BIGINT COMMENT '图书类型编号',
	author varchar(20) COMMENT '图书作者',
	word_count BIGINT COMMENT '字数',
	section BIGINT COMMENT '章节数',
	update_time date COMMENT '更新时间',
	face_img VARCHAR(255) COMMENT '封面图片',
	collect_count BIGINT COMMENT '收藏人数',
	reward_count BIGINT COMMENT '打赏人数',
	discuss_count BIGINT COMMENT '评论人数',
	read_count BIGINT COMMENT '追读人数',
	publish_user_id BIGINT COMMENT '图书发布人编号',
	is_last int COMMENT '是否完本'
);
--用户图书收藏表
create table t_book_collect(
	id BIGINT PRIMARY key auto_increment COMMENT '图书收藏编号',
	user_id BIGINT COMMENT '用户编号',
	books_id BIGINT COMMENT '图书编号',
	create_time datetime COMMENT '收藏时间'
);
--图书章节表
DROP TABLE IF EXISTS `t_books_section`;
create table t_books_section(
	id BIGINT PRIMARY key auto_increment COMMENT '图书章节编号',
	books_id BIGINT COMMENT '图书编号',
	name varchar(30) COMMENT '图书章节名称',
	title varchar(100) COMMENT '图书章节标题',
	content text COMMENT '图书本章节内容',
	publish_time date COMMENT '发布时间',
	is_money int COMMENT '是否收费',
	publish_user_id BIGINT COMMENT '图书章节发布用户编号'
);
--图书评论表
create table t_books_discuss(
	id BIGINT PRIMARY key auto_increment COMMENT '评论编号',
	user_id BIGINT COMMENT '评论编号',
	books_id BIGINT COMMENT '图书编号',
	content varchar(500) COMMENT '评论内容',
	publish_time datetime COMMENT '评论时间'

);


