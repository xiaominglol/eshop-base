package com.gemini.boot.framework.mybatis.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 小明不读书
 * @data 2018-08-02
 */
@Configuration
public class MybatisPlusConfig {
    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    /**
     * SQL执行效率插件，用p6spy代替
     * 设置 dev test 环境开启
     */
//    @Bean
//    @Profile({"dev", "test"})
//    public PerformanceInterceptor performanceInterceptor() {
//        return new PerformanceInterceptor();
//    }

}