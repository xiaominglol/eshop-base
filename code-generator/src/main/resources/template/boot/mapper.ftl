package com.gemini.business.${table.moduleName}.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gemini.business.${table.moduleName}.po.${table.bigClassName}Po;
import org.apache.ibatis.annotations.Mapper;

/**
 * ${table.tableComment}
 *
 * @author ${table.author}
 * @date 2018-10-24
 */
@Mapper
public interface ${table.bigClassName}Mapper extends BaseMapper<${table.bigClassName}Po> {
}
