package com.gemini.code.generator.domain;

import com.gemini.code.generator.map.JdbcTypeMap;
import com.gemini.code.generator.utils.StringUtils;
import lombok.Data;

@Data
public class Column {

    public Column init() {
        name = name.toLowerCase();
        javaName = StringUtils.toCamelCase(name);
        javaType = JdbcTypeMap.JAVA_TYPE_MAP.get(type);
        javaFullType = JdbcTypeMap.JAVA_FULL_TYPE_MAP.get(type);

        if ("modifyUser".equals(javaName)) {
            comment = "修改人";
        } else if ("modifyDate".equals(javaName)) {
            comment = "修改日期";
        } else if ("modifyType".equals(javaName)) {
            comment = "修改類型";
        } else if ("modifyAccessId".equals(javaName)) {
            comment = "修改人訪問ID";
        }

        System.out.println(toString());
        return this;
    }

    /**
     * 庫名
     */
    private String schema;

    /**
     * 表名
     */
    private String table;

    /**
     * 字段名稱
     */
    private String name;

    /**
     * 字段類型
     */
    private String type;

    /**
     * 描述
     */
    private String comment;

    /**
     * 映射字段名稱(java)
     */
    private String javaName;

    /**
     * 映射字段類型(java)
     */
    private String javaType;

    /**
     * 映射字段類型全称(java)
     */
    private String javaFullType;

}
