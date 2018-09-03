package com.gitee.jetose.druid.spring.boot.starter.configuration;

import com.alibaba.druid.support.http.StatViewServlet;
import com.gitee.jetose.druid.spring.boot.starter.properties.DruidProperties;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.util.StringUtils;

@ConditionalOnWebApplication
@ConditionalOnProperty(name = "druid.stat-view-servlet.enabled", matchIfMissing = true)
public class DruidStatViewServletAutoConfiguration {

    @Bean
    public ServletRegistrationBean getDruidStatViewServlet(DruidProperties druidProperties) {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();
        servletRegistrationBean.setServlet(new StatViewServlet());
        DruidProperties.StatViewServlet statViewServlet = druidProperties.getStatViewServlet();
        if (!StringUtils.isEmpty(statViewServlet.getUrlPattern())) {
            servletRegistrationBean.addUrlMappings(statViewServlet.getUrlPattern());
        } else {
            servletRegistrationBean.addUrlMappings("/druid/*");
        }
        if (!StringUtils.isEmpty(statViewServlet.getAllow())) {
            servletRegistrationBean.addInitParameter("allow", statViewServlet.getAllow());
        }
        if (!StringUtils.isEmpty(statViewServlet.getDeny())) {
            servletRegistrationBean.addInitParameter("deny", statViewServlet.getDeny());
        }
        if (!StringUtils.isEmpty(statViewServlet.getLoginUsername())) {
            servletRegistrationBean.addInitParameter("loginUsername", statViewServlet.getLoginUsername());
        }
        if (!StringUtils.isEmpty(statViewServlet.getLoginPassword())) {
            servletRegistrationBean.addInitParameter("loginPassword", statViewServlet.getLoginPassword());
        }
        if (!StringUtils.isEmpty(statViewServlet.getResetEnable())) {
            servletRegistrationBean.addInitParameter("resetEnable", statViewServlet.getResetEnable());
        }
        return servletRegistrationBean;
    }

}
