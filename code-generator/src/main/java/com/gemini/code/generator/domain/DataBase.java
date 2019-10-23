package com.gemini.code.generator.domain;

import lombok.Data;

@Data
public class DataBase {
    /**
     * 表名称
     */
    private String tableName;
    /**
     * 表注释
     */
    private String tableComment;
}
