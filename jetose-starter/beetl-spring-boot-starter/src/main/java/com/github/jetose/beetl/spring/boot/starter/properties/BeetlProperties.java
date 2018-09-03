package com.github.jetose.beetl.spring.boot.starter.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(BeetlProperties.prefix)
public class BeetlProperties {

    public static final String prefix = "beetl";

    /**
     * 是否启用
     */
    private boolean enable;

    /**
     * 模板根目录
     */
    private String templatesPath;

    /**
     * 模板后缀
     */
    private String suffix;

}
