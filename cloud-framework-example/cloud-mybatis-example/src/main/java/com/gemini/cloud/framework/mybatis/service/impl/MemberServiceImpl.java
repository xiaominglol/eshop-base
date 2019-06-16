package com.gemini.cloud.framework.mybatis.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gemini.cloud.framework.mybatis.mapper.MemberMapper;
import com.gemini.cloud.framework.mybatis.moder.Member;
import com.gemini.cloud.framework.mybatis.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberMapper memberMapper;

    @Override
    public List<Member> list() {
        QueryWrapper qw = new QueryWrapper();
        return memberMapper.selectList(qw);
    }
}
