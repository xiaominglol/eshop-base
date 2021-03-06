package com.gemini.cloud.framework.admin;

import com.gemini.boot.framework.core.CoreApplication;
import com.gemini.boot.framework.core.exception.CoreException;
import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Admin服务
 *
 * @author 小明不读书
 * @date 2019-06-22
 */
@EnableAdminServer
@EnableDiscoveryClient
@SpringBootApplication
public class AdminApplication {

    public static void main(String[] args) throws CoreException {
        CoreApplication.run(AdminApplication.class, args);
    }

}
