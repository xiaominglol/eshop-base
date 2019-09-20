package com.gemini.boot.framework.mybatis.po;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.List;

/**
 * 主子表都是自己
 *
 * @author 小明不读书
 */
@Data
public class BaseSubPo<T> extends BasePo {

    /**
     * 父id
     */
    private Long pid;

    /**
     * 明细子表
     */
    @TableField(exist = false)
    private List<T> detailList;
}
