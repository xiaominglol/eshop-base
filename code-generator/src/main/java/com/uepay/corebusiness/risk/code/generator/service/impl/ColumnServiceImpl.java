package com.uepay.corebusiness.risk.code.generator.service.impl;

import com.uepay.corebusiness.risk.code.generator.domain.Column;
import com.uepay.corebusiness.risk.code.generator.mapper.ColumnMapper;
import com.uepay.corebusiness.risk.code.generator.service.ColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColumnServiceImpl implements ColumnService {

    @Autowired
    ColumnMapper columnMapper;

    public List<Column> find(String tableName) {
        return columnMapper.find(tableName);
    }

}
