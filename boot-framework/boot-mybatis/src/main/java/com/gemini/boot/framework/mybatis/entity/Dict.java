package com.gemini.boot.framework.mybatis.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.HashMap;
import java.util.Map;

@Data
@Accessors(chain = true)
public class Dict {
    /**
     * 字典id
     */
    private Long id;
    /**
     * 字典编码
     */
    private String code;
    /**
     * 字典名称
     */
    private String name;

    /**
     * 儲存字典的MAP
     */
    private static final Map<Long, Dict> dictMap = new HashMap<>();

    static {
        dictMap.put(0L, new Dict());
        dictMap.put(391933416176131L, new Dict().setId(391933416176131L).setCode("Enable").setName("启用"));
        dictMap.put(391933416176129L, new Dict().setId(391933416176129L).setCode("Disable").setName("禁用"));
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