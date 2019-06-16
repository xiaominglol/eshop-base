package com.gemini.cloud.framework.core;

import com.gemini.cloud.framework.web.mvc.model.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("test")
    public Message test() {
        Test test = new Test();
        return Message.success(test);
    }
}
