package com.gemini.cloud.framework.web;

import com.gemini.cloud.framework.web.exception.CloudCoreException;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.gemini.cloud.framework")
@EnableEurekaClient
@SpringBootApplication
public class CoreExampleApplication {
    public static void main(String[] args) throws CloudCoreException {
        CoreApplication.run(CoreExampleApplication.class, args);
    }
}
