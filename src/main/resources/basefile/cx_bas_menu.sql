/*
Navicat MySQL Data Transfer

Source Server         : DB
Source Server Version : 50712
Source Host           : 127.0.0.1:3306
Source Database       : demo

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2018-04-20 16:21:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for cx_bas_menu
-- ----------------------------
DROP TABLE IF EXISTS `cx_bas_menu`;
CREATE TABLE `cx_bas_menu` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL,
  `menu_no` varchar(32) NOT NULL,
  `pid` varchar(32) DEFAULT NULL,
  `url` varchar(32) DEFAULT NULL,
  `type` int(2) DEFAULT NULL,
  `icon` varchar(32) DEFAULT NULL,
  `createTime` varchar(32) DEFAULT NULL,
  `updateTime` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
