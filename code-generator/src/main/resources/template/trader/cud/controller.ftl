package com.uepay.corebusiness.risk.console.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.uepay.corebusiness.risk.api.facade.feign.${table.className}Feign;
import com.uepay.corebusiness.risk.console.result.Result;
import com.uepay.corebusiness.risk.console.service.${table.className}Service;
import com.uepay.corebusiness.risk.console.utils.BeanUtils;
import com.uepay.corebusiness.risk.console.vo.${table.className}Vo;
import com.gemini.portal.module.sys.dto.${table.className}Dto;
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
@RequestMapping("${table.action}")
public class ${table.className}Controller {

    @Autowired
    ${table.className}Service ${table.domainName}Service;

    @PostMapping
    Mono<Result> add${table.className}(@RequestBody ${table.className}Vo vo) {
        Result result;
        try {
            log.info(traderDcEntity.toString());
            return ${table.domainName}Service.insert(traderDcEntity);
            result = new Result(true, "新增成功");
        } catch (Exception e) {
            result = new Result(false, "新增失敗");
            log.error("新增失敗：{}",  e);
            log.error("data：{}",  vo);
        }
        return Mono.just(result);
    }

    @PutMapping
    Mono<Result> update${table.className}(@RequestBody ${table.className}Vo vo) {
        Result result;
        try {
            ${table.className}Dto dto = BeanUtils.copyObject(vo, ${table.className}Dto.class);
            ${table.domainName}Feign.update(dto);
            result = new Result(true, "更新成功");
        } catch (Exception e) {
            result = new Result(false, "更新失敗");
            log.error("更新失敗：{}",  e);
            log.error("data：{}",  vo);
        }
        return Mono.just(result);
    }

    @DeleteMapping
    Mono<Result> delete(@PathVariable Long id) {
        Result result;
        try {
            ${table.domainName}Feign.delete(id);
            result = new Result(true, "刪除成功");
        } catch (Exception e) {
            result = new Result(false, "刪除失敗");
            log.error("刪除失敗：{}",  e);
            log.error("id：{}",  id);
        }
        return Mono.just(result);
    }
}

