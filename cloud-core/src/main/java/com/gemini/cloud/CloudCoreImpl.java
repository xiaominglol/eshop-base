package com.gemini.cloud;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class CloudCoreImpl implements CloudCore{

    static Logger LOG = LoggerFactory.getLogger(CloudCoreImpl.class);

    @Override
    public Class<?> run(Class<?> klass, String[] args) throws CloudCoreException {
        return this.run(klass.getName(), klass.getName() + "Proxy", args);
    }

    @Override
    public Class<?> run(String launchClass, String packageClass, String[] args) throws CloudCoreException {
        LOG.info("Start Uepay Framework. Current Configuration file: classpath:config/uepay-**.yml");

        packageClass = packageClass + (Math.abs(new Random().nextInt()) % 1000);

        Dto2<Class<?>, Properties> dto = this.buildProxyClass(launchClass, packageClass, args);

        SpringApplication app = new SpringApplication(dto.getFirst());
        app.setDefaultProperties(dto.getSecond());
        app.setBannerMode(Banner.Mode.OFF);
        ctx = app.run(args);
        return proxyClass;
    }
}
