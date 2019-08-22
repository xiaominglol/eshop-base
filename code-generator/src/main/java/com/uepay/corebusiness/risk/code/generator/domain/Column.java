package com.uepay.corebusiness.risk.code.generator.domain;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getMappingName() {
        return mappingName;
    }

    public void setMappingName(String mappingName) {
        this.mappingName = mappingName;
    }

    public String getMappingType() {
        return mappingType;
    }

    public void setMappingType(String mappingType) {
        this.mappingType = mappingType;
    }

    public String getMappingComment() {
        return mappingComment;
    }

    public void setMappingComment(String mappingComment) {
        this.mappingComment = mappingComment;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getSchemaName() {
        return schemaName;
    }

    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName;
    }

    public String getInputType() {
        return inputType;
    }

    public void setInputType(String inputType) {
        this.inputType = inputType;
    }
}
