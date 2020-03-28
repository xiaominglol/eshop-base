package com.gemini.code.generator.map;

import java.util.HashMap;
import java.util.Map;

public class JdbcTypeMap {

    public static final Map<String, String> JAVA_TYPE_MAP = new HashMap<>();

    public static final Map<String, String> JAVA_FULL_TYPE_MAP = new HashMap<>();

    static {
        JAVA_TYPE_MAP.put("char", "String");
        JAVA_TYPE_MAP.put("varchar", "String");
        JAVA_TYPE_MAP.put("longvarchar", "String");
        JAVA_TYPE_MAP.put("numeric", "BigDecimal");
        JAVA_TYPE_MAP.put("decimal", "BigDecimal");
        JAVA_TYPE_MAP.put("bit", "Boolean");
        JAVA_TYPE_MAP.put("boolean", "Boolean");
        JAVA_TYPE_MAP.put("tinyint", "Byte");
        JAVA_TYPE_MAP.put("smallint", "Short");
        JAVA_TYPE_MAP.put("int", "Integer");
        JAVA_TYPE_MAP.put("integer", "Integer");
        JAVA_TYPE_MAP.put("bigint", "Long");
        JAVA_TYPE_MAP.put("real", "Float");
        JAVA_TYPE_MAP.put("float", "Double");
        JAVA_TYPE_MAP.put("double", "Double");
        JAVA_TYPE_MAP.put("binary", "Byte[]");
        JAVA_TYPE_MAP.put("varbinary", "Byte[]");
        JAVA_TYPE_MAP.put("longvarbinary", "Byte[]");
        JAVA_TYPE_MAP.put("date", "Date");
        JAVA_TYPE_MAP.put("time", "Date");
        JAVA_TYPE_MAP.put("datetime", "Date");
        JAVA_TYPE_MAP.put("timestamp", "Date");
        JAVA_TYPE_MAP.put("clob", "Clob");
        JAVA_TYPE_MAP.put("blob", "Blob");
        JAVA_TYPE_MAP.put("array", "Array");
        JAVA_TYPE_MAP.put("struct", "Struct");
        JAVA_TYPE_MAP.put("ref", "Ref");
        JAVA_TYPE_MAP.put("datalink", "URL");
        JAVA_TYPE_MAP.put("longtext", "String");
        JAVA_TYPE_MAP.put("text", "String");

        JAVA_FULL_TYPE_MAP.put("char", "String");
        JAVA_FULL_TYPE_MAP.put("varchar", "String");
        JAVA_FULL_TYPE_MAP.put("longvarchar", "String");
        JAVA_FULL_TYPE_MAP.put("numeric", "java.math.BigDecimal");
        JAVA_FULL_TYPE_MAP.put("decimal", "java.math.BigDecimal");
        JAVA_FULL_TYPE_MAP.put("bit", "Boolean");
        JAVA_FULL_TYPE_MAP.put("boolean", "Boolean");
        JAVA_FULL_TYPE_MAP.put("tinyint", "Byte");
        JAVA_FULL_TYPE_MAP.put("smallint", "Short");
        JAVA_FULL_TYPE_MAP.put("int", "Integer");
        JAVA_FULL_TYPE_MAP.put("integer", "Integer");
        JAVA_FULL_TYPE_MAP.put("bigint", "Long");
        JAVA_FULL_TYPE_MAP.put("real", "Float");
        JAVA_FULL_TYPE_MAP.put("float", "Double");
        JAVA_FULL_TYPE_MAP.put("double", "Double");
        JAVA_FULL_TYPE_MAP.put("binary", "Byte[]");
        JAVA_FULL_TYPE_MAP.put("varbinary", "Byte[]");
        JAVA_FULL_TYPE_MAP.put("longvarbinary", "Byte[]");
        JAVA_FULL_TYPE_MAP.put("date", "java.util.Date");
        JAVA_FULL_TYPE_MAP.put("time", "java.util.Date");
        JAVA_FULL_TYPE_MAP.put("datetime", "java.util.Date");
        JAVA_FULL_TYPE_MAP.put("timestamp", "java.util.Date");
        JAVA_FULL_TYPE_MAP.put("clob", "Clob");
        JAVA_FULL_TYPE_MAP.put("blob", "Blob");
        JAVA_FULL_TYPE_MAP.put("array", "Array");
        JAVA_FULL_TYPE_MAP.put("struct", "Struct");
        JAVA_FULL_TYPE_MAP.put("ref", "Ref");
        JAVA_FULL_TYPE_MAP.put("datalink", "java.net.URL");
        JAVA_FULL_TYPE_MAP.put("longtext", "String");
        JAVA_FULL_TYPE_MAP.put("text", "String");
    }
}
