/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50540
Source Host           : localhost:3306
Source Database       : blog

Target Server Type    : MYSQL
Target Server Version : 50540
File Encoding         : 65001

Date: 2022-12-07 16:58:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `blog`
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog` (
  `bid` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `btitle` varchar(32) DEFAULT NULL COMMENT '标题',
  `type_fk` int(11) DEFAULT NULL COMMENT '类别',
  `u_fk` int(11) DEFAULT NULL COMMENT '博主',
  `date` date DEFAULT NULL COMMENT '日期',
  `bcontent` varchar(2000) DEFAULT NULL COMMENT '内容',
  PRIMARY KEY (`bid`),
  KEY `u_fk` (`u_fk`),
  KEY `type_fk` (`type_fk`),
  CONSTRAINT `blog_ibfk_1` FOREIGN KEY (`u_fk`) REFERENCES `user` (`uid`),
  CONSTRAINT `blog_ibfk_2` FOREIGN KEY (`type_fk`) REFERENCES `btype` (`typeid`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog
-- ----------------------------
INSERT INTO `blog` VALUES ('1', '绿色校园', '1', '1', '2020-03-15', '绿色校园,玉兰花开,塑胶操场,校园南墙外花开似锦');
INSERT INTO `blog` VALUES ('2', '北大校园名人', '2', '1', '2020-03-15', '北大好运，我也好运');
INSERT INTO `blog` VALUES ('3', '学习雷锋校园活动', '1', '1', '2020-03-15', '学习雷锋好榜样');
INSERT INTO `blog` VALUES ('11', '测试', '1', '1', '2022-12-02', '<p><span style=\"color: rgb(255, 0, 0);\"><em><strong>测试</strong></em></span></p><p><span style=\"color: rgb(255, 0, 0);\"><em><strong><img src=\"/blog/ueditor/jsp/upload/image/20221202/1669948454622027948.jpg\" title=\"1669948454622027948.jpg\" alt=\"双彩虹.jpg\"/></strong></em></span></p>');
INSERT INTO `blog` VALUES ('12', '综合类测试', '7', '1', '2022-12-02', '<p><span style=\"border: 1px solid rgb(0, 0, 0); color: rgb(255, 255, 0);\"><em><strong>综合类测试</strong></em></span></p>');
INSERT INTO `blog` VALUES ('13', '小类删除测试', null, null, '2022-12-03', '小类删除测试');

-- ----------------------------
-- Table structure for `btype`
-- ----------------------------
DROP TABLE IF EXISTS `btype`;
CREATE TABLE `btype` (
  `typeid` int(11) NOT NULL AUTO_INCREMENT,
  `typename` varchar(32) DEFAULT NULL,
  `type_pid` int(11) DEFAULT NULL,
  `typedes` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`typeid`),
  KEY `type_pid` (`type_pid`),
  CONSTRAINT `btype_ibfk_1` FOREIGN KEY (`type_pid`) REFERENCES `btype` (`typeid`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of btype
-- ----------------------------
INSERT INTO `btype` VALUES ('1', '生活类博客', null, '记录博主的生活经历和日常感悟');
INSERT INTO `btype` VALUES ('2', '技术类博客', null, '分享转载或原创的网络赚钱教程为主要内容');
INSERT INTO `btype` VALUES ('3', '校园类博客', null, '记录校园风采');
INSERT INTO `btype` VALUES ('4', '综合型博客', null, '内容比较杂,生活、网赚、技术都包含在内,关注的领域和范围较广222');
INSERT INTO `btype` VALUES ('5', '北大校园学雷锋', '3', '学习雷锋好榜样');
INSERT INTO `btype` VALUES ('6', '学习java小技巧', '3', 'java注重理论和实践相结合');
INSERT INTO `btype` VALUES ('7', '清华大学3G天翼校园活动', '3', '3G无处不在');
INSERT INTO `btype` VALUES ('8', '测试类型1', '3', '3G无处不在');
INSERT INTO `btype` VALUES ('19', '中公教育', '3', '北京五方桥基地');
INSERT INTO `btype` VALUES ('21', '美食街', '1', '吃货的世界');
INSERT INTO `btype` VALUES ('22', 'java学习小技巧', '2', '学习java 就来中公教育u就业');
INSERT INTO `btype` VALUES ('25', '综合类博客', '4', '综合类博客，包括方方面面');
INSERT INTO `btype` VALUES ('27', '历史', '4', '历史信息');
INSERT INTO `btype` VALUES ('28', '天文地理', null, '天文地理');

-- ----------------------------
-- Table structure for `evaluate`
-- ----------------------------
DROP TABLE IF EXISTS `evaluate`;
CREATE TABLE `evaluate` (
  `eid` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `econtent` varchar(200) DEFAULT NULL COMMENT '评价内容',
  `b_fk` int(11) DEFAULT NULL COMMENT '博客外键',
  `u_fk` int(11) DEFAULT NULL COMMENT '评价用户外键',
  `etime` date DEFAULT NULL COMMENT '评价时间',
  PRIMARY KEY (`eid`),
  KEY `b_fk` (`b_fk`),
  KEY `u_fk` (`u_fk`),
  CONSTRAINT `evaluate_ibfk_1` FOREIGN KEY (`b_fk`) REFERENCES `blog` (`bid`),
  CONSTRAINT `evaluate_ibfk_2` FOREIGN KEY (`u_fk`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of evaluate
-- ----------------------------
INSERT INTO `evaluate` VALUES ('1', '测试数据', '1', '1', '2020-03-15');
INSERT INTO `evaluate` VALUES ('2', '这是测试数据', '1', '1', '2020-03-15');
INSERT INTO `evaluate` VALUES ('3', '数据', '1', '1', '2020-02-02');

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `roleid` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键值',
  `rolename` varchar(32) DEFAULT NULL COMMENT '角色名称',
  `roledes` varchar(32) DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`roleid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '管理员', '管理整个博客网站');
INSERT INTO `role` VALUES ('2', '普通用户', '浏览博客网站');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户主键',
  `uname` varchar(32) DEFAULT NULL COMMENT '用户名',
  `upass` varchar(32) DEFAULT NULL COMMENT '密码',
  `email` varchar(32) DEFAULT NULL COMMENT '邮箱',
  `utime` date DEFAULT NULL COMMENT '注册日期',
  `utype` int(11) DEFAULT NULL COMMENT '用户类型',
  `truename` varchar(32) DEFAULT NULL COMMENT '真实姓名',
  PRIMARY KEY (`uid`),
  KEY `utype` (`utype`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`utype`) REFERENCES `role` (`roleid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '彩虹', '123', 'zhangcai@163.com', '2021-03-01', '1', '张彩');
INSERT INTO `user` VALUES ('2', '明明', '123', 'mingming@163.com', '2021-03-03', '1', '吴明明');
