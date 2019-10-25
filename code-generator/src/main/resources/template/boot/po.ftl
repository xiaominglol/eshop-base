package ${table.packageName}.${table.moduleName}.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.gemini.boot.framework.mybatis.po.BaseDetailPo;
import com.gemini.boot.framework.mybatis.po.BasePo;
import com.gemini.boot.framework.mybatis.po.BaseSubPo;
import lombok.Data;

<#list table.columns as column>
    <#if column.javaType != column.javaFullType>

        import ${column.javaFullType};
    </#if>
</#list>

/**
* ${table.tableComment}
*
* @author ${table.author}
* @date ${table.createDate}
*/
@Data
@TableName("${table.tableName}")
public class ${table.bigClassName}Po extends BaseDetailPo<${table.bigClassName}Po> {
<#list table.columns as column>
    <#if column.javaName != 'id'>

        /**
        * <#if column.comment??>${column.comment}</#if>
        */
        private ${column.javaType} ${column.javaName};
    </#if>
</#list>
}
