package com.uepay.corebusiness.trader.query.controller;

import com.uepay.corebusiness.trader.query.facade.dto.${table.className}Dto;
import com.uepay.corebusiness.trader.query.facade.result.Result;
import com.uepay.corebusiness.trader.query.service.${table.className}Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

/**
 * ${table.title}
 * @author ${table.author}
 */
@Slf4j
@RestController
@RequestMapping("${table.action}")
public class ${table.className}Controller {

    @Autowired
    ${table.className}Service ${table.domainName}Service;

    @GetMapping("/{id}")
    Mono<Result> get${table.className}ById(@PathVariable final Long id) {
        return ${table.domainName}Service.getById(id);
    }

    @PostMapping("/list")
    Mono<Result> find${table.className}List(@RequestBody final ${table.className}Dto dto) {
        return ${table.domainName}Service.findList(dto);
    }

    @PostMapping("/page")
    Mono<Result> find${table.className}Page(@RequestBody final ${table.className}Dto dto) {
        return ${table.domainName}Service.findPage(dto);
    }
}

