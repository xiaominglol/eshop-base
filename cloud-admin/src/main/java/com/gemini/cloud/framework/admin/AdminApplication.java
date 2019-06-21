package com.gemini.cloud.framework.admin;

import com.gemini.cloud.framework.core.CoreApplication;
import com.gemini.cloud.framework.core.exception.CloudCoreException;
import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableAdminServer
@EnableEurekaClient
@SpringBootApplication
public class AdminApplication {

    public static void main(String[] args) throws CloudCoreException {
        CoreApplication.run(AdminApplication.class, args);
    }

}
