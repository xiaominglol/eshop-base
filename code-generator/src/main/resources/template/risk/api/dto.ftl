package com.uepay.corebusiness.risk.api.facade.dto;

import com.uepay.corebusiness.risk.base.dto.BaseDto;
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
public class ${table.className}Dto extends BaseDto {
<#list table.columns as column>

    /**
    * <#if column.comment??>${column.comment}</#if>
     */
    private ${column.javaType} ${column.javaName};
</#list>
}
