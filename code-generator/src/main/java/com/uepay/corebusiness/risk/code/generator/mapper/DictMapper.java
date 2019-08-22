package com.uepay.corebusiness.risk.code.generator.mapper;

import com.uepay.corebusiness.risk.code.generator.domain.Dict;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DictMapper {

    List<Dict> find(@Param("tableName") String tableName);

    List<Dict> children(@Param("pid") Long tableName);
}
