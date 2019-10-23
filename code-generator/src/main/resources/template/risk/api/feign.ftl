package com.uepay.corebusiness.risk.api.facade.feign;

import com.uepay.corebusiness.risk.api.facade.dto.${table.className}Dto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ${table.title}
 */
@FeignClient(contextId = "${table.smallClassName}ApiClient", name = "business-risk-api-service")
public interface ${table.className}Feign {

String root = "${table.requestMapping}";

    @GetMapping(root + "/{id}")
    ${table.className}Dto get(@PathVariable(value = "id") Long id);

    @PostMapping(root + "/list")
List
<${table.className}Dto> list(${table.className}Dto ${table.smallClassName}Dto);

    @PostMapping(root)
    boolean insert(${table.className}Dto ${table.smallClassName}Dto);

    @PutMapping(root)
    boolean update(${table.className}Dto ${table.smallClassName}Dto);

    @DeleteMapping(root + "/{id}")
    boolean delete(@PathVariable(value = "id") Long id);
}