package ${table.packageName}.${table.moduleName}.service;

import ${table.packageName}.common.service.BaseDetailService;
import ${table.packageName}.${table.moduleName}.mapper.${table.bigClassName}Mapper;
import ${table.packageName}.${table.moduleName}.po.${table.bigClassName}Po;

/**
* ${table.tableComment}
*
* @author ${table.author}
* @date ${table.createDate}
*/
public interface ${table.bigClassName}Service extends BaseDetailService<${table.bigClassName}Po, ${table.bigClassName}Po, ${table.bigClassName}Mapper, ${table.bigClassName}Mapper> {
}