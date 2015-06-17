#学生信息管理系统

##预览
这是一款可以查询山西农业大学软件学院学生信息的PC软件，使用java构建，然而安卓版只是写UI，移植一下就可以了。基础用户只能查到性别、班级等信息，而高级用户开放了所有接口。并且有测试用户，测试用户有限额的查询次数。

此处应该有图片。

![](screenshot/Screenshot3.png)

![](screenshot/Screenshot1.png)

![](screenshot/Screenshot2.png)

##功能

 + 可以查询学生的基本信息。
 + 分权限控制用户进行操作(RBAC)。
 + 增删改查学生信息。

##发布及部分思路
因为java的跨平台性，实际上QT更适合写跨平台应用，然而老师却是要java版本，因为java原生UI比较难看，并且效率低，在找寻合适UI的同时，为了避免重复造轮子，采用了[beautyeye](https://github.com/JackJiang2011/beautyeye)框架。

在加密部分涉及到了非对称加密，利用一种RSA算法，非对称密钥。在帐号限制方面，采用了部分注册软件设计的思路，并且加了压缩壳，在最新版360、百度杀毒、腾讯电脑管家下测试通过。

然而现在觉得MySql在没有做任何安全措施的情况下，是毫无安全性可言的。因此需要做好安全服务，应避免root用户操作。

源码部分在[Github](https://github.com/DigDream/SIMS)上，可执行文件会逐步打包。

可以使用git clone命令下载源码。

	git clone https://github.com/DigDream/SIMS.git

也可通过launchpad直接下载

	brunch

##安装及使用

双击可执行文件，或者根据源码进行编译。

编辑.properties文件，将数据库连接信息填入文件。

数据库表段：

	DROP TABLE IF EXISTS `user`;
	CREATE TABLE `user_table` (
	  `id` bigint(20) NOT NULL AUTO_INCREMENT,
	  `user` varchar(20) NOT NULL,
	  `pw` varchar(50) NOT NULL,
	  `name` varchar(20) NOT NULL,
	  `phone` varchar(20) NOT NULL,
	  KEY `id` (`id`)
	) ENGINE=MyISAM AUTO_INCREMENT=912 DEFAULT CHARSET=utf8;
	
	DROP TABLE IF EXISTS `software`;
	CREATE TABLE `software` (
	  `id` bigint(20) NOT NULL AUTO_INCREMENT,
	  `collage` varchar(25) DEFAULT NULL,
	  `grade` varchar(10) DEFAULT NULL,
	  `class` varchar(10) DEFAULT NULL,
	  `student_id` varchar(12) DEFAULT NULL,
	  `name` varchar(12) DEFAULT NULL,
	  `sex` varchar(5) DEFAULT NULL,
	  `nation` varchar(7) DEFAULT NULL,
	  `phone` varchar(12) DEFAULT NULL,
	  `dorm` varchar(8) DEFAULT NULL,
	  `politics` varchar(12) DEFAULT NULL,
	  `identity_id` varchar(21) DEFAULT NULL,
	  `home_phone` varchar(36) DEFAULT NULL,
	  `zip` varchar(10) DEFAULT NULL,
	  `address` varchar(90) DEFAULT NULL,
	  `native_palce` varchar(59) DEFAULT NULL,
	  `family_backgrond` varchar(250) DEFAULT NULL,
	  `reward` varchar(250) DEFAULT NULL,
	  `other` varchar(250) DEFAULT NULL,
	  `duty` varchar(25) NOT NULL,
	  PRIMARY KEY (`id`)
	) ENGINE=MyISAM AUTO_INCREMENT=1099 DEFAULT CHARSET=utf8;

双击之后，填写数据库连接信息后，会弹出帐号登录的对话框，测试帐号为test，密码为test。

##协议

本作品依照GPL v3协议，可自由修改版权，并且欢迎在[Github](https://github.com/DigDream/SIMS)上提issue。但是初始化的数据不对外提供，请联系本人或者学院。

##部分设计文档

[DesignDoc](https://github.com/DigDream/SIMS/blob/master/DesignDoc.md)

[]()

##致谢

+ beautyeye框架
+ sqlite
+ chromebook
+ Java Development Kit
+ mysql-connecter

##TODO

1.写关于java的RBAC的个人实践。

2.

##关键词

JAVA MVC DAO SINGLETON JDBC MYSQL INTERFACES

##后记
一支穿云箭，千军万马来相见。
