package com.uepay.corebusiness.risk.base.dict;

import com.uepay.framework.normalize.Dict;

import java.util.HashMap;
import java.util.Map;

/**
 * 字典存儲對象
 */
public class Dicts {

    /**
     * 儲存字典的MAP
     */
    private static Map<Long, Dict> dicts;

    /**
     * 私有化構造方法
     */
    private Dicts() {
        super();
    }

    /**
     * 根據ID獲取字典對象
     * @param id 字典對象ID
     * @return Dict
     */
    public static Dict get(Long id) {
        if(dicts == null) {
            synchronized (Dicts.class) {
                if(dicts == null) {
                    dicts = new HashMap<>();
                    dicts.put(0L, new Dict());
<#list list as dict>
    <#list dict.children as child>
                    dicts.put(${child.id?c}L, new Dict().setId(${child.id?c}L).setCode("${child.code}").setNameCn("${child.nameCn}").setNameEn("${child.nameEn}"));
    </#list>
</#list>
                }
            }
        }
        Dict dict = dicts.get(id);
        if(dict == null) {
            dict = new Dict();
            dict.setId(id);
        }
        return dict;
    }
}
