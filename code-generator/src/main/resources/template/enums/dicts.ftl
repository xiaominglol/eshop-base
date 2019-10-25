package com.uepay.corebusiness.risk.base.dict;

import com.gemini.boot.framework.mybatis.entity.Dict;

import java.util.HashMap;
import java.util.Map;

/**
* 字典存儲對象
*/
public class Dicts {

/**
* 私有化構造方法
*/
private Dicts() {
super();
}

/**
* 儲存字典的MAP
*/
private static final Map
<Long, Dict> dicts = new HashMap<>();

static {
dicts.put(0L, new Dict());
<#list list as dict>
    <#list dict.children as child>
        dicts.put(${child.id?c}L, new Dict().setId(${child.id?c}L).setCode("${child.code}").setName("${child.name}"));
    </#list>
</#list>
}

/**
* 根據ID獲取字典對象
* @param id 字典對象ID
* @return Dict
*/
public static Dict get(Long id) {
Dict dict = dicts.get(id);
if(dict == null) {
dict = new Dict();
dict.setId(id);
}
return dict;
}
}
