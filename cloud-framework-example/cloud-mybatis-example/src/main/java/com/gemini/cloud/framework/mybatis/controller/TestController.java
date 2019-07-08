package com.gemini.cloud.framework.mybatis.controller;

import com.gemini.cloud.framework.web.mvc.model.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Value("${cloud.id}")
    private String cloudId;

    @Value("${cloud.name}")
    private String cloudName;

    @GetMapping("/risk/onlineCheck.do")
    public String test(String param) {
        Test test = new Test();
        test.setCloudId(cloudId);
        test.setCloudName(cloudName);
        return "onlineCheck-1-"+param;
    }

    @GetMapping("/callBack/riskCallBack.do")
    public String test1(String param) {
        Test test = new Test();
        test.setCloudId(cloudId);
        test.setCloudName(cloudName);
        return "callback-1-"+param;
    }
}
