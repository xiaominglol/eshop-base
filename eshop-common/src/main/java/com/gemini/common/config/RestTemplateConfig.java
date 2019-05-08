package com.gemini.common.config;//package com.gemini.common.config;
//
//import com.netflix.loadbalancer.IRule;
//import com.netflix.loadbalancer.RoundRobinRule;
//import org.springframework.cloud.client.loadbalancer.LoadBalanced;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.client.RestTemplate;
//
//@Configuration
//public class RestTemplateConfig {
//    @Bean
//    @LoadBalanced
//    public RestTemplate getRestTemplate() {
//        return new RestTemplate();
//    }
//
//    @Bean
//    public IRule ribbonRule() {
//        return new RoundRobinRule();
//    }
//}
