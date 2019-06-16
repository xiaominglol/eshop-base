package com.gemini.cloud.framework.mybatis.moder;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@TableName("t_member")
public class Member {

    @TableId(value = "member_id")
    private Long memberId;

    private String memberName;
}
