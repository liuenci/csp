# csp
## 前言

`csp`项目致力于打造一个新手入门SpringCloud的项目，采用现阶段流行技术实现。

### 组织结构

``` lua
csp
├── csp-domain -- 数据库实体层以及相关model
├── csp-service -- 具体的业务逻辑层
├── csp-web -- 对接前端的接口
├── csp-api -- 开放外部服务接口
├── csp-utils -- 常用工具类
└── csp-starter -- 核心启动类
```
### 开发进度
* 2020-06-23 项目初始化、接入web接口
* 2020-06-24 接入常用工具类、增加Logback日志框架
* 2020-06-28 完成小功能框架搭建