package com.gemini.cloud.framework.redis.controller;

import com.gemini.cloud.framework.redis.service.MemberService;
import com.gemini.cloud.framework.web.mvc.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MemberController {

    @Autowired
    MemberService memberService;

    @GetMapping("/member")
    public Message list() {
        List<Object> memberList = memberService.list();
        return Message.success(memberList);
    }
}
