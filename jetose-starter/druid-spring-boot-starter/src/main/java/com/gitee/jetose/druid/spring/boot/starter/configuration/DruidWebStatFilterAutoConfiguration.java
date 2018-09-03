package com.github.jetose.druid.spring.boot.starter.configuration;

import com.alibaba.druid.support.http.WebStatFilter;
import com.github.jetose.druid.spring.boot.starter.properties.DruidProperties;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.util.StringUtils;

@ConditionalOnWebApplication
@ConditionalOnProperty(name = "druid.web-stat-filter.enable", matchIfMissing = true)
public class DruidWebStatFilterAutoConfiguration {

    @Bean
    public FilterRegistrationBean getDruidStatFilter(DruidProperties druidProperties) {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new WebStatFilter());
        DruidProperties.WebStatFilter webStatFilter = druidProperties.getWebStatFilter();
        if (!StringUtils.isEmpty(webStatFilter.getUrlPattern())) {
            filterRegistrationBean.addUrlPatterns(webStatFilter.getUrlPattern());
        } else {
            filterRegistrationBean.addUrlPatterns("/*");
        }
        if (!StringUtils.isEmpty(webStatFilter.getExclusions())) {
            filterRegistrationBean.addInitParameter("exclusions", webStatFilter.getExclusions());
        } else {
            filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*");
        }
        return filterRegistrationBean;
    }
}
