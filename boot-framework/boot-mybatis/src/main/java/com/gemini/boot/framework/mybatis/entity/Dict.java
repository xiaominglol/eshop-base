package com.gemini.boot.framework.mybatis.entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Dict {
    private Long id;
    private String code;
    private String name;
}