#学生信息管理系统

##预览
这是一款可以查询山西农业大学软件学院学生信息的PC软件，使用java构建，然而安卓版只是写UI，移植一下就可以了。基础用户只能查到性别、班级等信息，而高级用户开放了所有接口。并且有测试用户，测试用户有限额的查询次数。

此处应该有图片。

论打码技术的优雅性，以及避免PS色阶突破、隐写术。

##功能

 + 可以查询学生的基本信息。
 + 分权限控制用户进行操作(RBAC)。
 + 增删改查学生信息。

##发布及部分思路
因为java的跨平台性，实际上QT更适合写跨平台应用，然而老师却是要java版本，因为java原生UI比较难看，并且效率低，在找寻合适UI的同时，为了避免重复造轮子，采用了[beautyeye](https://github.com/JackJiang2011/beautyeye)框架。

因为一些隐私方面的问题，需要严格控制好数据的安全，一方面要作为原生数据插入数据库，另一方面查询的过程也可以进行动态调试查看。在加密部分涉及到了非对称加密，利用一种RSA算法，非对称密钥。在帐号限制方面，采用了部分注册软件设计的思路，并且加了压缩壳，在最新版360、百度杀毒、腾讯电脑管家下测试通过。

然而现在觉得MySql在没有做任何安全措施的情况下，是毫无安全性可言的。因此需要做好安全服务。

源码部分在[Github](https://github.com/DigDream/SIMS)上，可执行文件会逐步打包。

可以使用git clone命令下载源码。

	git clone www.git

也可通过launchpad直接下载

	brunch

##安装及使用

双击可执行文件，或者根据源码进行编译。

双击之后，填写数据库连接信息后，会弹出帐号登录的对话框，测试帐号为test，密码为test。

##协议

本作品依照GPL v3协议，可自由修改版权，并且欢迎在[Github](https://github.com/DigDream/SIMS)上提issue。但是初始化的数据不对外提供，请联系本人或者学院。

##部分设计文档

[DesignDoc](https://github.com/DigDream/SIMS/blob/master/DesignDoc.md)

##致谢

+ beautyeye框架
+ sqlite
+ chromebook
+ Java Development Kit
+ mysql-connecter

##TODO

1.写关于java的RBAC的个人实践。

2.

##后记
一支穿云箭，千军万马来相见。