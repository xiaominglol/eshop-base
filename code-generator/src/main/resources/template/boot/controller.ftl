package ${table.packageName}.${table.moduleName}.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gemini.boot.framework.mybatis.entity.LayUiPage;
import com.gemini.boot.framework.web.entity.CommonFailInfo;
import com.gemini.boot.framework.web.entity.Message;
import ${table.packageName}.common.annotation.SysLog;
import ${table.packageName}.${table.moduleName}.po.${table.bigClassName}Po;
import ${table.packageName}.${table.moduleName}.service.${table.bigClassName}Service;
import ${table.packageName}.platform.service.ErrorLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * ${table.tableComment}
*
* @author ${table.author}
* @date ${table.createDate}
*/
@Slf4j
@RestController
@RequestMapping("${table.requestMapping}")
public class ${table.bigClassName}Controller {

@Autowired
${table.bigClassName}Service service;

@GetMapping("/gotoList")
public String gotoList() {
return "${table.moduleName}/_list";
}

@GetMapping
@ResponseBody
public Message list(LayUiPage layUiPage, ${table.bigClassName}Po po) {
QueryWrapper
<${table.bigClassName}Po> qw = new QueryWrapper<>();
    if (layUiPage.getPageNum() != 0 && layUiPage.getPageSize() != 0) {
    IPage
    <${table.bigClassName}Po> list = service.page(new Page<>(layUiPage.getPageNum(), layUiPage.getPageSize()), qw);
        return Message.success(list);
        } else {
        List
        <${table.bigClassName}Po> list = service.list(qw);
            return Message.success(list);
            }
            }

            @GetMapping("/{id}")
            @ResponseBody
            public Message detail(@PathVariable("id") Long id) {
            if (!StringUtils.isEmpty(id)) {
            ${table.bigClassName}Po ${table.smallClassName}Po = service.getById(id);
            return Message.success(${table.smallClassName}Po);
            } else {
            return Message.fail(CommonFailInfo.Id_CAN_NOT_BE_EMPTY);
            }
            }

            @PostMapping
            @ResponseBody
            public Message add(@RequestBody ${table.bigClassName}Po po) {
            if (StringUtils.isEmpty(po.getId())) {
            service.insertSync(po, false);
            return Message.success(po);
            } else {
            return Message.fail(CommonFailInfo.Id_ALREADY_EXIST);
            }
            }

            @PutMapping
            @ResponseBody
            public Message update(@RequestBody ${table.bigClassName}Po po) {
            if (!StringUtils.isEmpty(po.getId())) {
            service.updateSync(po, false);
            return Message.success(po);
            } else {
            return Message.fail(CommonFailInfo.Id_CAN_NOT_BE_EMPTY);
            }
            }

            @DeleteMapping("/{id}")
            @ResponseBody
            public Message delete(@PathVariable("id") Long id) {
            if (!StringUtils.isEmpty(id)) {
            service.deleteByIdSync(id);
            return Message.success(null);
            } else {
            return Message.fail(CommonFailInfo.Id_CAN_NOT_BE_EMPTY);
            }
            }

            }
