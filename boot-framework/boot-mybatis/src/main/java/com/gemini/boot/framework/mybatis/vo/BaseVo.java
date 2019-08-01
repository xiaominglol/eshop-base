package com.gemini.boot.framework.mybatis.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Po基類
 *
 * @author wenge.cai
 */
@Data
public class BaseVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主鍵ID
     */
    private Long id;

    /**
     * 状态id
     */
    private Long stateId;

    /**
     * 状态编码（Enable：启用，Disable：禁用）
     */
    private String stateCode;

    /**
     * 状态名称
     */
    private String stateName;

    /**
     * 修改人id
     */
    private Long modifyId;

    /**
     * 修改人名称
     */
    private String modifyName;

    /**
     * 修改时间
     */
    private Date modifyTime;
}
