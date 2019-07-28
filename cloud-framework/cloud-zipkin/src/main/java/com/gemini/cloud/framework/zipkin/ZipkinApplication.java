package com.gemini.cloud.framework.zipkin;

import com.gemini.boot.framework.core.CoreApplication;
import com.gemini.boot.framework.core.exception.CloudCoreException;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import zipkin2.server.internal.EnableZipkinServer;

/**
 * sleuth-zipkin服务跟踪
 * @author 小明不读书
 * @date 2019-06-26
 */
@EnableZipkinServer
@EnableEurekaClient
@SpringBootApplication
public class ZipkinApplication {
	public static void main(String[] args) throws CloudCoreException {
		CoreApplication.run(ZipkinApplication.class, args);
	}
}

