/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50540
Source Host           : localhost:3306
Source Database       : mybatis

Target Server Type    : MYSQL
Target Server Version : 50540
File Encoding         : 65001

Date: 2022-11-27 15:52:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `uname` varchar(50) DEFAULT NULL,
  `upwd` varchar(30) NOT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'liubei', '123456');
INSERT INTO `t_user` VALUES ('2', 'liyuanfang', '123456');
INSERT INTO `t_user` VALUES ('3', 'guanyu', '123456');
INSERT INTO `t_user` VALUES ('4', 'liuyang', '123456');
INSERT INTO `t_user` VALUES ('5', 'zhangfei', '123456');
INSERT INTO `t_user` VALUES ('6', 'wukong', '123456');
INSERT INTO `t_user` VALUES ('7', 'bajie', '123');
