package com.uepay.corebusiness.risk.console.vo;

import com.uepay.corebusiness.risk.base.dict.Dicts;
import com.gemini.boot.framework.mybatis.vo.BaseVo;
import com.uepay.framework.normalize.Dict;
import lombok.Data;
<#if table.hasBigDecimal??>

import java.math.BigDecimal;
</#if>

/**
 * ${table.title}
 * @author ${table.author}
 */
@Data
public class ${table.className}Vo extends BaseVo {
<#list table.columns as column>

    /**
     * <#if column.mappingComment??>${column.mappingComment}</#if>
     */
    private ${column.mappingType} ${column.mappingName};
</#list>
<#list table.dicts as dict>

    public void set${dict.n?cap_first}Id(Long id) {
        Dict dict = Dicts.get(id);
        ${dict.n}Id = id;
        ${dict.n}Code = dict.getCode();
        ${dict.n}NameCn = dict.getNameCn();
        ${dict.n}NameEn = dict.getNameEn();
    }
</#list>
}