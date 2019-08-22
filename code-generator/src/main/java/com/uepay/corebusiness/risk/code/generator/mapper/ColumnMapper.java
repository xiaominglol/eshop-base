package com.uepay.corebusiness.risk.code.generator.mapper;

import com.uepay.corebusiness.risk.code.generator.domain.Column;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ColumnMapper {

    List<Column> find(@Param("tableName") String tableName);
}
