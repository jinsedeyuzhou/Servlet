# Servlet
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/bfcabf1d9793485d84f090e542255710)](https://www.codacy.com/app/xiaoyaoyou1212/XSnow?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=xiaoyaoyou1212/XSnow&amp;utm_campaign=Badge_Grade) [![License](https://img.shields.io/badge/License-Apache--2.0-green.svg)](https://github.com/xiaoyaoyou1212/XSnow/blob/master/LICENSE) [![API](https://img.shields.io/badge/API-12%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=12)

基于Servlet开发的新闻客户端后台部分功能

### 一、开发环境搭建

1. 功能分析

 * 用户注册
 * 用户登录
 * 获取新闻流
 * 利用fiter 全局校验

2. 工程搭建

* 导入所需Jar包:
    * MySQL的驱动包:mysql-connector-java-5.1.33-bin.jar
    * JDBC的Jar包:
        * c3p0连接池:
          * c3p0-0.9.5-pre10.jar
          * mchange-commons-java-0.2.8.jar
    * dbutils工具包:
        * commons-dbutils-1.6.jar
        * commons-logging-1.1.3.jar
    * JavaBean的工具包:commons-beanutils-1.8.3.jar
    * 创建Web工程所需的配置文件及工具类:
         * c3p0连接池的配置文件.
         * JDBCUtils工具类
    * json数据解析
        * Gson gson-2.8.5.jar
        * fastjson-1.2.9.jar

* 搭建Web的MVC四层架构:

    * com.ebrightmoon.view:视图表述层,主要以显示逻辑为主.
    * com.ebrightmoon.servlet:核心控制层,主要以Servlet为主.
    * com.ebrightmoon.service:业务逻辑层,主要以业务类为主.
    * com.ebrightmoon.dao:数据访问层,主要以操作数据库为主.
    * com.ebrightmoon.bean:数据访问层,主要以JavaBean为主.
    * com.ebrightmoon.utils:应用工具包
    * com.ebrightmoon.filter:主要以过滤器为主.
    * com.ebrightmoon.pool: 数据库连接池。
    * com.ebrightmoon.test：单元测试。

### 二、数据库设计

1. 概念模型  
    见文件新闻.cdm
2. 数据模型  
    见文件新闻.cdb
3. 生成SQL  
    见文件data.sql

### 三、功能开发

1. 注册接口

2. 登录接口
3. 获取feed流

### 四、部分功能实现

1. 全站中文乱码   
利用EncodingFilter实现乱码处理
2. 全站接口校验    
利用ParameterCalibrationFilter 实现全局校验

### 五、Android客户端实现
见 https://github.com/jinsedeyuzhou/component

### 附录
无

*注:* servlet 3.0 基于注解实现filter，filter先后顺序按照类名自然顺序过滤。
