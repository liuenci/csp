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

### 技术选型

#### 后端技术

| 技术                 | 说明                | 官网                                                 |
| -------------------- | ------------------- | ---------------------------------------------------- |
| SpringBoot           | 容器+MVC框架        | https://spring.io/projects/spring-boot               |
| SpringSecurity       | 认证和授权框架      | https://spring.io/projects/spring-security           |
| MyBatis              | ORM框架             | http://www.mybatis.org/mybatis-3/zh/index.html       |
| MyBatisGenerator     | 数据层代码生成      | http://www.mybatis.org/generator/index.html          |
| PageHelper           | MyBatis物理分页插件 | http://git.oschina.net/free/Mybatis_PageHelper       |
| Swagger-UI           | 文档生产工具        | https://github.com/swagger-api/swagger-ui            |
| Hibernator-Validator | 验证框架            | http://hibernate.org/validator                       |
| Elasticsearch        | 搜索引擎            | https://github.com/elastic/elasticsearch             |
| RabbitMQ             | 消息队列            | https://www.rabbitmq.com/                            |
| Redis                | 分布式缓存          | https://redis.io/                                    |
| MongoDB              | NoSql数据库         | https://www.mongodb.com                              |
| Docker               | 应用容器引擎        | https://www.docker.com                               |
| Druid                | 数据库连接池        | https://github.com/alibaba/druid                     |
| OSS                  | 对象存储            | https://github.com/aliyun/aliyun-oss-java-sdk        |
| MinIO                | 对象存储            | https://github.com/minio/minio                       |
| JWT                  | JWT登录支持         | https://github.com/jwtk/jjwt                         |
| LogStash             | 日志收集工具        | https://github.com/logstash/logstash-logback-encoder |
| Lombok               | 简化对象封装工具    | https://github.com/rzwitserloot/lombok               |
| Jenkins              | 自动化部署工具      | https://github.com/jenkinsci/jenkins                 |

### 开发工具

| 工具          | 说明                | 官网                                            |
| ------------- | ------------------- | ----------------------------------------------- |
| IDEA          | 开发IDE             | https://www.jetbrains.com/idea/download         |
| RedisDesktop  | redis客户端连接工具 | https://redisdesktop.com/download               |
| Robomongo     | mongo客户端连接工具 | https://robomongo.org/download                  |
| SwitchHosts   | 本地host管理        | https://oldj.github.io/SwitchHosts/             |
| X-shell       | Linux远程连接工具   | http://www.netsarang.com/download/software.html |
| Navicat       | 数据库连接工具      | http://www.formysql.com/xiazai.html             |
| PowerDesigner | 数据库设计工具      | http://powerdesigner.de/                        |
| Axure         | 原型设计工具        | https://www.axure.com/                          |
| MindMaster    | 思维导图设计工具    | http://www.edrawsoft.cn/mindmaster              |
| ScreenToGif   | gif录制工具         | https://www.screentogif.com/                    |
| ProcessOn     | 流程图绘制工具      | https://www.processon.com/                      |
| PicPick       | 图片处理工具        | https://picpick.app/zh/                         |
| Snipaste      | 屏幕截图工具        | https://www.snipaste.com/                       |
| Postman       | API接口调试工具      | https://www.postman.com/                        |
| Typora        | Markdown编辑器      | https://typora.io/                              |

### 开发环境

| 工具          | 版本号 | 下载                                                         |
| ------------- | ------ | ------------------------------------------------------------ |
| JDK           | 1.8    | https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html |
| Mysql         | 5.7    | https://www.mysql.com/                                       |
| Redis         | 5.0    | https://redis.io/download                                    |
| Elasticsearch | 6.2.2  | https://www.elastic.co/downloads                             |
| MongoDB       | 4.2.5  | https://www.mongodb.com/download-center                      |
| RabbitMQ      | 3.7.14 | http://www.rabbitmq.com/download.html                        |
| Nginx         | 1.10   | http://nginx.org/en/download.html                            |

## 许可证

[Apache License 2.0](https://github.com/macrozheng/mall/blob/master/LICENSE)

Copyright (c) 2018-2020 macrozheng
