package com.uepay.corebusiness.risk.base.enums;

import com.uepay.corebusiness.risk.base.dict.Dicts;
import com.uepay.framework.normalize.Dict;
import com.uepay.framework.normalize.DictData;

/**
* id：${id?c}
* code：${code}
* nameCn：${nameCn}
* nameEn：${nameEn}
* descriptionCn：${descriptionCn}
* descriptionEn：${descriptionEn}
*/
public enum ${code}Enum implements DictData {
<#assign item>
    <#list children as child>

        /**
        * id：${child.id?c}
        * code：${child.code}
        * nameCn：${child.nameCn}
        * nameEn：${child.nameEn}
        * descriptionCn：${child.descriptionCn}
        * descriptionEn：${child.descriptionEn}
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
