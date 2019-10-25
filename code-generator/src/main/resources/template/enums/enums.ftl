package com.uepay.corebusiness.risk.base.enums;

import com.gemini.boot.framework.mybatis.entity.Dict;
import com.gemini.business.platform.enums.Dicts;
import com.gemini.boot.framework.mybatis.service.DictService;

/**
* id：${id?c}
* code：${code}
* name：${name}
* description：${description}
*/
public enum ${code}Enum implements DictService {
<#assign item>
    <#list children as child>

        /**
        * id：${child.id?c}
        * code：${child.code}
        * name：${child.name}
        * description：${child.description}
        */
        ${child.code}() {
        @Override
        public Dict dict() {
        return Dicts.get(${child.id?c}L);
        }
        },
    </#list>
</#assign>
${item?substring(0, item?last_index_of(","))}
}
