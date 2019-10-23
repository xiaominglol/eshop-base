package com.gemini.business.${table.moduleName}.service;

import com.gemini.business.common.service.BaseDetailService;
import com.gemini.business.${table.moduleName}.mapper.${table.bigClassName}Mapper;
import com.gemini.business.${table.moduleName}.po.${table.bigClassName}Po;

/**
* ${table.tableComment}
*
* @author ${table.author}
* @date 2018-10-24
*/
public interface ${table.bigClassName}Service extends BaseDetailService<${table.bigClassName}Po, ${table.bigClassName}Po, ${table.bigClassName}Mapper, ${table.bigClassName}Mapper> {
}