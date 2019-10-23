package com.gemini.business.${table.className}.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gemini.boot.framework.mybatis.entity.LayUiPage;
import com.gemini.boot.framework.web.entity.CommonFailInfo;
import com.gemini.boot.framework.web.entity.Message;
import com.gemini.business.common.annotation.SysLog;
import com.gemini.business.platform.po.${table.className}Po;
import com.gemini.business.platform.service.${table.className}Service;
import com.gemini.business.platform.service.ErrorLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
* ${table.tableComment}
*
* @author 小明不读书
* @date 2018-10-24
*/
@Slf4j
@RestController
@RequestMapping("/${table.className}")
public class ${table.className}Controller {

@Autowired
${table.className}Service ${table.smallClassName}Service;

@GetMapping("/gotoList")
public String gotoList() {
return "module/${table.className}/dict/dict_list";
}

@GetMapping
@ResponseBody
public Message list(LayUiPage layUiPage, ${table.className}Po ${table.smallClassName}Po) {
try {
QueryWrapper
<${table.className}Po> qw = new QueryWrapper<>();
    if (layUiPage.getPageNum() != 0 && layUiPage.getPageSize() != 0) {
    IPage
    <${table.className}Po> list = ${table.smallClassName}Service.page(new Page<>(layUiPage.getPageNum(),
        layUiPage.getPageSize()), qw);
        return Message.success(list);
        } else {
        List
        <${table.className}Po> list = ${table.smallClassName}Service.list(qw);
            return Message.success(list);
            }
            } catch (Exception e) {
            return Message.fail(e.getMessage());
            }
            }

            @GetMapping("/{id}")
            @ResponseBody
            public Message detail(@PathVariable("id") Long id) {
            try {
            if (!StringUtils.isEmpty(id)) {
            ${table.className}Po ${table.smallClassName}Po = ${table.smallClassName}Service.getById(id);
            return Message.success(${table.smallClassName}Po);
            } else {
            return Message.fail(CommonFailInfo.Id_CAN_NOT_BE_EMPTY);
            }
            } catch (Exception e) {
            return Message.fail(e.getMessage());
            }
            }

            @SysLog("添加字典")
            @PostMapping
            @ResponseBody
            public Message add(@RequestBody DictPo dictPo) {
            try {
            if (StringUtils.isEmpty(dictPo.getId())) {
            dictService.insertSync(dictPo, dictPo.getDetailList(), true);
            return Message.success(dictPo);
            } else {
            return Message.fail(CommonFailInfo.Id_ALREADY_EXIST);
            }
            } catch (Exception e) {
            // excpLogService.save(ExcpLog.saveExcpLog(this.getClass().getName() + "." +
            Thread.currentThread().getStackTrace()[1].getMethodName() + "()", e.getMessage(), logger));
            return Message.fail(e.getMessage());
            }
            }

            @PostMapping("/list")
            public Mono
            <List
            <${table.className}Dto>> list(@RequestBody final ${table.className}Dto dto) {
                return Mono.just(${table.smallClassName}Service.list(dto));
                }

                @PostMapping
                public Mono
                <Boolean> insert(@RequestBody final ${table.className}Dto dto) {
                    ${table.smallClassName}Service.insert(dto);
                    return Mono.just(true);
                    }

                    @PutMapping
                    public Mono
                    <Boolean> update(@RequestBody final ${table.className}Dto dto) {
                        ${table.smallClassName}Service.update(dto);
                        return Mono.just(true);
                        }

                        @DeleteMapping("/{id}")
                        public Mono
                        <Boolean> delete(@PathVariable final Long id) {
                            ${table.smallClassName}Service.delete(id);
                            return Mono.just(true);
                            }
                            }