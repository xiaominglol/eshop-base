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
public class ${table.className}ServiceImpl extends BaseServiceImpl
<${table.className}Vo, ${table.className}Po, ${table.className}Mapper> implements ${table.className}Service {

    @Override
    protected QueryWrapper<${table.className}Po> getWrapper(${table.className}Vo vo) {
        return super.getWrapper(vo)
            <#assign field>
                <#list table.columns as column>
                    <#if column.javaName != 'id' &&  column.javaName != 'modifyDate' && column.javaName != 'modifyUser' && column.javaName != 'modifyType' && column.javaName != 'modifyAccessId'>
                        .eq(!StringUtils.isEmpty(vo.get${column.javaName?cap_first}()), "${column.name}", vo.get${column.javaName?cap_first}())
                    </#if>
                </#list>
            </#assign>
${field?substring(0, field?last_index_of(")"))});
    }
}