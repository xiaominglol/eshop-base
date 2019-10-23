package com.uepay.corebusiness.trader.query.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.uepay.corebusiness.trader.query.facade.dto.${table.className}Dto;
import com.uepay.corebusiness.trader.query.mapper.${table.className}Mapper;
import com.uepay.corebusiness.trader.query.po.${table.className}Po;
import com.uepay.corebusiness.trader.query.service.${table.className}Service;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * ${table.title}
 * @author ${table.author}
 */
@Service
public class ${table.className}ServiceImpl extends BaseServiceImpl
<${table.className}Dto, ${table.className}Po, ${table.className}Mapper> implements ${table.className}Service {

    @Override
    protected QueryWrapper<${table.className}Po> getWrapper(${table.className}Dto dto) {
        return super.getWrapper(dto)
            <#assign field>
                <#list table.columns as column>
                    <#if column.javaName != 'id' &&  column.javaName != 'modifyDate' && column.javaName != 'modifyUser' && column.javaName != 'modifyType' && column.javaName != 'modifyAccessId'>
                        .eq(!StringUtils.isEmpty(dto.get${column.javaName?cap_first}()), "${column.name}", dto.get${column.javaName?cap_first}())
                    </#if>
                </#list>
            </#assign>
${field?substring(0, field?last_index_of(")"))});
    }
}