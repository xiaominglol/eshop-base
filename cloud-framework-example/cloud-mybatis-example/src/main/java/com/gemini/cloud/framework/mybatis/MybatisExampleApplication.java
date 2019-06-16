package com.gemini.cloud.framework.mybatis;

import com.gemini.cloud.framework.core.CoreApplication;
import com.gemini.cloud.framework.core.exception.CloudCoreException;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.gemini.cloud.framework")
@EnableEurekaClient
@SpringBootApplication
public class MybatisExampleApplication {
    public static void main(String[] args) throws CloudCoreException {
        CoreApplication.run(MybatisExampleApplication.class, args);
    }
}
