# csp
## 前言

`csp`:`cier scaffold project`，致力于打造标准工程脚手架。

### 组织结构

``` lua
csp
├── csp-admin -- 前端调用接口
├── csp-admin-starter -- 服务启动入口
├── csp-api -- 提供给第三方接口
└── csp-core -- 具体实现
```
### 开发进度
* 2020-06-23 
    * 项目初始化
    * 接入web接口
* 2020-06-24 
    * 接入常用工具类
    * 增加Logback日志框架
* 2020-06-28 
    * 完成小功能框架搭建
* 2020-06-29 
    * swagger
    * mongodb
    * mongodb切面事务接入
* 2020-06-30 
    * mybatis接入
* 2020-07-02 
    * 切换 v1.0.2.mongo 版本分支
    * mybatis 事务接入
    * Id生成器接入
    * hikari连接池接入
* 2020-07-07
    * 接入SpringUtils工具类