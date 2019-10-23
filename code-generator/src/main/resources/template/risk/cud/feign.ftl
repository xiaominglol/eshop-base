package com.uepay.corebusiness.risk.cud.facade.feign;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ${table.title}
 */
@FeignClient(contextId = "${table.smallClassName}CudClient", name = "business-risk-cud-service")
public interface ${table.className}Feign {

String root = "${table.requestMapping}";

    @GetMapping(root + "/{id}")
    ${table.className}Dto get(@PathVariable(value = "id") Long id);

    @PostMapping(root + "/list")
    List<${table.className}Dto> list(${table.className}Dto dto);

    @PostMapping(root)
    boolean insert(${table.className}Dto dto);

    @PutMapping(root)
    boolean update(${table.className}Dto dto);

    @DeleteMapping(root + "/{id}")
    boolean delete(@PathVariable(value = "id") Long id);
}
