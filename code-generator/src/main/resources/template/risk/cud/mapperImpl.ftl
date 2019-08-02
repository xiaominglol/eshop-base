<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.gemini.portal.module.sys.mapper.${table.className}Mapper">

    <resultMap id="resultMap" type="com.gemini.portal.module.sys.po.${table.className}Po">
        <#list table.columns as column>
            <#if column.name == 'id'>
        <id column="${column.name}" property="${column.mappingName}" javaType="${column.mappingType}"/>
            <#elseif column.mappingType == 'BigDecimal'>
        <result column="${column.name}" property="${column.mappingName}" javaType="java.math.BigDecimal"/>
            <#else>
        <result column="${column.name}" property="${column.mappingName}" javaType="${column.mappingType}"/>
            </#if>
        </#list>
    </resultMap>

</mapper>