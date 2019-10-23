package com.uepay.corebusiness.risk.console.controller;

import com.uepay.corebusiness.risk.api.facade.dto.${table.className}Dto;
import com.uepay.corebusiness.risk.api.facade.feign.${table.className}Feign;
import com.uepay.corebusiness.risk.base.enums.HttpCodeEnum;
import com.uepay.corebusiness.risk.base.result.ResponseData;
import com.uepay.corebusiness.risk.base.util.BeanUtils;
import com.uepay.corebusiness.risk.console.service.${table.className}Service;
import com.uepay.corebusiness.risk.console.vo.${table.className}Vo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

/**
 * ${table.title}
 */
@Slf4j
@RestController
@RequestMapping("${table.requestMapping}")
public class ${table.className}Controller extends BaseController {

    @Autowired
${table.className}Feign ${table.smallClassName}Feign;

    @Autowired
${table.className}Service ${table.smallClassName}Service;

    @GetMapping("/{id}")
    Mono<ResponseData> get(@PathVariable final Long id) {
        return Mono
    .justOrEmpty(${table.smallClassName}Service.get(id))
                .map(vo -> {
                    return new ResponseData(vo);
                })
                .switchIfEmpty(Mono.just(new ResponseData(HttpCodeEnum.N410)))
                .onErrorResume(e -> {
                    log.error("get: {}", e);
                    return Mono.just(new ResponseData(HttpCodeEnum.N500, e.getMessage()));
                });
    }

    @GetMapping
    Mono<ResponseData> list(final ${table.className}Vo vo) {
        return Mono
        .just(${table.smallClassName}Service.list(vo))
                .map(list -> {
                    return new ResponseData(list);
                })
                .onErrorResume(e -> {
                    log.error("list: {}", e);
                    return Mono.just(new ResponseData(HttpCodeEnum.N500, e.getMessage()));
                });
    }

    @GetMapping("/{current}/{size}")
    Mono<ResponseData> page(final ${table.className}Vo vo, @PathVariable Long current, @PathVariable Long size) {
        return Mono
            .just(${table.smallClassName}Service.page(vo, current, size))
                .map(page -> {
                    return new ResponseData(page);
                })
                .onErrorResume(e -> {
                    log.error("page: {}", e);
                    return Mono.just(new ResponseData(HttpCodeEnum.N500, e.getMessage()));
                });
    }

    @PostMapping
    Mono<ResponseData> insert(@RequestBody final ${table.className}Vo vo) {
                <#if table.dicts??>vo.initDicts();</#if>
                vo.setModifyUserId(userId);
                vo.setModifyUserName(userName);
        return Mono
                .justOrEmpty(BeanUtils.copy(vo, ${table.className}Dto.class))
                .map(dto -> {
                return ${table.smallClassName}Feign.insert(dto);
                })
                .map(flag -> {
                    return  new ResponseData(flag ? HttpCodeEnum.N201 : HttpCodeEnum.N400);
                })
                .switchIfEmpty(Mono.just(new ResponseData(HttpCodeEnum.N410)))
                .onErrorResume(e -> {
                    log.error("insert: {}", e);
                    return Mono.just(new ResponseData(HttpCodeEnum.N500, e.getMessage()));
                });
    }

    @PutMapping
    Mono<ResponseData> update(@RequestBody final ${table.className}Vo vo) {
                    <#if table.dicts??>vo.initDicts();</#if>
                    vo.setModifyUserId(userId);
                    vo.setModifyUserName(userName);
        return Mono
                .justOrEmpty(BeanUtils.copy(vo, ${table.className}Dto.class))
                .map(dto -> {
                    return ${table.smallClassName}Feign.update(dto);
                })
                .map(flag -> {
                    return  new ResponseData(flag ? HttpCodeEnum.N201 : HttpCodeEnum.N400);
                })
                .switchIfEmpty(Mono.just(new ResponseData(HttpCodeEnum.N410)))
                .onErrorResume(e -> {
                    log.error("update: {}", e);
                    return Mono.just(new ResponseData(HttpCodeEnum.N500, e.getMessage()));
                });
    }

    @DeleteMapping("/{id}")
    Mono<ResponseData> delete(@PathVariable final Long id) {
        return Mono
                        .justOrEmpty(${table.smallClassName}Service.get(id))
                .map(vo -> {
                        return ${table.smallClassName}Feign.delete(id);
                })
                .map(flag -> {
                    return  new ResponseData(flag ? HttpCodeEnum.N204 : HttpCodeEnum.N400);
                })
                .switchIfEmpty(Mono.just(new ResponseData(HttpCodeEnum.N410)))
                .onErrorResume(e -> {
                    log.error("delete: {}", e);
                    return Mono.just(new ResponseData(HttpCodeEnum.N500, e.getMessage()));
                });
    }
}