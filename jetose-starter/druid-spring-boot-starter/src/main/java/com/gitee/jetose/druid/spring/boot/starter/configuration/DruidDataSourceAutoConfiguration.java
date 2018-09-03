package com.gitee.jetose.druid.spring.boot.starter.configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.gitee.jetose.druid.spring.boot.starter.properties.DruidProperties;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.sql.DataSource;

@Configuration
@ConditionalOnClass(DruidDataSource.class)
@AutoConfigureBefore(DataSourceAutoConfiguration.class)
@EnableConfigurationProperties({
        DruidProperties.class,
        DataSourceProperties.class
})
@Import({
        DruidStatViewServletAutoConfiguration.class,
        DruidWebStatFilterAutoConfiguration.class
})
public class DruidDataSourceAutoConfiguration  {

    @Bean(initMethod = "init")
    @ConditionalOnMissingBean
    public DataSource dataSource() {
        return new DruidDataSourceWrapper();
    }

}
