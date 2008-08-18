--
-- 数据库: `userinfo`
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
  `parentId` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`groupId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

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

