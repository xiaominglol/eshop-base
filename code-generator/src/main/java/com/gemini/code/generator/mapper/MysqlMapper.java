package com.gemini.code.generator.mapper;

import com.gemini.code.generator.domain.Column;
import com.gemini.code.generator.domain.DataBase;
import com.gemini.code.generator.domain.Table;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MysqlMapper {

    List<DataBase> getTable(@Param("dataBaseName") String dataBaseName);

    List<Column> getColumn(Table table);

}
