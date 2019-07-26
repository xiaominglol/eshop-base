package com.gemini.cloud.framework.turbine;

import com.gemini.cloud.framework.web.CoreApplication;
import com.gemini.cloud.framework.web.exception.CloudCoreException;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 测试发觉 不用@EnableEurekaClient注解也可以正常使用
 */
@Controller
@EnableTurbine
@EnableHystrixDashboard
@EnableEurekaClient
@SpringBootApplication
public class TurbineApplication {
	/**
	 * @return	监控中心控制台的首页
	 */
	@RequestMapping("/")
	public String index(){
		return "forward:/hystrix";
	}
	public static void main(String[] args) throws CloudCoreException {
		CoreApplication.run(TurbineApplication.class, args);
	}
}
