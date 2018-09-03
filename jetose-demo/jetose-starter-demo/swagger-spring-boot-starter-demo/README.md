# swagger-spring-boot-starter-demo
swagger-spring-boot-starter使用示例

## 访问地址
```
http://ip:port/swagger-ui.html
```

## 使用指南
- 加入jar包
```
<dependency>
    <groupId>com.gitee.jetose</groupId>
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
        url: https://gitee.com/jetose     -- 联系地址
        email: 159370716@qq.com     -- 电子邮件
    basePackage: com.gitee.jetose     -- 解析路径
```
