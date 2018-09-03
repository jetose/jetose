# swagger-spring-boot-starter
集成swagger - restful风格的web服务框架

## 访问地址
```
http://ip:port/swagger-ui.html
```

## 使用指南
- 加入jar包
```
<dependency>
    <groupId>com.github.jetose</groupId>
    <artifactId>swagger-spring-boot-starter</artifactId>
    <version>1.0.0.SNAPSHOT</version>
</dependency>
```

## 配置说明
```
swagger: 
    enable: true     -- 是否启用
    title: swagger-spring-boot-starter     -- 项目名称
    description: 整合swagger-restful风格的web服务框架     -- 描述信息
    version: 1.0.0.SNAPSHOT     -- 版本编号
    contact:      -- 联络方式
        name: jetose     -- 人员名称
        url: https://github.com/jetose     -- 联系地址
        email: 159370716@qq.com     -- 电子邮件
    basePackage: com.github.jetose     -- 解析路径
```

## 规范约定
- configuration类 -- 配置类，需要在名为configuration的包下，并以Configuration结尾，如SwaggerConfiguration
- properties类 -- 配置文件类，需要在名为properties的包下，并以Properties结尾，如SwaggerProperties

## 开发进度
- v1.0.0.SNAPSHOT -- 集成restful风格的web服务框架swagger基础功能

## 附件
### 在线文档
- [spring-boot](https://docs.spring.io/spring-boot/docs/2.0.4.RELEASE/reference/htmlsingle)
- [lombok](http://jnb.ociweb.com/jnb/jnbJan2010.html)
- [swagger](http://springfox.github.io/springfox/docs/current)