package com.gemini.code.generator.service.impl;

import com.gemini.code.generator.domain.Column;
import com.gemini.code.generator.domain.DataBase;
import com.gemini.code.generator.mapper.MysqlMapper;
import com.gemini.code.generator.service.MysqlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MysqlServiceImpl implements MysqlService {

    @Autowired
    MysqlMapper mysqlMapper;

    public List<DataBase> getTable(String dataBaseName) {
        return mysqlMapper.getTable(dataBaseName);
    }


    public List<Column> getColumn(String tableName) {
        return mysqlMapper.getColumn(tableName);
    }

}
