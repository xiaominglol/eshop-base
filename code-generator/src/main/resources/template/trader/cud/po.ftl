package com.uepay.corebusiness.risk.console.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * ${table.title}
 * @author ${table.author}
 */
@Data
@TableName("${table.tableName}")
public class ${table.className}Po extends BasePo {
<#list table.columns as column>
    <#if column.mappingName != 'id' &&  column.mappingName != 'modifyDate' && column.mappingName != 'modifyUser' && column.mappingName != 'modifyType' && column.mappingName != 'modifyAccessId'>

    /**
     * <#if column.mappingComment??>${column.mappingComment}</#if>
     */
    private ${column.mappingType} ${column.mappingName};
    </#if>
</#list>
}