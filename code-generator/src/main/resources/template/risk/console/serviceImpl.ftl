package com.uepay.corebusiness.risk.console.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.uepay.corebusiness.risk.base.service.impl.BaseServiceImpl;
import com.uepay.corebusiness.risk.console.mapper.${table.className}Mapper;
import com.uepay.corebusiness.risk.console.po.${table.className}Po;
import com.uepay.corebusiness.risk.console.service.${table.className}Service;
import com.uepay.corebusiness.risk.console.vo.${table.className}Vo;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * ${table.title}
 */
@Service
public class ${table.className}ServiceImpl extends BaseServiceImpl
<${table.className}Vo, ${table.className}Po, ${table.className}Mapper> implements ${table.className}Service {

    @Override
    public QueryWrapper<${table.className}Po> wrapper(${table.className}Vo vo) {
        return super.wrapper(vo)
<#assign field>
<#list table.columns as column>
    <#if column.javaName != 'id'>
        .eq(!StringUtils.isEmpty(vo.get${column.javaName?cap_first}()), "${column.name}", vo.get${column.javaName?cap_first}())
</#if>
</#list>
</#assign>
${field?substring(0, field?last_index_of(")"))});
    }
}