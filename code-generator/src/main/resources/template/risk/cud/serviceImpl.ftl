package com.uepay.corebusiness.risk.cud.service.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.uepay.corebusiness.risk.base.service.impl.BaseServiceImpl;
import com.uepay.corebusiness.risk.cud.facade.dto.${table.className}Dto;
import com.uepay.corebusiness.risk.cud.service.mapper.${table.className}Mapper;
import com.uepay.corebusiness.risk.cud.service.po.${table.className}Po;
import com.uepay.corebusiness.risk.cud.service.service.${table.className}Service;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * ${table.title}
 */
@Service
public class ${table.className}ServiceImpl extends BaseServiceImpl
<${table.className}Dto, ${table.className}Po, ${table.className}Mapper> implements ${table.className}Service {

    @Override
    public QueryWrapper<${table.className}Po> wrapper(${table.className}Dto dto) {
        return super.wrapper(dto)
<#assign field>
    <#if table.isDetail??>
        <#list table.columns as column>
            <#if column.javaName != 'id'>
                .eq(!StringUtils.isEmpty(dto.get${column.javaName?cap_first}()), "${column.name}", dto.get${column.javaName?cap_first}())
            </#if>
        </#list>
     </#if>
</#assign>
${field?substring(0, field?last_index_of(")"))});
    }
}
