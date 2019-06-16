package com.gemini.cloud.framework.redis.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gemini.cloud.framework.redis.mapper.MemberMapper;
import com.gemini.cloud.framework.redis.service.MemberService;
import com.gemini.cloud.framework.redis.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Cacheable("member")
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberMapper memberMapper;

    @Autowired
    RedisUtil redisUtil;

    @Override
    public List<Object> list() {
        List<Object> list;
        if(redisUtil.lGet("member",0,1).size() == 0){
            QueryWrapper qw = new QueryWrapper();
            list = memberMapper.selectList(qw);
            redisUtil.lSet("member",list);
        }else{
            list = redisUtil.lGet("member",0,1);
        }
        List<Object> memberList = list;
        return memberList;
    }
}
