package com.gemini.code.generator.domain;

import lombok.Data;

import java.util.List;

/**
 * @author 小明不读书
 */
@Data
public class Dict {

    /**
     * 字典表名
     */
    private String tableName;

    /**
     * 主鍵ID
     */
    private Long id;

    /**
     * 数据字典父逻辑主键
     */
    private Long pid;

    /**
     * 英文编码 英文标识符，用英文单词标识字典字段的含义。
     */
    private String code;

    /**
     * 中文名称 用中文单词表示字典的字段的含义
     */
    private String name;

    /**
     * 解释 关于字典数据的描述
     */
    private String description;

    /**
     * 子列表
     */
    private List<Dict> children;
}