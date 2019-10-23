package com.uepay.corebusiness.risk.console.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.uepay.corebusiness.risk.base.po.BasePo;
import lombok.Data;
<#list table.columns as column>
    <#if column.javaType != column.javaFullType>

        import ${column.javaFullType}
    </#if>
</#list>

/**
 * ${table.title}
 */
@Data
@TableName("${table.tableName}")
public class ${table.className}Po extends BasePo {
<#list table.columns as column>
    <#if column.javaName != 'id'>

    /**
        * <#if column.comment??>${column.comment}</#if>
     */
        private ${column.javaType} ${column.javaName};
    </#if>
</#list>
}