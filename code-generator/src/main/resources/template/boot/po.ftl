package com.gemini.business.${table.moduleName}.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.gemini.boot.framework.mybatis.po.BaseSubPo;
import lombok.Data;

<#list table.columns as column>
    <#if column.javaType != column.javaFullType>

        import ${column.javaFullType}
    </#if>
</#list>

/**
* ${table.tableComment}
*
* @author ${table.author}
* @date 2018-10-24
*/
@Data
@TableName("${table.tableName}")
public class ${table.bigClassName}Po extends BasePo {
<#list table.columns as column>
    <#if column.javaName != 'id'>

        /**
        * <#if column.comment??>${column.comment}</#if>
        */
        private ${column.javaType} ${column.javaName};
    </#if>
</#list>
}
