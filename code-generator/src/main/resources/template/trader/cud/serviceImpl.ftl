package com.uepay.corebusiness.risk.console.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.uepay.corebusiness.risk.console.po.${table.className}Po;
import com.uepay.corebusiness.risk.console.mapper.${table.className}Mapper;
import com.uepay.corebusiness.risk.console.po.${table.className}Vo;
import com.uepay.corebusiness.risk.console.service.${table.className}Service;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * ${table.title}
 * @author ${table.author}
 */
@Service
public class ${table.className}ServiceImpl extends CrudServiceImpl<${table.className}Vo, ${table.className}Po, ${table.className}Mapper> implements ${table.className}Service {

    @Override
    protected QueryWrapper<${table.className}Po> getWrapper(${table.className}Vo vo) {
        return super.getWrapper(vo)
            <#assign field>
                <#list table.columns as column>
                    <#if column.mappingName != 'id' &&  column.mappingName != 'modifyDate' && column.mappingName != 'modifyUser' && column.mappingName != 'modifyType' && column.mappingName != 'modifyAccessId'>
                .eq(!StringUtils.isEmpty(vo.get${column.mappingName?cap_first}()), "${column.name}", vo.get${column.mappingName?cap_first}())
                    </#if>
                </#list>
            </#assign>
${field?substring(0, field?last_index_of(")"))});
    }
}