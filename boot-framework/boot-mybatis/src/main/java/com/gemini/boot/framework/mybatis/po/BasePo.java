package com.gemini.boot.framework.mybatis.po;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Po基類
 *
 * @author wenge.cai
 */
@Data
public class BasePo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主鍵ID
     */
    private Long id;

    /**
     * 状态（Enable：启用，Disable：禁用）
     */
    private String state;

    /**
     * 修改人id
     */
    private Long modifyId;

    /**
     * 修改人
     */
    private String modifyName;

    /**
     * 修改时间
     */
    private Date modifyTime;
}
