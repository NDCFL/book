/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : book

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-03-02 18:15:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_books
-- ----------------------------
DROP TABLE IF EXISTS `t_books`;
CREATE TABLE `t_books` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '图书编号',
  `name` varchar(50) DEFAULT NULL COMMENT '图书名称',
  `title` varchar(50) DEFAULT NULL COMMENT '图书标题',
  `introduction` text COMMENT '图书简介',
  `book_type_id` bigint(20) DEFAULT NULL COMMENT '图书类型编号',
  `author` varchar(20) DEFAULT NULL COMMENT '图书作者',
  `word_count` bigint(20) DEFAULT NULL COMMENT '字数',
  `section` bigint(20) DEFAULT NULL COMMENT '章节数',
  `update_time` date DEFAULT NULL COMMENT '更新时间',
  `face_img` varchar(255) DEFAULT NULL COMMENT '封面图片',
  `collect_count` bigint(20) DEFAULT NULL COMMENT '收藏人数',
  `reward_count` bigint(20) DEFAULT NULL COMMENT '打赏人数',
  `discuss_count` bigint(20) DEFAULT NULL COMMENT '评论人数',
  `read_count` bigint(20) DEFAULT NULL COMMENT '追读人数',
  `publish_user_id` bigint(20) DEFAULT NULL COMMENT '图书发布人编号',
  `is_last` int(11) DEFAULT NULL COMMENT '是否完本',
  `status` int(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `book_module` bigint(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_books
-- ----------------------------
INSERT INTO `t_books` VALUES ('1', '西游记', '私四个人取经的故事', '<p>四个人取经的故事</p>', '3', '罗贯中', '400000', '1000', '2018-03-01', '/upload/p_big1.jpg', '10000', '10000', '10000', '10000', '1', '0', '0', '2018-03-02 09:54:21', '1');
INSERT INTO `t_books` VALUES ('2', '水浒传', null, '<p>108位梁山好汉</p>', '3', '施耐庵', '100000', '1000', '2018-03-02', '/upload/face.gif', '0', '0', '0', '0', '1', '0', '0', '2018-03-01 10:03:10', '2');
INSERT INTO `t_books` VALUES ('4', '都市丽人', null, '<p>都市丽人都市丽人都市丽人都市丽人都市丽人都市丽人都市丽人都市丽人都市丽人都市丽人都市丽人都市丽人都市丽人</p>', '1', '都市小子', '10000', '800', '2018-03-02', '/upload/a3.jpg', '0', '0', '0', '0', '1', '0', '0', '2018-03-02 10:38:02', '1');

-- ----------------------------
-- Table structure for t_books_discuss
-- ----------------------------
DROP TABLE IF EXISTS `t_books_discuss`;
CREATE TABLE `t_books_discuss` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '评论编号',
  `user_id` bigint(20) DEFAULT NULL COMMENT '评论编号',
  `books_id` bigint(20) DEFAULT NULL COMMENT '图书编号',
  `content` varchar(500) DEFAULT NULL COMMENT '评论内容',
  `publish_time` datetime DEFAULT NULL COMMENT '评论时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_books_discuss
-- ----------------------------
INSERT INTO `t_books_discuss` VALUES ('1', '1', '1', '很好', '2018-03-01 17:36:17');

-- ----------------------------
-- Table structure for t_books_section
-- ----------------------------
DROP TABLE IF EXISTS `t_books_section`;
CREATE TABLE `t_books_section` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '图书章节编号',
  `books_id` bigint(20) DEFAULT NULL COMMENT '图书编号',
  `name` varchar(30) DEFAULT NULL COMMENT '图书章节名称',
  `title` varchar(100) DEFAULT NULL COMMENT '图书章节标题',
  `content` text COMMENT '图书本章节内容',
  `publish_time` date DEFAULT NULL COMMENT '发布时间',
  `is_money` int(11) DEFAULT NULL COMMENT '是否收费',
  `book_money` int(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_books_section
-- ----------------------------
INSERT INTO `t_books_section` VALUES ('1', '1', '第一章', '悟空出世', '悟空出世', '2018-03-01', '0', '0');
INSERT INTO `t_books_section` VALUES ('2', '1', '第二章', '悟空拜师学艺', '<p>悟空拜师学艺</p>', '2018-03-01', '0', '0');

-- ----------------------------
-- Table structure for t_booktype
-- ----------------------------
DROP TABLE IF EXISTS `t_booktype`;
CREATE TABLE `t_booktype` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '图书类型编号',
  `name` varchar(20) DEFAULT NULL COMMENT '图书类型名称',
  `introduction` varchar(100) DEFAULT NULL COMMENT '图书类型简介',
  `status` int(11) DEFAULT NULL COMMENT '图书类型状态',
  `create_time` datetime DEFAULT NULL COMMENT '图书类型创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_booktype
-- ----------------------------
INSERT INTO `t_booktype` VALUES ('1', '都市', '都市小说', '0', '2018-02-28 13:39:01');
INSERT INTO `t_booktype` VALUES ('2', '爱情', '爱情小说，主要讲述的是有关于爱情的故事', '0', '2018-02-28 13:41:42');
INSERT INTO `t_booktype` VALUES ('3', '玄幻', '玄幻小说，西游记就是一部非常好的玄幻小说', '0', '2018-02-28 13:53:18');

-- ----------------------------
-- Table structure for t_book_collect
-- ----------------------------
DROP TABLE IF EXISTS `t_book_collect`;
CREATE TABLE `t_book_collect` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '图书收藏编号',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户编号',
  `books_id` bigint(20) DEFAULT NULL COMMENT '图书编号',
  `create_time` datetime DEFAULT NULL COMMENT '收藏时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_book_collect
-- ----------------------------
INSERT INTO `t_book_collect` VALUES ('1', '1', '1', '2018-03-01 17:05:03');

-- ----------------------------
-- Table structure for t_book_module
-- ----------------------------
DROP TABLE IF EXISTS `t_book_module`;
CREATE TABLE `t_book_module` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '小说模块等级',
  `name` varchar(20) DEFAULT NULL COMMENT '小说模块名称',
  `levels` int(11) DEFAULT NULL COMMENT '小说模块排序级别',
  `status` int(11) DEFAULT NULL COMMENT '小说模块状态',
  `create_time` datetime DEFAULT NULL COMMENT '小说创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_book_module
-- ----------------------------
INSERT INTO `t_book_module` VALUES ('1', '主编力荐', '9', '0', '2018-03-02 09:30:12');
INSERT INTO `t_book_module` VALUES ('2', '完本热推', '10', '0', '2018-03-02 09:40:05');
INSERT INTO `t_book_module` VALUES ('3', '异术超能', '8', '0', '2018-03-02 10:40:52');
INSERT INTO `t_book_module` VALUES ('4', '都市生活', '7', '0', '2018-03-02 10:42:49');
INSERT INTO `t_book_module` VALUES ('5', '黑白两道', '6', '0', '2018-03-02 10:43:26');
INSERT INTO `t_book_module` VALUES ('6', '官场商战', '5', '0', '2018-03-02 10:43:49');
INSERT INTO `t_book_module` VALUES ('7', '青春校园', '4', '0', '2018-03-02 10:44:04');

-- ----------------------------
-- Table structure for t_moneyitem
-- ----------------------------
DROP TABLE IF EXISTS `t_moneyitem`;
CREATE TABLE `t_moneyitem` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '消费编号',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户编号',
  `money` double DEFAULT NULL COMMENT '消费金额',
  `type` int(11) DEFAULT NULL COMMENT '消费类型：0：充值，1：消费',
  `issucc` int(11) DEFAULT NULL COMMENT '消费状态，0：成功,1:失败',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT NULL COMMENT '消费时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_moneyitem
-- ----------------------------

-- ----------------------------
-- Table structure for t_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_permission`;
CREATE TABLE `t_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL,
  `permission` varchar(200) NOT NULL,
  `description` varchar(500) DEFAULT NULL,
  `module_id` bigint(20) NOT NULL,
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `is_active` tinyint(4) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `permission` (`permission`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_permission
-- ----------------------------

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(20) NOT NULL,
  `description` varchar(500) DEFAULT NULL,
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `is_active` tinyint(4) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `title` (`title`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('1', '管理员', '管理员', '2018-02-28 09:43:12', '0');
INSERT INTO `t_role` VALUES ('10', '作者', '作者角色，可以上传小说和图书，并进行编辑', '2018-02-28 10:53:57', '0');

-- ----------------------------
-- Table structure for t_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_role_permission`;
CREATE TABLE `t_role_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) DEFAULT NULL,
  `permission_id` bigint(20) DEFAULT NULL,
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `is_active` tinyint(4) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `role_id` (`role_id`) USING BTREE,
  KEY `permission_id` (`permission_id`) USING BTREE,
  CONSTRAINT `t_role_permission_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `t_role` (`id`),
  CONSTRAINT `t_role_permission_ibfk_2` FOREIGN KEY (`permission_id`) REFERENCES `t_permission` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role_permission
-- ----------------------------

-- ----------------------------
-- Table structure for t_shop
-- ----------------------------
DROP TABLE IF EXISTS `t_shop`;
CREATE TABLE `t_shop` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `book_money` mediumtext,
  `introduction` varchar(200) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_shop
-- ----------------------------
INSERT INTO `t_shop` VALUES ('1', '30元', '30', '3000', '3000个金币，再送20', '0', '2018-02-28 14:28:44');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `phone` varchar(11) DEFAULT NULL COMMENT '用户联系方式',
  `password` varchar(36) DEFAULT NULL COMMENT '用户登录密码',
  `name` varchar(20) DEFAULT NULL COMMENT '用户昵称',
  `realname` varchar(10) DEFAULT NULL COMMENT '用户真实姓名',
  `sex` varchar(2) DEFAULT NULL COMMENT '用户性别',
  `age` int(11) DEFAULT NULL COMMENT '用户年龄',
  `qqopenid` varchar(36) DEFAULT NULL COMMENT 'QQopenid',
  `wbopenid` varchar(36) DEFAULT NULL COMMENT '微博openid',
  `wxopenid` varchar(36) DEFAULT NULL COMMENT '微信openid',
  `isVip` int(11) DEFAULT NULL COMMENT '是否是vip，0代表过客，1代表vip用户',
  `money` double DEFAULT NULL COMMENT '账户余额',
  `status` int(11) DEFAULT NULL COMMENT '是否启用，0代表启用，1代表禁用',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', '15679760329', '96e79218965eb72c92a549dd5a330112', 'admin', 'admin', '0', '21', null, null, null, '0', '0', '0', '2018-02-28 09:05:54');

-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `is_active` tinyint(4) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`) USING BTREE,
  KEY `role_id` (`role_id`) USING BTREE,
  CONSTRAINT `t_user_role_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`),
  CONSTRAINT `t_user_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `t_role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO `t_user_role` VALUES ('1', '1', '1', '2018-02-28 09:43:39', '0');
