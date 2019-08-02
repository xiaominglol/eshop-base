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
    <#if column.mappingName != 'id' &&  column.mappingName != 'modifyDate' && column.mappingName != 'modifyUser' && column.mappingName != 'modifyType' && column.mappingName != 'modifyAccessId'>

    /**
     * <#if column.mappingComment??>${column.mappingComment}</#if>
     */
    private ${column.mappingType} ${column.mappingName};
    </#if>
</#list>
}