package com.uepay.corebusiness.risk.api.facade.dto;

import com.gemini.boot.framework.mybatis.dto.BaseDto;
import lombok.Data;
<#if table.hasBigDecimal??>

import java.math.BigDecimal;
</#if>

/**
 * ${table.title}
 * @author ${table.author}
 */
@Data
public class ${table.className}Dto extends BaseDto {
<#list table.columns as column>

    /**
     * <#if column.mappingComment??>${column.mappingComment}</#if>
     */
    private ${column.mappingType} ${column.mappingName};
</#list>
}
