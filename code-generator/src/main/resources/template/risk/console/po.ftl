package com.uepay.corebusiness.risk.console.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.gemini.boot.framework.mybatis.po.BasePo;
import lombok.Data;
<#if table.hasBigDecimal??>

import java.math.BigDecimal;
</#if>

/**
 * ${table.title}
 * @author ${table.author}
 */
@Data
@TableName("${table.tableName}")
public class ${table.className}Po extends BasePo {
<#list table.columns as column>
    <#if column.mappingName != 'id'>

    /**
     * <#if column.mappingComment??>${column.mappingComment}</#if>
     */
    private ${column.mappingType} ${column.mappingName};
    </#if>
</#list>
}