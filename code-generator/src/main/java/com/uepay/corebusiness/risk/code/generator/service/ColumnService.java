package com.uepay.corebusiness.risk.code.generator.service;

import com.uepay.corebusiness.risk.code.generator.domain.Column;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ColumnService {

	List<Column> find(@Param("tableName") String tableName);

}
