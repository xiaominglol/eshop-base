package com.uepay.corebusiness.trader.query.po;

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
    <#if column.javaName != 'id' &&  column.javaName != 'modifyDate' && column.javaName != 'modifyUser' && column.javaName != 'modifyType' && column.javaName != 'modifyAccessId'>

    /**
        * <#if column.comment??>${column.comment}</#if>
     */
        private ${column.javaType} ${column.javaName};
    </#if>
</#list>
}