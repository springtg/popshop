/*
MySQL Data Transfer
Source Host: 127.0.0.1
Source Database: productmanager
Target Host: 127.0.0.1
Target Database: productmanager
Date: 2009-9-23 17:51:45
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for authorities
-- ----------------------------
CREATE TABLE `authorities` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(20) NOT NULL,
  `DISPLAY_NAME` varchar(20) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for companys
-- ----------------------------
CREATE TABLE `companys` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `COMPANY_NAME` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `MARK` text COLLATE utf8_unicode_ci,
  `STATUS` varchar(20) COLLATE utf8_unicode_ci DEFAULT '''A''' COMMENT '''A''',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `LOGIN_NAME` (`COMPANY_NAME`),
  UNIQUE KEY `USERS_LOGIN_NAME_INDEX` (`COMPANY_NAME`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for process
-- ----------------------------
CREATE TABLE `process` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `PROCESS_NAME` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `STATUS` varchar(20) COLLATE utf8_unicode_ci DEFAULT '''A''' COMMENT '''A''',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `LOGIN_NAME` (`PROCESS_NAME`),
  UNIQUE KEY `USERS_LOGIN_NAME_INDEX` (`PROCESS_NAME`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for processtask
-- ----------------------------
CREATE TABLE `processtask` (
  `ID` int(11) NOT NULL,
  `FINISH_QUANTITY` int(11) NOT NULL,
  `USER_ID` int(11) NOT NULL,
  `PROCESS_ID` int(11) NOT NULL,
  `TASK_ID` int(11) NOT NULL,
  `OPERATE_DATE` datetime NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for resources
-- ----------------------------
CREATE TABLE `resources` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `RESOURCE_TYPE` varchar(20) NOT NULL,
  `VALUE` varchar(255) NOT NULL,
  `ORDER_NUM` float NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for resources_authorities
-- ----------------------------
CREATE TABLE `resources_authorities` (
  `AUTHORITY_ID` int(11) NOT NULL,
  `RESOURCE_ID` int(11) NOT NULL,
  KEY `AUTHORITY_ID` (`AUTHORITY_ID`),
  KEY `RESOURCE_ID` (`RESOURCE_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for roles
-- ----------------------------
CREATE TABLE `roles` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(20) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `NAME` (`NAME`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for roles_authorities
-- ----------------------------
CREATE TABLE `roles_authorities` (
  `ROLE_ID` int(11) NOT NULL,
  `AUTHORITY_ID` int(11) NOT NULL,
  KEY `ROLE_ID` (`ROLE_ID`),
  KEY `AUTHORITY_ID` (`AUTHORITY_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tasks
-- ----------------------------
CREATE TABLE `tasks` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `PRODUCT_NAME` varchar(255) NOT NULL,
  `COLOR` varchar(255) NOT NULL,
  `QUANTITY` int(11) NOT NULL,
  `STATUS` varchar(255) DEFAULT NULL,
  `COMPANY_ID` int(11) NOT NULL,
  `USER_ID` int(11) NOT NULL,
  `CREATE_DATE` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for users
-- ----------------------------
CREATE TABLE `users` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `LOGIN_NAME` varchar(20) NOT NULL,
  `PASSWORD` varchar(20) DEFAULT NULL,
  `NAME` varchar(20) DEFAULT NULL,
  `EMAIL` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `LOGIN_NAME` (`LOGIN_NAME`),
  UNIQUE KEY `USERS_LOGIN_NAME_INDEX` (`LOGIN_NAME`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for users_roles
-- ----------------------------
CREATE TABLE `users_roles` (
  `USER_ID` int(11) NOT NULL,
  `ROLE_ID` int(11) NOT NULL,
  KEY `ROLE_ID` (`ROLE_ID`),
  KEY `USER_ID` (`USER_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `authorities` VALUES ('1', 'A_VIEW_USER', '查看用户');
INSERT INTO `authorities` VALUES ('2', 'A_MODIFY_USER', '管理用户');
INSERT INTO `authorities` VALUES ('3', 'A_VIEW_ROLE', '查看角色');
INSERT INTO `authorities` VALUES ('4', 'A_MODIFY_ROLE', '管理角色');
INSERT INTO `companys` VALUES ('1', 'admin', 'admin', 'N');
INSERT INTO `companys` VALUES ('2', 'afdafasf', '323232', '');
INSERT INTO `companys` VALUES ('3', '创建公司资料', '创建公司资料', 'A');
INSERT INTO `process` VALUES ('1', '装载', 'A');
INSERT INTO `process` VALUES ('2', '喷漆', 'A');
INSERT INTO `process` VALUES ('3', '包装', 'A');
INSERT INTO `resources` VALUES ('1', 'url', '/security/user!save*', '1');
INSERT INTO `resources` VALUES ('2', 'url', '/security/user!delete*', '2');
INSERT INTO `resources` VALUES ('3', 'url', '/security/user*', '3');
INSERT INTO `resources` VALUES ('4', 'url', '/security/role!save*', '4');
INSERT INTO `resources` VALUES ('5', 'url', '/security/role!delete*', '5');
INSERT INTO `resources` VALUES ('6', 'url', '/security/role*', '6');
INSERT INTO `resources_authorities` VALUES ('2', '1');
INSERT INTO `resources_authorities` VALUES ('2', '2');
INSERT INTO `resources_authorities` VALUES ('1', '3');
INSERT INTO `resources_authorities` VALUES ('4', '4');
INSERT INTO `resources_authorities` VALUES ('4', '5');
INSERT INTO `resources_authorities` VALUES ('3', '6');
INSERT INTO `roles` VALUES ('1', '管理员');
INSERT INTO `roles` VALUES ('2', '用户');
INSERT INTO `roles_authorities` VALUES ('1', '1');
INSERT INTO `roles_authorities` VALUES ('1', '2');
INSERT INTO `roles_authorities` VALUES ('1', '3');
INSERT INTO `roles_authorities` VALUES ('1', '4');
INSERT INTO `roles_authorities` VALUES ('2', '1');
INSERT INTO `roles_authorities` VALUES ('2', '3');
INSERT INTO `users` VALUES ('1', 'admin', 'admin', 'Admin', 'admin@springside.org.cn');
INSERT INTO `users` VALUES ('2', 'user', 'user', 'User', 'user@springside.org.cn');
INSERT INTO `users` VALUES ('3', 'user2', 'user2', 'Jack', 'jack@springside.org.cn');
INSERT INTO `users` VALUES ('4', 'user3', 'user3', 'Kate', 'kate@springside.org.cn');
INSERT INTO `users` VALUES ('5', 'user4', 'user4', 'Sawyer', 'sawyer@springside.org.cn');
INSERT INTO `users` VALUES ('6', 'user5', 'user5', 'Ben', 'ben@springside.org.cn');
INSERT INTO `users_roles` VALUES ('1', '1');
INSERT INTO `users_roles` VALUES ('1', '2');
INSERT INTO `users_roles` VALUES ('2', '2');
INSERT INTO `users_roles` VALUES ('3', '2');
INSERT INTO `users_roles` VALUES ('4', '2');
INSERT INTO `users_roles` VALUES ('5', '2');
INSERT INTO `users_roles` VALUES ('6', '2');
