package com.gemini.cloud.framework.redis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gemini.cloud.framework.redis.moder.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper extends BaseMapper<Member> {

}
