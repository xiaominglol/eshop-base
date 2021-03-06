package com.uepay.corebusiness.risk.api.facade.feign;

import com.uepay.corebusiness.risk.cud.facade.dto.${table.className}Dto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

/**
 * ${table.title}
* @author wenge.cai
 */

@FeignClient(contextId = "${table.smallClassName}Client", name = "business-risk-api-service", url = FeignUrl.FEIGN_URL)
public interface ${table.className}Feign {

    @PostMapping("${table.facade}")
void add(${table.className}Dto ${table.smallClassName}Dto);

    @PutMapping("${table.facade}")
void update(${table.className}Dto ${table.smallClassName}Dto);

    @DeleteMapping("${table.facade}/{id}")
    void delete(@PathVariable(value = "id") Long id);

}
