## 影城管理系统 FilmManagementSystem_ByChaner
&#160;&#160;&#160;&#160; 本项目是一个影城管理系统，旨在帮助影院管理者有效管理电影放映、座位安排和票务销售等方面的任务。系统全部采用UI界面进行交互，提供了以下主要功能：
- 管理员、经理、用户、前台 四种用户类型；
- 用户管理：包括添加、删除、修改用户信息，以及创建删除用户；
- 电影管理：包括电影下映、排片管理等；
- 票务管理：票务销售与订单管理。

## 项目亮点
- 项目所有内容均实现了 UI 友好交互，功能完善
- 采用 MySQL 数据库进行数据存储
- 对于密码的修改，采用了正则表达式进行匹配，保证密码合规性(6位以上且有字符)
- 对于程序运行中的异常处理进行了充分考虑，对敏感操作(删除用户、删除电影等)增加了红色弹窗二次确定
- 充分利用面向对象编程语言的特点，构建 MVC 结构，广泛使用泛型、构造方法、抽象类等，项目结构设计清晰

## 技术栈
- 开发工具：IntelliJ IDEA
- Java 版本： JDK 18.0.2
- 操作系统：macOS 14.0 (M1)
- 数据库：MySQL 8.2.0 - arm64
- 数据库连接：MySQL-Connector-J-8.2
- UI 框架：Java Swing
- 版本控制工具：Git
- 数据库管理工具：MySQL Workbench

## 系统设计思路
&#160;&#160;&#160;&#160; 面向对象编程的设计思想，构建 MVC 为核心框架，从项目的实际需求出发，
先建立模型层(Model)，然后建立 View(视觉层)，根据Model和View层需要的函数方法，
设计 控制层(Controller) 中的类和方法，并将公用函数部分进行封装，完成整个项目的构建。

## 使用说明
&#160;&#160;&#160;&#160; 将项目Git Clone 到本地后，使用 IDEA 打开，
JDK 版本一定要选择18，其他版本不支持。

&#160;&#160;&#160;&#160; 请确保已安装 MySQL，然后将MySQL-connector.jar
添加至JDK18的依赖中。

&#160;&#160;&#160;&#160; 完整如上配置，运行 Main.java文件，即可运行项目。

## 项目展示
视频展示请见阿里云盘：https://www.aliyundrive.com/s/yDHUPEwSC98  提取码：py82
![](https://github.com/ICHANER/FilmManagementSystem_Chaner/blob/main/CinemaManagement_NEW_PROJECT/src/View/homepage.png?raw=true)