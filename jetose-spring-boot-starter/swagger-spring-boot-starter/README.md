# swagger-spring-boot-starter
整合swagger-restful风格的web服务框架

## 使用指南
- 生成jar包
```
mvn clean package
```
- 上传到本地maven仓库
```
mvn install:install-file -Dfile=target/swagger-spring-boot-starter-1.0-SNAPSHOT.jar -DgroupId=com.jetose -DartifactId=swagger-spring-boot-starter -Dversion=1.0-SNAPSHOT -Dpackaging=jar
```
- pom.xml文件引入依赖
```
<dependency>
    <groupId>com.jetose</groupId>
    <artifactId>swagger-spring-boot-starter</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```

## 配置说明
```
swagger: 
    enable: true        //是否启用
    title: xxx          //项目名称
    description: xxx    //描述信息
    version: xxx        //版本编号
    contact:            //联络方式
        name: xxx       //人员名称
        url: xxx        //联系地址
        email: xxx      //电子邮件
    basePackage: xxx    //解析路径
```

## 技术选型
### 后端技术
- spring-boot -- 微型架构，[http://projects.spring.io/spring-boot](http://projects.spring.io/spring-boot)
- lombok -- 消除冗长，[https://projectlombok.org](https://projectlombok.org)
- swagger2 -- 文档服务，[http://springfox.github.io/springfox](http://springfox.github.io/springfox)

## 规范约定
- configuration类 -- 配置类，需要在名为configuration的包下，并以Configuration结尾，如SwaggerConfiguration、SwaggerAutoConfiguration
- properties类 -- 配置类，需要在名为properties的包下，并以Properties结尾，如SwaggerProperties

## 开发进度
- v1.0-SNAPSHOT -- 完成以spring-boot-starter为核心，整合restful风格的web服务框架swagger基础功能

## 附件
### 在线文档
- [spring-boot](https://docs.spring.io/spring-boot/docs/2.0.4.RELEASE/reference/htmlsingle)
- [lombok](http://jnb.ociweb.com/jnb/jnbJan2010.html)
- [swagger2](http://springfox.github.io/springfox/docs/current)