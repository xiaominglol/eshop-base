package com.uepay.corebusiness.risk.code.generator.service.impl;

import com.uepay.corebusiness.risk.code.generator.domain.Dict;
import com.uepay.corebusiness.risk.code.generator.mapper.DictMapper;
import com.uepay.corebusiness.risk.code.generator.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DictServiceImpl implements DictService {

    @Autowired
    DictMapper dictMapper;

    public List<Dict> find(String tableName) {
        return dictMapper.find(tableName);
    }

}
