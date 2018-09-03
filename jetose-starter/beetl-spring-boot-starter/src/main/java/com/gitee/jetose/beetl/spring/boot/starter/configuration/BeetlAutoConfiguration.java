package com.github.jetose.beetl.spring.boot.starter.configuration;

import com.github.jetose.beetl.spring.boot.starter.properties.BeetlProperties;
import org.beetl.core.resource.ClasspathResourceLoader;
import org.beetl.ext.spring.BeetlGroupUtilConfiguration;
import org.beetl.ext.spring.BeetlSpringViewResolver;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

@Configuration
@ConditionalOnWebApplication
@ConditionalOnProperty(name = "beetl.enable", matchIfMissing = true)
@EnableConfigurationProperties({
        BeetlProperties.class
})
public class BeetlAutoConfiguration {

    @Bean(initMethod = "init", name = "beetlConfig")
    public BeetlGroupUtilConfiguration getBeetlGroupUtilConfiguration(BeetlProperties beetlProperties) {
        BeetlGroupUtilConfiguration beetlGroupUtilConfiguration = new BeetlGroupUtilConfiguration();
        try {
            ClasspathResourceLoader classpathResourceLoader = new ClasspathResourceLoader(beetlProperties.getTemplatesPath());
            beetlGroupUtilConfiguration.setResourceLoader(classpathResourceLoader);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return beetlGroupUtilConfiguration;
    }

    @Bean(name = "beetlViewResolver")
    public BeetlSpringViewResolver getBeetlSpringViewResolver(BeetlProperties beetlProperties,
                                                              @Qualifier("beetlConfig") BeetlGroupUtilConfiguration beetlGroupUtilConfiguration) {
        BeetlSpringViewResolver beetlSpringViewResolver = new BeetlSpringViewResolver();
        beetlSpringViewResolver.setContentType("text/html;charset=UTF-8");
        if (!StringUtils.isEmpty(beetlProperties.getSuffix())) {
            beetlSpringViewResolver.setViewNames("*." + beetlProperties.getSuffix(), "*." + beetlProperties.getSuffix() + "#*");
        }
        beetlSpringViewResolver.setOrder(0);
        beetlSpringViewResolver.setConfig(beetlGroupUtilConfiguration);
        return beetlSpringViewResolver;
    }

}
