<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${table.packageName}.${table.moduleName}.mapper.${table.bigClassName}Mapper">

    <resultMap id="resultMap" type="${table.packageName}.${table.moduleName}.po.${table.bigClassName}Po">
        <#list table.columns as column>
            <#if column.name == 'id'>
                <id column="${column.name}" property="${column.javaName}" javaType="${column.javaFullType}"/>
            <#else>
                <result column="${column.name}" property="${column.javaName}" javaType="${column.javaFullType}"/>
            </#if>
        </#list>
    </resultMap>

    <sql id="fields">
        <#assign field>
            <#list table.columns as column>
                <#if column.javaName != 'id'>
                    ${table.tableAlias}.${column.name},
                </#if>
            </#list>
        </#assign>
        ${field?substring(0, field?last_index_of(","))}
    </sql>

    <sql id="table">
        d_l_risk_dict ${table.tableAlias}
    </sql>

    <sql id="where">
        <where>
            <#list table.columns as column>
                <#if column.name != 'id'>
                    <if test="${column.javaName} != null and ${column.javaName} != ''">
                        and ${table.tableAlias}.${column.name} = ${"#"}{${column.javaName}}
                    </if>
                </#if>
            </#list>
        </where>
    </sql>

    <sql id="order">
        <if test="(ascs != null ascs != '') or (descs != null descs != '')">
            order by
            <if test="ascs != null and ascs != ''">
                ${"$"}{ascs} asc
            </if>
            <if test="descs != null and descs != ''">
                ${"$"}{descs} desc
            </if>
        </if>
    </sql>


</mapper>