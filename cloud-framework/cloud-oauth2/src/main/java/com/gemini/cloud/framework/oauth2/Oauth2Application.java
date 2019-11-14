package com.gemini.cloud.framework.oauth2;

import com.gemini.boot.framework.core.CoreApplication;
import com.gemini.boot.framework.core.exception.CoreException;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@EnableOAuth2Sso
@EnableResourceServer
@EnableDiscoveryClient
@SpringBootApplication
public class Oauth2Application {
    @RequestMapping("/")
    String home() {
        return "Hello World";
    }
	public static void main(String[] args) throws CoreException {
		CoreApplication.run(Oauth2Application.class, args);
	}
}
