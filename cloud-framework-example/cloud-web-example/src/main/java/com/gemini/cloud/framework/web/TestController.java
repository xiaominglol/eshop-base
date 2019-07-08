package com.gemini.cloud.framework.web;

import com.gemini.cloud.framework.web.mvc.model.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class TestController {
    @Value("${cloud.id}")
    private String cloudId;

    @Value("${cloud.name}")
    private String cloudName;

    @GetMapping("test")
    public Message test() {
        Test test = new Test();
        test.setCloudId(cloudId);
        test.setCloudName(cloudName);
        return Message.success(test);
    }

    @GetMapping("test1")
    public Mono<Message> test1() {
        Test test = new Test();
        return Mono.just(Message.success(test));
    }
}
