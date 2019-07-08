package com.gemini.cloud.framework.redis;

import com.gemini.cloud.framework.web.CoreApplication;
import com.gemini.cloud.framework.web.exception.CloudCoreException;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.gemini.cloud.framework")
@EnableEurekaClient
@SpringBootApplication
public class RedisExampleApplication {
    public static void main(String[] args) throws CloudCoreException {
        CoreApplication.run(RedisExampleApplication.class, args);
    }
}
