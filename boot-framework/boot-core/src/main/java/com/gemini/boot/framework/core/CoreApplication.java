package com.gemini.boot.framework.core;

import com.gemini.boot.framework.core.config.ConfigPropertiesResolver;
import com.gemini.boot.framework.core.config.impl.ConfigPropertiesResolverImpl;
import com.gemini.boot.framework.core.exception.CoreException;
import com.gemini.boot.framework.core.resources.ResourceLoaderResolver;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Properties;

public class CoreApplication {

    public static ConfigurableApplicationContext run(Class<?> primarySources,
                                                     String[] args) throws CoreException {

        SpringApplication springApplication = new SpringApplication(primarySources);
        springApplication.setDefaultProperties(CoreApplication.getDefaultProperties());
        springApplication.setBannerMode(Banner.Mode.OFF);
        return springApplication.run(args);
    }

    public static Properties getDefaultProperties() throws CoreException {

        Properties props = new Properties();
        // 1. 扫描默认yml配置
        ResourceLoaderResolver resolver;
        try {
            resolver = ResourceLoaderResolver.build();
        } catch (CoreException e) {
            throw new CoreException("启动失败", e);
        }

        // 2. 添加扫描默认yml配置
        ConfigPropertiesResolver configProperties = new ConfigPropertiesResolverImpl();
        try {
            props.putAll(configProperties.buildProperties(resolver.getConfigResources()));
        } catch (CoreException e) {
            throw new CoreException("启动失败", e);
        }
        return props;
    }
}
