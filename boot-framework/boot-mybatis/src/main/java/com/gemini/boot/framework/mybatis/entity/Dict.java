package com.gemini.boot.framework.mybatis.entity;

import lombok.Data;

@Data
public class Dict {
    /**
     * 字典id
     */
    private Long id;
    /**
     * 字典编码
     */
    private String code;
    /**
     * 字典名称
     */
    private String name;
}