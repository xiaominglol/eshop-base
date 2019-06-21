package com.gemini.cloud.framework.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * HystrixDashboard监控
 * @author 小明不读书
 * @date 2019-03-22
 */
@Controller
@EnableHystrixDashboard
@SpringBootApplication
public class GatewayApplication {
	/**
	 * @return	监控中心控制台的首页
	 */
	@RequestMapping("/")
	public String index(){
		return "forward:/hystrix";
	}
	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}
}
