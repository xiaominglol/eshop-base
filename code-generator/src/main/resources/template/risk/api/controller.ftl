package com.uepay.corebusiness.risk.api.service.controller;

import com.uepay.corebusiness.risk.cud.facade.dto.${table.className}Dto;
import com.uepay.corebusiness.risk.cud.facade.feign.${table.className}Feign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * ${table.title}
 */
@Slf4j
@RestController
@RequestMapping("${table.requestMapping}")
public class ${table.className}Controller {

    @Autowired
${table.className}Feign ${table.smallClassName}Feign;

    @GetMapping("/{id}")
    Mono<${table.className}Dto> get(@PathVariable final Long id) {
    return Mono.just(${table.smallClassName}Feign.get(id));
    }

    @PostMapping("/list")
    Mono<List<${table.className}Dto>> list(@RequestBody final ${table.className}Dto dto) {
        return Mono.just(${table.smallClassName}Feign.list(dto));
    }

    @PostMapping
    Mono<Boolean> insert(@RequestBody final ${table.className}Dto dto) {
            return Mono.just(${table.smallClassName}Feign.insert(dto));
    }

    @PutMapping
    Mono<Boolean> update(@RequestBody final ${table.className}Dto dto) {
                return Mono.just(${table.smallClassName}Feign.update(dto));
    }

    @DeleteMapping("/{id}")
    Mono<Boolean> delete(@PathVariable final Long id) {
                    return Mono.just(${table.smallClassName}Feign.delete(id));
    }
}