-- phpMyAdmin SQL Dump
-- version 2.11.1.2
-- http://www.phpmyadmin.net
--
-- 主机: localhost
-- 生成日期: 2008 年 09 月 17 日 16:01
-- 服务器版本: 5.1.25
-- PHP 版本: 5.2.6

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

--
-- 数据库: `popshop`
--

-- --------------------------------------------------------

--
-- 表的结构 `categorie`
--

CREATE TABLE IF NOT EXISTS `categorie` (
  `categorieId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `catName` char(100) NOT NULL,
  `information` varchar(200) DEFAULT NULL,
  `image` char(100) NOT NULL DEFAULT '',
  `sortOrder` int(10) unsigned zerofill DEFAULT NULL,
  `parentId` int(11) NOT NULL DEFAULT '0',
  `stutas` tinyint(1) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`categorieId`),
  KEY `name` (`catName`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=7 ;

--
-- 导出表中的数据 `categorie`
--

INSERT INTO `categorie` (`categorieId`, `catName`, `information`, `image`, `sortOrder`, `parentId`, `stutas`) VALUES
(1, 'testCatName', 'testCatInfomation', 'testCatImage', 0000000000, 1, 0),
(2, 'testCatName', 'testCatInfomation', 'testCatImage', 0000000000, 1, 0),
(3, 'testCatName', 'testCatInfomation', 'testCatImage', 0000000000, 1, 0),
(4, 'testCatName', 'testCatInfomation', 'testCatImage', 0000000000, 1, 0),
(6, '公仔衣服', '公仔衣服', '11', NULL, 1, 0);

-- --------------------------------------------------------

--
-- 表的结构 `cat_product`
--

CREATE TABLE IF NOT EXISTS `cat_product` (
  `productId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `categorieId` int(10) unsigned NOT NULL DEFAULT '0',
  UNIQUE KEY `productId` (`productId`,`categorieId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- 导出表中的数据 `cat_product`
--


-- --------------------------------------------------------

--
-- 表的结构 `group_user`
--

CREATE TABLE IF NOT EXISTS `group_user` (
  `userInfoId` int(10) unsigned NOT NULL,
  `groupId` int(10) unsigned NOT NULL,
  UNIQUE KEY `userInfoId` (`userInfoId`,`groupId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- 导出表中的数据 `group_user`
--


-- --------------------------------------------------------

--
-- 表的结构 `manufacturer`
--

CREATE TABLE IF NOT EXISTS `manufacturer` (
  `manufacturerId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `manufacturerName` char(100) NOT NULL DEFAULT '',
  `information` varchar(200) DEFAULT NULL,
  `manufacturerImage` char(100) NOT NULL DEFAULT '',
  `manufacturerURL` char(100) NOT NULL DEFAULT '',
  `urlClicked` int(11) NOT NULL DEFAULT '0',
  `dateLastClick` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`manufacturerId`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- 导出表中的数据 `manufacturer`
--

INSERT INTO `manufacturer` (`manufacturerId`, `manufacturerName`, `information`, `manufacturerImage`, `manufacturerURL`, `urlClicked`, `dateLastClick`) VALUES
(1, 'test manufacturer name', 'test manufacturer information', 'test imager', 'test manufacturer URL', 1, '2008-07-31 08:36:07'),
(2, 'test manufacturer name', 'test manufacturer information', 'test imager', 'test manufacturer URL', 1, '2008-07-31 08:36:37'),
(3, 'test manufacturer name', 'test manufacturer information', 'test imager', 'test manufacturer URL', 1, '2008-08-05 12:27:19');

-- --------------------------------------------------------

--
-- 表的结构 `manufacturetocategorie`
--

CREATE TABLE IF NOT EXISTS `manufacturetocategorie` (
  `categorieId` int(11) NOT NULL DEFAULT '0',
  `manufacturerId` int(11) NOT NULL DEFAULT '0'
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- 导出表中的数据 `manufacturetocategorie`
--


-- --------------------------------------------------------

--
-- 表的结构 `orderinfomation`
--

CREATE TABLE IF NOT EXISTS `orderinfomation` (
  `orderId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `userInfoId` int(11) unsigned NOT NULL DEFAULT '0',
  `customerName` varchar(100) NOT NULL DEFAULT '',
  `customerCompany` varchar(100) DEFAULT NULL,
  `customerStreetAddress` varchar(255) DEFAULT NULL,
  `customerSuburb` varchar(100) DEFAULT NULL,
  `customerCity` varchar(100) DEFAULT NULL,
  `customerPostcode` varchar(50) DEFAULT NULL,
  `customerSate` varchar(100) DEFAULT NULL,
  `customerCountry` varchar(100) DEFAULT NULL,
  `customerTelephone` varchar(20) NOT NULL DEFAULT '',
  `customerEmailAddress` varchar(100) NOT NULL DEFAULT '',
  `customerMobile` varchar(255) NOT NULL DEFAULT '',
  `deliveryName` varchar(100) NOT NULL DEFAULT '',
  `deliveryCompany` varchar(100) DEFAULT NULL,
  `deliveryStreetAddress` varchar(255) NOT NULL DEFAULT '',
  `deliverySuburb` varchar(100) DEFAULT NULL,
  `deliveryCity` varchar(100) DEFAULT NULL,
  `deliveryPostcode` varchar(50) DEFAULT NULL,
  `deliveryState` varchar(100) DEFAULT NULL,
  `deliveryCountry` varchar(100) DEFAULT NULL,
  `deliveryMobile` varchar(255) NOT NULL DEFAULT '',
  `paymentMethod` varchar(100) NOT NULL DEFAULT '',
  `ccType` varchar(100) NOT NULL DEFAULT '',
  `ccOwner` varchar(100) NOT NULL DEFAULT '',
  `ccNumber` varchar(100) NOT NULL DEFAULT '',
  `ccExpires` varchar(100) NOT NULL DEFAULT '',
  `lastModified` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `datePurchased` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `orderStatus` int(11) NOT NULL DEFAULT '0',
  `orderDateFinished` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `currency` varchar(100) NOT NULL DEFAULT '',
  `deliveryTelephone` varchar(20) NOT NULL DEFAULT '',
  `orderBillNumber` varchar(200) NOT NULL DEFAULT '',
  `orderMark` text,
  `deliveryEmail` varchar(255) NOT NULL DEFAULT '',
  `finalOrderPrice` decimal(10,2) unsigned zerofill NOT NULL,
  PRIMARY KEY (`orderId`,`orderBillNumber`),
  KEY `customerName` (`customerName`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- 导出表中的数据 `orderinfomation`
--


-- --------------------------------------------------------

--
-- 表的结构 `orderproductitem`
--

CREATE TABLE IF NOT EXISTS `orderproductitem` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `orderId` int(11) NOT NULL DEFAULT '0',
  `productId` int(11) NOT NULL DEFAULT '0',
  `prodModel` varchar(100) NOT NULL DEFAULT '',
  `prodName` varchar(100) NOT NULL DEFAULT '',
  `prodPrice` decimal(10,0) NOT NULL DEFAULT '0',
  `finalPrice` decimal(10,0) NOT NULL DEFAULT '0',
  `tax` decimal(10,0) NOT NULL DEFAULT '0',
  `qrantity` int(11) NOT NULL DEFAULT '0',
  `mark` text,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- 导出表中的数据 `orderproductitem`
--


-- --------------------------------------------------------

--
-- 表的结构 `permision`
--

CREATE TABLE IF NOT EXISTS `permision` (
  `permisionId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `permisionName` varchar(32) NOT NULL DEFAULT '',
  `permisionContent` varchar(32) NOT NULL DEFAULT '',
  `stutas` tinyint(3) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`permisionId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- 导出表中的数据 `permision`
--


-- --------------------------------------------------------

--
-- 表的结构 `productattribute`
--

CREATE TABLE IF NOT EXISTS `productattribute` (
  `attributeId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `productId` int(10) unsigned NOT NULL DEFAULT '0',
  `name` varchar(50) NOT NULL DEFAULT '',
  `value` varchar(255) NOT NULL DEFAULT '',
  `mark` varchar(255) DEFAULT NULL,
  `price` decimal(10,0) NOT NULL DEFAULT '0',
  PRIMARY KEY (`attributeId`),
  KEY `name` (`name`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- 导出表中的数据 `productattribute`
--


-- --------------------------------------------------------

--
-- 表的结构 `productimage`
--

CREATE TABLE IF NOT EXISTS `productimage` (
  `imageId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `productId` int(10) unsigned NOT NULL DEFAULT '0',
  `path` varchar(100) NOT NULL DEFAULT '',
  `alt` varchar(100) NOT NULL DEFAULT '',
  `content` varchar(255) NOT NULL DEFAULT '',
  `mark` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`imageId`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=24 ;

--
-- 导出表中的数据 `productimage`
--

INSERT INTO `productimage` (`imageId`, `productId`, `path`, `alt`, `content`, `mark`) VALUES
(1, 1, 'image/test.jpg', 'Image ALT Info Test', 'Image Info Content Test', 'Image Test Mark '),
(2, 1, 'image/test.jpg', 'Image ALT Info Test', 'Image Info Content Test', 'Image Test Mark '),
(3, 1, 'image/test.jpg', 'Image ALT Info Test', 'Image Info Content Test', 'Image Test Mark '),
(4, 2, 'image/test.jpg', 'Image ALT Info Test', 'Image Info Content Test', 'Image Test Mark '),
(5, 2, 'image/test.jpg', 'Image ALT Info Test', 'Image Info Content Test', 'Image Test Mark '),
(6, 2, 'image/test.jpg', 'Image ALT Info Test', 'Image Info Content Test', 'Image Test Mark '),
(7, 3, 'image/test.jpg', 'Image ALT Info Test', 'Image Info Content Test', 'Image Test Mark '),
(8, 3, 'image/test.jpg', 'Image ALT Info Test', 'Image Info Content Test', 'Image Test Mark '),
(9, 3, 'image/test.jpg', 'Image ALT Info Test', 'Image Info Content Test', 'Image Test Mark '),
(10, 4, 'image/test.jpg', 'Image ALT Info Test', 'Image Info Content Test', 'Image Test Mark '),
(11, 4, 'image/test.jpg', 'Image ALT Info Test', 'Image Info Content Test', 'Image Test Mark '),
(12, 4, 'image/test.jpg', 'Image ALT Info Test', 'Image Info Content Test', 'Image Test Mark '),
(13, 5, 'image/test.jpg', 'Image ALT Info Test', 'Image Info Content Test', 'Image Test Mark '),
(14, 5, 'image/test.jpg', 'Image ALT Info Test', 'Image Info Content Test', 'Image Test Mark '),
(15, 5, 'image/test.jpg', 'Image ALT Info Test', 'Image Info Content Test', 'Image Test Mark '),
(16, 6, 'image/test.jpg', 'Image ALT Info Test', 'Image Info Content Test', 'Image Test Mark '),
(17, 6, 'image/test.jpg', 'Image ALT Info Test', 'Image Info Content Test', 'Image Test Mark '),
(18, 6, 'image/test.jpg', 'Image ALT Info Test', 'Image Info Content Test', 'Image Test Mark '),
(19, 1, 'image/test.jpg', 'Image ALT Info Test', 'Image Info Content Test', 'Image Test Mark '),
(20, 1, 'image/test.jpg', 'Image ALT Info Test', 'Image Info Content Test', 'Image Test Mark '),
(21, 1, 'image/test.jpg', 'Image ALT Info Test', 'Image Info Content Test', 'Image Test Mark '),
(22, 12, 'image/test.jpg', 'Image ALT Info Test', 'Image Info Content Test', 'Image Test Mark '),
(23, 11, 'image/test.jpg', 'Image ALT Info Test', 'Image Info Content Test', 'Image Test Mark ');

-- --------------------------------------------------------

--
-- 表的结构 `productinfo`
--

CREATE TABLE IF NOT EXISTS `productinfo` (
  `productId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `quantity` int(10) unsigned zerofill NOT NULL DEFAULT '0000000000',
  `model` varchar(50) DEFAULT NULL,
  `productName` varchar(50) NOT NULL,
  `price` decimal(10,0) NOT NULL DEFAULT '0',
  `dateAdded` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `lastModified` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `dateAvailable` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `description` text NOT NULL,
  `weight` decimal(10,0) DEFAULT '0',
  `URL` varchar(200) DEFAULT NULL,
  `stutas` tinyint(3) unsigned zerofill NOT NULL DEFAULT '000',
  `taxId` int(10) unsigned NOT NULL DEFAULT '0',
  `manufacturerId` int(10) unsigned DEFAULT '0',
  `viewed` int(10) unsigned DEFAULT NULL,
  `ordered` int(10) unsigned zerofill DEFAULT '0000000000',
  PRIMARY KEY (`productId`),
  KEY `name` (`productName`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=13 ;

--
-- 导出表中的数据 `productinfo`
--

INSERT INTO `productinfo` (`productId`, `quantity`, `model`, `productName`, `price`, `dateAdded`, `lastModified`, `dateAvailable`, `description`, `weight`, `URL`, `stutas`, `taxId`, `manufacturerId`, `viewed`, `ordered`) VALUES
(1, 0000000020, 'Product Test Model', 'Product Test Name Data', 11, '2008-09-03 15:09:37', '2008-09-03 15:09:37', '2008-09-03 15:09:37', 'product Test Data,测试数据!', 2, 'http://www.poprlz.cn', 000, 0, NULL, 20, 0000000010),
(2, 0000000020, 'Product Test Model', 'Product Test Name Data', 11, '2008-09-03 15:10:52', '2008-09-03 15:10:52', '2008-09-03 15:10:52', 'product Test Data,测试数据!', 2, 'http://www.poprlz.cn', 000, 0, NULL, 20, 0000000010),
(3, 0000000020, 'Product Test Model', 'Product Test Name Data', 11, '2008-09-03 15:11:30', '2008-09-03 15:11:30', '2008-09-03 15:11:30', 'product Test Data,测试数据!', 2, 'http://www.poprlz.cn', 000, 0, NULL, 20, 0000000010),
(4, 0000000020, 'Product Test Model', 'Product Test Name Data', 11, '2008-09-03 15:29:43', '2008-09-03 15:29:43', '2008-09-03 15:29:43', 'product Test Data,测试数据!', 2, 'http://www.poprlz.cn', 000, 0, NULL, 20, 0000000010),
(5, 0000000020, 'Product Test Model', 'Product Test Name Data', 11, '2008-09-03 15:37:07', '2008-09-03 15:37:07', '2008-09-03 15:37:07', 'product Test Data,测试数据!', 2, 'http://www.poprlz.cn', 000, 0, NULL, 20, 0000000010),
(6, 0000000020, 'Product Test Model', 'Product Test Name Data', 11, '2008-09-04 12:57:01', '2008-09-04 12:57:01', '2008-09-04 12:57:01', 'product Test Data,测试数据!', 2, 'http://www.poprlz.cn', 000, 0, NULL, 20, 0000000010),
(7, 0000000020, 'Product Test Model', 'Product Test Name Data', 11, '2008-09-05 13:44:51', '2008-09-05 13:44:51', '2008-09-05 13:44:51', 'product Test Data,测试数据!', 2, 'http://www.poprlz.cn', 000, 0, NULL, 20, 0000000010),
(8, 0000000020, 'Product Test Model', 'Product Test Name Data', 11, '2008-09-10 14:14:35', '2008-09-10 14:14:35', '2008-09-10 14:14:35', 'product Test Data,测试数据!', 2, 'http://www.poprlz.cn', 000, 0, NULL, 20, 0000000010),
(9, 0000000020, 'Product Test Model', 'Product Test Name Data', 11, '2008-09-10 14:14:37', '2008-09-10 14:14:37', '2008-09-10 14:14:37', 'product Test Data,测试数据!', 2, 'http://www.poprlz.cn', 000, 0, NULL, 20, 0000000010),
(10, 0000000020, 'Product Test Model', 'Product Test Name Data', 11, '2008-09-10 14:14:41', '2008-09-10 14:14:41', '2008-09-10 14:14:41', 'product Test Data,测试数据!', 2, 'http://www.poprlz.cn', 000, 0, NULL, 20, 0000000010),
(11, 0000000020, 'Product Test Model', 'Product Test Name Data', 11, '2008-09-16 12:38:33', '2008-09-16 12:38:33', '2008-09-16 12:38:33', 'product Test Data,测试数据!', 2, 'http://www.poprlz.cn', 000, 0, NULL, 20, 0000000010),
(12, 0000000020, 'Product Test Model', 'Product Test Name Data', 11, '2008-09-16 12:39:36', '2008-09-16 12:39:36', '2008-09-16 12:39:36', 'product Test Data,测试数据!', 2, 'http://www.poprlz.cn', 000, 0, NULL, 20, 0000000010);

-- --------------------------------------------------------

--
-- 表的结构 `productoption`
--

CREATE TABLE IF NOT EXISTS `productoption` (
  `optionId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `productId` int(11) NOT NULL DEFAULT '0',
  `name` varchar(100) NOT NULL DEFAULT '',
  `value` varchar(255) NOT NULL DEFAULT '',
  `mark` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`optionId`),
  KEY `name` (`name`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- 导出表中的数据 `productoption`
--


-- --------------------------------------------------------

--
-- 表的结构 `productreview`
--

CREATE TABLE IF NOT EXISTS `productreview` (
  `reviewId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `productId` int(10) unsigned NOT NULL DEFAULT '0',
  `userInfoId` int(11) NOT NULL DEFAULT '0',
  `rating` int(10) unsigned zerofill NOT NULL DEFAULT '0000000000',
  `dateAdded` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `lastModify` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `content` text NOT NULL,
  PRIMARY KEY (`reviewId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- 导出表中的数据 `productreview`
--


-- --------------------------------------------------------

--
-- 表的结构 `roleinfo`
--

CREATE TABLE IF NOT EXISTS `roleinfo` (
  `roleId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `roleName` varchar(32) NOT NULL DEFAULT '',
  `roleContent` varchar(32) NOT NULL DEFAULT '',
  `stutas` tinyint(3) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`roleId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- 导出表中的数据 `roleinfo`
--


-- --------------------------------------------------------

--
-- 表的结构 `usergroup`
--

CREATE TABLE IF NOT EXISTS `usergroup` (
  `groupId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `groupName` varchar(99) NOT NULL DEFAULT '',
  `mark` varchar(125) DEFAULT '',
  `stutas` int(1) NOT NULL DEFAULT '0',
  `level` tinyint(3) unsigned zerofill NOT NULL,
  `parentId` int(10) unsigned zerofill DEFAULT '0000000000',
  PRIMARY KEY (`groupId`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- 导出表中的数据 `usergroup`
--


-- --------------------------------------------------------

--
-- 表的结构 `userinfo`
--

CREATE TABLE IF NOT EXISTS `userinfo` (
  `userInfoId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `userName` varchar(32) NOT NULL DEFAULT '',
  `userPassword` varchar(32) NOT NULL DEFAULT '',
  `userEmail` varchar(99) NOT NULL DEFAULT '',
  `stutas` tinyint(3) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`userInfoId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- 导出表中的数据 `userinfo`
--

