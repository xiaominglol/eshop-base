package com.uepay.corebusiness.risk.code.generator.domain;

import lombok.Data;

import java.util.List;

/**
 * 风控业务字典
 * @author wenge.cai
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
    private String nameCn;

    /**
     * 英文名称 用英文单词表示字典的字段的含义
     */
    private String nameEn;

    /**
     * 解释 关于字典数据的描述
     */
    private String descriptionCn;

    /**
     * 英文解释 关于字典数据的描述
     */
    private String descriptionEn;

    /**
     * 修改日期
     */
    private Long modifyDate;

    /**
     * 修改人
     */
    private Long modifyUser;

    /**
     * 修改類型
     */
    private String modifyType;

    /**
     * 修改人訪問ID
     */
    private Long modifyAccessId;

    /**
     * 子列表
     */
    private List<Dict> children;
}