package ${table.packageName}.${table.moduleName}.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import ${table.packageName}.${table.moduleName}.po.${table.bigClassName}Po;
import org.apache.ibatis.annotations.Mapper;

/**
* ${table.tableComment}
*
* @author ${table.author}
* @date ${table.createDate}
*/
@Mapper
public interface ${table.bigClassName}Mapper extends BaseMapper<${table.bigClassName}Po> {
}
