package com.uepay.corebusiness.risk.api.service.controller;

import com.gemini.portal.module.sys.dto.${table.className}Dto;
import com.uepay.corebusiness.risk.cud.facade.feign.${table.className}Feign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * ${table.title}
 * @author ${table.author}
 */
@Slf4j
@RestController
@RequestMapping("${table.request}")
public class ${table.className}Controller {

    @Autowired
    ${table.className}Feign ${table.domainName}Feign;

    @GetMapping("/{id}")
    Mono<${table.className}Dto> get(@PathVariable final Long id) {
        return Mono.just(${table.domainName}Feign.get(id));
    }

    @PostMapping("/list")
    Mono<List<${table.className}Dto>> list(@RequestBody final ${table.className}Dto dto) {
        return Mono.just(${table.domainName}Feign.list(dto));
    }

    @PostMapping
    Mono<Boolean> insert(@RequestBody final ${table.className}Dto dto) {
        return Mono.just(${table.domainName}Feign.insert(dto));
    }

    @PutMapping
    Mono<Boolean> update(@RequestBody final ${table.className}Dto dto) {
        return Mono.just(${table.domainName}Feign.update(dto));
    }

    @DeleteMapping("/{id}")
    Mono<Boolean> delete(@PathVariable final Long id) {
        return Mono.just(${table.domainName}Feign.delete(id));
    }
}