package com.gemini.boot.framework.mybatis.dto;

import lombok.Data;

@Data
public class BaseDto {

    /**
     * 升序排序字段
     */
    String ascs;

    /**
     * 降序排序字段
     */
    String descs;

}
