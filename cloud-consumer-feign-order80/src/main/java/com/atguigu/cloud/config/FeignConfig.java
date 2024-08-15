package com.atguigu.cloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author hsj
 * @Description TODO
 * @Date 2024/7/16 14:53
 */
@Configuration
public class FeignConfig {

    @Bean
    public Logger.Level feignLoggerLevel() {
        /**
         * feign 日志级别 需要yml配置debug模式才能生效
         * NONE：默认的，不显示任何日志；
         * BASIC：仅记录请求方法、URL、响应状态码及执行时间；
         * HEADERS：除了 BASIC 中定义的信息之外，还有请求和响应的头信息；
         * FULL：除了 HEADERS 中定义的信息之外，还有请求和响应的正文及元数据。
         */
        return Logger.Level.FULL;
    }
}
