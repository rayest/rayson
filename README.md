# org.rayson

## Docker
> run `docker build -t org.rayson:v1.0 .`

## 多线程
* 项目中涉及到的多线程部分，仅给出了代码，如果要学习基本概念和原理，请参考 Document/Java-高并发.md 文档
* 或者参考《实战Java高并发程序设计》

## Sonar 代码检查
* `brew install sonarqube`
* `sonar start/status/stop/restart`
* `./gradlew sonarqube`
* 访问`http://localhost:9000`并登录 `admin/admin`

## Jenkins
> 本地启动：java -jar jenkins.war
> 登录：http://localhost:8080
* 用户：ray
* 用户全称：rayest
* 密码：jenkins2018
* email：rayestonal@gmail.com

## Git
* 倘若在添加了 ignore 文件后，git 版本库中仍有 idea 相关文件，需要去除 idea 缓存 `git rm -r --cached .idea`

## Rest Assured 进行 API 接口测试
* 配置 HSQL 数据库连接参数
* 配置 liquibase 数据库操作
* Rest Assured 文档：`https://github.com/rest-assured/rest-assured/wiki/Usage`
* API 接口测试可以只测试成功的情况，其他需要单元测试


## 数据库
* 若启动时 liquibase 遇到 `Could not acquire change log lock.`，可以尝试查询和更改如下操作

``` 
   UPDATE DATABASECHANGELOGLOCK
   SET    DATABASECHANGELOGLOCK.LOCKED = 0,
          DATABASECHANGELOGLOCK.LOCKGRANTED = NULL,
          DATABASECHANGELOGLOCK.LOCKEDBY = NULL
   WHERE  ID=1;
```
```
    SELECT * FROM DATABASECHANGELOGLOCK;
    SELECT * FROM DATABASECHANGELOG;
```