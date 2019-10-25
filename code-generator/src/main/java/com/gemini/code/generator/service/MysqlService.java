package com.gemini.code.generator.service;

import com.gemini.code.generator.domain.Column;
import com.gemini.code.generator.domain.DataBase;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MysqlService {
    /**
     * 通过数据库名称获取该数据库的表和表注释
     *
     * @param dataBaseName
     * @return
     */
    List<DataBase> getTable(@Param("dataBaseName") String dataBaseName);

    /**
     * 通过表名称获取表字段
     *
     * @param tableName
     * @return
     */
    List<Column> getColumn(@Param("tableName") String tableName);
}
