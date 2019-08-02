package com.uepay.corebusiness.risk.code.generator.domain;

import lombok.Data;

@Data
public class Column {

    private String name;// 字段名稱
    private String type;// 字段類型
    private String comment;// 字段描述

    private String mappingName;// 映射字段名稱(java)
    private String mappingType;// 映射字段類型(java)
    private String mappingComment;// 映射字段描述(java)

    private String tableName;// 表名
    private String schemaName;// 庫名

    private String inputType;// 表單屬性類型

}
