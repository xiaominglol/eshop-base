package com.gemini.boot.framework.mybatis.po;

import lombok.Data;

import java.sql.Timestamp;

/**
 * Po基类
 *
 * @author 小明不读书
 */
@Data
public class BasePo extends BaseObjectPo {

    /**
     * 主鍵ID
     */
    private Long id;

    /**
     * 状态id
     */
    private Long stateId;

    /**
     * 状态编码
     */
    private String stateCode;

    /**
     * 状态名称
     */
    private String stateName;

    /**
     * 修改人id
     */
    private Long modifyUserId;

    /**
     * 修改人名称
     */
    private String modifyUserName;

    /**
     * 修改时间(YYYY-MM-DD HH:MM:SS)
     */
    private Timestamp modifyTime;
}
