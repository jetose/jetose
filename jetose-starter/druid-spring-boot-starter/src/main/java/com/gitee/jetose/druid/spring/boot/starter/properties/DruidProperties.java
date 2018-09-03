package com.github.jetose.druid.spring.boot.starter.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(DruidProperties.prefix)
public class DruidProperties {

    public static final String prefix = "druid";

    /**
     * 统计信息
     */
    private StatViewServlet statViewServlet = new StatViewServlet();

    /**
     * 监控信息
     */
    private WebStatFilter webStatFilter = new WebStatFilter();

    @Data
    public static class StatViewServlet {

        /**
         * 是否启用
         */
        private boolean enable = true;

        /**
         * 匹配规则
         */
        private String urlPattern;

        /**
         * 白名单
         */
        private String allow;

        /**
         * 黑名单
         */
        private String deny;

        /**
         * 登录用户
         */
        private String loginUsername;

        /**
         * 登录密码
         */
        private String loginPassword;

        /**
         * 是否允许清空统计数据
         */
        private String resetEnable;

    }

    @Data
    public static class WebStatFilter {

        /**
         * 是否启用
         */
        private boolean enabled = true;

        /**
         * 匹配规则
         */
        private String urlPattern;

        /**
         * 排除规则
         */
        private String exclusions;

    }

}
