package com.gemini.cloud.framework.gateway;

import com.gemini.boot.framework.core.CoreApplication;
import com.gemini.boot.framework.core.exception.CloudCoreException;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Gateway服务网关
 * @author 小明不读书
 * @date 2019-06-26
 */

@EnableDiscoveryClient
@SpringBootApplication
public class GatewayApplication {
	public static void main(String[] args) throws CloudCoreException {
		CoreApplication.run(GatewayApplication.class, args);
	}
}
