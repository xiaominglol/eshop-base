package com.uepay.corebusiness.risk.cud.service.controller;

import com.gemini.portal.module.sys.dto.${table.className}Dto;
import com.gemini.portal.module.sys.service.${table.className}Service;
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
    ${table.className}Service ${table.domainName}Service;

    @GetMapping("/{id}")
    public Mono<${table.className}Dto> get(@PathVariable final Long id) {
        return Mono.just(${table.domainName}Service.get(id));
    }

    @PostMapping("/list")
    public Mono<List<${table.className}Dto>> list(@RequestBody final ${table.className}Dto dto) {
        return Mono.just(${table.domainName}Service.list(dto));
    }

    @PostMapping
    public Mono<Boolean> insert(@RequestBody final ${table.className}Dto dto) {
        ${table.domainName}Service.insert(dto);
        return Mono.just(true);
    }

    @PutMapping
    public Mono<Boolean> update(@RequestBody final ${table.className}Dto dto) {
        ${table.domainName}Service.update(dto);
        return Mono.just(true);
    }

    @DeleteMapping("/{id}")
    public Mono<Boolean> delete(@PathVariable final Long id) {
        ${table.domainName}Service.delete(id);
        return Mono.just(true);
    }
}