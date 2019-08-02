package com.uepay.corebusiness.risk.code.generator.service;

import com.uepay.corebusiness.risk.code.generator.domain.Dict;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DictService {

	List<Dict> find(@Param("tableName") String tableName);

}
