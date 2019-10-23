package com.uepay.corebusiness.risk.console.vo;

import com.uepay.corebusiness.risk.base.dict.Dicts;
import com.uepay.corebusiness.risk.base.vo.BaseVo;
import com.uepay.framework.normalize.Dict;
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
public class ${table.className}Vo extends BaseVo {
<#list table.columns as column>

    /**
    * <#if column.comment??>${column.comment}</#if>
     */
    private ${column.javaType} ${column.javaName};
</#list>
<#if table.dicts??>

    /**
    * 初始化對象所有字典項的信息
    */
    public void initDicts() {
    <#list table.dicts as dict>
        Dict ${dict.n} = Dicts.get(get${dict.n?cap_first}Id());
        set${dict.n?cap_first}Code(${dict.n}.getCode());
        set${dict.n?cap_first}NameCn(${dict.n}.getNameCn());
        set${dict.n?cap_first}NameEn(${dict.n}.getNameEn());
    </#list>
    }
</#if>
}