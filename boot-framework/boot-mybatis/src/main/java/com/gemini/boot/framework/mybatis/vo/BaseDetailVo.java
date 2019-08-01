package com.gemini.boot.framework.mybatis.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * Po基類
 * @author wenge.cai
 */
@Data
public class BaseDetailVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主鍵ID
     */
    private Long id;

    /**
     * 父id
     */
    private Long pid;
}
