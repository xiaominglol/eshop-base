package ${table.packageName}.${table.moduleName}.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gemini.boot.framework.mybatis.service.impl.BaseDetailServiceImpl;
import ${table.packageName}.${table.moduleName}.mapper.${table.bigClassName}Mapper;
import ${table.packageName}.${table.moduleName}.po.${table.bigClassName}Po;
import ${table.packageName}.${table.moduleName}.service.${table.bigClassName}Service;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
* ${table.tableComment}
*
* @author ${table.author}
* @date ${table.createDate}
*/
@Service
public class ${table.bigClassName}ServiceImpl extends BaseDetailServiceImpl<${table.bigClassName}Po, ${table.bigClassName}Po, ${table.bigClassName}Mapper, ${table.bigClassName}Mapper> implements ${table.bigClassName}Service {

    @Override
    public QueryWrapper<${table.bigClassName}Po> wrapper(${table.bigClassName}Po po) {
        return super.wrapper(po)
        <#assign field>
            <#if table.isDetail??>
                <#list table.columns as column>
                    <#if column.javaName != 'id'>
                        .eq(!StringUtils.isEmpty(po.get${column.javaName?cap_first}()), "${column.name}", po.get${column.javaName?cap_first}())
                    </#if>
                </#list>
            </#if>
        </#assign>
        ${field?substring(0, field?last_index_of(")"))});
    }
}
