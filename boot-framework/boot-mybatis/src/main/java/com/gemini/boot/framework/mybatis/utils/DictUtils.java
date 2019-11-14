package com.gemini.boot.framework.mybatis.utils;

import com.gemini.boot.framework.mybatis.entity.Dict;

import java.util.HashMap;
import java.util.Map;

/**
 * 字典存儲對象
 */
public class DictUtils {

    /**
     * 私有化構造方法
     */
    private DictUtils() {
        super();
    }

    /**
     * 儲存字典的MAP
     */
    private static final Map<Long, Dict> dictMap = new HashMap<>();

    static {
        dictMap.put(391933416176129L, new Dict().setId(391933416176129L).setCode("Disable").setName("禁用"));
        dictMap.put(391933416176131L, new Dict().setId(391933416176131L).setCode("Enable").setName("启用"));
    }

    /**
     * 根據ID獲取字典對象
     *
     * @param id 字典對象ID
     * @return Dict
     */
    public static Dict get(Long id) {
        Dict dict = dictMap.get(id);
        if (dict == null) {
            dict = new Dict();
            dict.setId(id);
        }
        return dict;
    }
}
