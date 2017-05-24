/*
Navicat MySQL Data Transfer

Source Server         : localhost_3307
Source Server Version : 50520
Source Host           : localhost:3307
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2017-04-18 15:47:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `mId` varchar(255) NOT NULL,
  `authTime` datetime DEFAULT NULL,
  `idCard` varchar(255) DEFAULT NULL,
  `realName` varchar(255) DEFAULT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`mId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of test
-- ----------------------------
INSERT INTO `test` VALUES ('1', '2017-04-18 14:42:58', '1', '陈哥', '1');
