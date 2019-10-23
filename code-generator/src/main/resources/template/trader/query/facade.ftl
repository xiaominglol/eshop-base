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

@FeignClient(contextId = "${table.smallClassName}Client", name = "business-risk-api-service")
public interface ${table.className}Feign {

    /**
     * 新增${table.title}
     */
    @PostMapping("${table.facade}")
Mono
<Result> add${table.className}(${table.className}Dto ${table.smallClassName}Dto);

    /**
     * 更新${table.title}
     */
    @PutMapping("${table.facade}")
    Mono
    <Result> update${table.className}(${table.className}Dto ${table.smallClassName}Dto);

    /**
     * 删除${table.title}
     */
    @DeleteMapping("${table.facade}/{id}")
    Mono<Result>  delete${table.className}(@PathVariable(value = "id") Long id);

    /**
     * 查询${table.title}
     */
    @GetMapping("${table.facade}")
    Mono<Result> get${table.className}ById(Long id);

    /**
     * 查询${table.title}列表
     */
    @PostMapping("${table.facade}/list")
                Mono
                <Result> find${table.className}List(${table.className}Dto ${table.smallClassName}Dto);

    /**
     * 查询${table.title}分页
     */
    @PostMapping("${table.facade}/page")
                    Mono
                    <Result> find${table.className}Page(${table.className}Dto ${table.smallClassName}Dto);

}
