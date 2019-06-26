package com.gemini.cloud.framework.core;

import com.gemini.cloud.framework.core.exception.CloudCoreException;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.gemini.cloud.framework")
@EnableEurekaClient
@SpringBootApplication
public class WebfluxExampleApplication {
    public static void main(String[] args) throws CloudCoreException {
        CoreApplication.run(WebfluxExampleApplication.class, args);
    }
}
