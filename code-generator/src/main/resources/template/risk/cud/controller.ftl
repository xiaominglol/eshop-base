package com.uepay.corebusiness.risk.cud.service.controller;

import com.uepay.corebusiness.risk.cud.facade.dto.${table.className}Dto;
import com.uepay.corebusiness.risk.cud.service.service.${table.className}Service;
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
${table.className}Service ${table.smallClassName}Service;

    @GetMapping("/{id}")
    public Mono<${table.className}Dto> get(@PathVariable final Long id) {
    return Mono.just(${table.smallClassName}Service.get(id));
    }

    @PostMapping("/list")
    public Mono<List<${table.className}Dto>> list(@RequestBody final ${table.className}Dto dto) {
        return Mono.just(${table.smallClassName}Service.list(dto));
    }

    @PostMapping
    public Mono<Boolean> insert(@RequestBody final ${table.className}Dto dto) {
            ${table.smallClassName}Service.insert(dto);
        return Mono.just(true);
    }

    @PutMapping
    public Mono<Boolean> update(@RequestBody final ${table.className}Dto dto) {
                ${table.smallClassName}Service.update(dto);
        return Mono.just(true);
    }

    @DeleteMapping("/{id}")
    public Mono<Boolean> delete(@PathVariable final Long id) {
                    ${table.smallClassName}Service.delete(id);
        return Mono.just(true);
    }
}