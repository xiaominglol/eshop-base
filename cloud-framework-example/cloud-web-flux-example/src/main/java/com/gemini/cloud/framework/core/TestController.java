package com.gemini.cloud.framework.core;

import com.gemini.cloud.framework.web.mvc.model.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class TestController {
    @GetMapping("test")
    public Mono<Message> test() {
        Test test = new Test();
        return Mono.just(Message.success(test));
    }
}
