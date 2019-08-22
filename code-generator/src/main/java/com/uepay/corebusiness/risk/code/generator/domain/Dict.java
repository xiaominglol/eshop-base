package com.uepay.corebusiness.risk.code.generator.domain;

import java.sql.Timestamp;
import java.util.List;

/**
 * 风控业务字典
 *
 * @author 小明不读书
 */
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
     * 修改日期
     */
    private Long stateId;

    /**
     * 修改人
     */
    private String stateCode;

    /**
     * 修改類型
     */
    private String stateName;

    private Long modifyUserId;

    private String modifyUserName;

    private Timestamp modifyTime;


    /**
     * 子列表
     */
    private List<Dict> detailList;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getStateId() {
        return stateId;
    }

    public void setStateId(Long stateId) {
        this.stateId = stateId;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public Long getModifyUserId() {
        return modifyUserId;
    }

    public void setModifyUserId(Long modifyUserId) {
        this.modifyUserId = modifyUserId;
    }

    public String getModifyUserName() {
        return modifyUserName;
    }

    public void setModifyUserName(String modifyUserName) {
        this.modifyUserName = modifyUserName;
    }

    public Timestamp getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Timestamp modifyTime) {
        this.modifyTime = modifyTime;
    }

    public List<Dict> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<Dict> detailList) {
        this.detailList = detailList;
    }
}