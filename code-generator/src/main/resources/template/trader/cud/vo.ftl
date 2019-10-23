package com.uepay.corebusiness.risk.console.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * ${table.title}
 * @author ${table.author}
 */
@Setter
@Getter
@ToString
public class ${table.className}Vo extends BaseVo {
<#list table.columns as column>
    <#if column.javaName != 'id' &&  column.javaName != 'modifyDate' && column.javaName != 'modifyUser' && column.javaName != 'modifyType' && column.javaName != 'modifyAccessId'>

    /**
        * <#if column.comment??>${column.comment}</#if>
     */
        private ${column.javaType} ${column.javaName};
    </#if>
</#list>
}