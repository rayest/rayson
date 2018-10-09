# rayson

## Docker
> run `docker build -t rayson:v1.0 .`

## 多线程
* 项目中涉及到的多线程部分，仅给出了代码，如果要学习基本概念和原理，请参考 Document/Java-高并发.md 文档
* 或者参考《实战Java高并发程序设计》

## Sonar 代码检查
* `brew install sonarqube`
* `sonar start/status/stop/restart`
* `./gradlew sonarqube`
* 访问`http://localhost:9000`并登录 `admin/admin`

## Jenkins
* 用户：ray
* 用户全称：rayest
* 密码：jenkins2018
* email：rayestonal@gmail.com

## Git
* 倘若在添加了 ignore 文件后，git 版本库中仍有 idea 相关文件，需要去除 idea 缓存 `git rm -r --cached .idea`