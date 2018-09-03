package com.github.jetose.druid.spring.boot.starter.configuration;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.util.StringUtils;

public class DruidDataSourceWrapper extends DruidDataSource implements InitializingBean {

    @Autowired
    private DataSourceProperties dataSourceProperties;

    @Override
    public void afterPropertiesSet() throws Exception {
        if (StringUtils.isEmpty(super.getUsername())) {
            super.setUsername(dataSourceProperties.determineUsername());
        }
        if (StringUtils.isEmpty(super.getPassword())) {
            super.setPassword(dataSourceProperties.determinePassword());
        }
        if (StringUtils.isEmpty(super.getUrl())) {
            super.setUrl(dataSourceProperties.determineUrl());
        }
        if (StringUtils.isEmpty(super.getDriverClassName())) {
            super.setDriverClassName(dataSourceProperties.determineDriverClassName());
        }
    }
}
