package com.gemini.portal.module.sys.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gemini.boot.framework.mybatis.service.impl.CrudServiceImpl;
import com.gemini.portal.module.sys.dto.${table.className}Dto;
import com.gemini.portal.module.sys.mapper.${table.className}Mapper;
import com.gemini.portal.module.sys.po.${table.className}Po;
import com.gemini.portal.module.sys.service.${table.className}Service;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * ${table.title}
 * @author ${table.author}
 */
@Service
public class ${table.className}ServiceImpl extends CrudServiceImpl<${table.className}Dto, ${table.className}Po, ${table.className}Mapper> implements ${table.className}Service {

    @Override
    public QueryWrapper<${table.className}Po> wrapper(${table.className}Dto dto) {
        return super.wrapper(dto)
<#assign field>
    <#if table.isDetail??>
        <#list table.columns as column>
            <#if column.mappingName != 'id'>
                .eq(!StringUtils.isEmpty(dto.get${column.mappingName?cap_first}()), "${column.name}", dto.get${column.mappingName?cap_first}())
            </#if>
        </#list>
     </#if>
</#assign>
${field?substring(0, field?last_index_of(")"))});
    }
}
