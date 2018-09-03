# druid-spring-boot-starter
集合druid - jdbc连接池、监控组件

## 访问地址
```
http://ip:port/druid
```

## 使用指南
- 加入jar包
```
<dependency>
    <groupId>com.github.jetose</groupId>
    <artifactId>druid-spring-boot-starter</artifactId>
    <version>1.0.0.SNAPSHOT</version>
</dependency>
```
- 依赖jar包
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-jdbc</artifactId>
    <version>2.0.4.RELEASE</version>
</dependency>
```

## 配置说明
```
druid: 
    stat-view-servlet:      -- 统计信息
        enable: true     -- 是否启用
        urlPattern: /druid/*     -- 匹配规则
        allow: 127.0.0.1     -- 白名单
        deny: 192.168.1.102     -- 黑名单
        loginUsername: jetose     -- 登录用户
        loginPassword: 123456     -- 登录密码
        resetEnable: true     -- 是否允许清空统计数据
    web-stat-filter:     -- 监控信息
        enable: true     -- 是否启用
        urlPattern: /*     -- 匹配规则
        exclusions: *.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*     -- 排除规则
```

## 规范约定
- configuration类 -- 配置类，需要在名为configuration的包下，并以Configuration结尾，如DruidDataSourceAutoConfiguration
- properties类 -- 配置文件类，需要在名为properties的包下，并以Properties结尾，如DruidProperties

## 开发进度
- v1.0.0.SNAPSHOT -- 集成jdbc连接池、监控组件druid基础功能

## 附件
### 在线文档
- [spring-boot](https://docs.spring.io/spring-boot/docs/2.0.4.RELEASE/reference/htmlsingle)
- [lombok](http://jnb.ociweb.com/jnb/jnbJan2010.html)
- [druid](https://github.com/alibaba/druid/wiki)