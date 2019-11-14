package com.gemini.boot.framework.mybatis.po;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.List;

/**
 * 主子表
 *
 * @author 小明不读书
 */
@Data
public class BaseDetailPo<T> extends BasePo {

    /**
     * 明细子表
     */
    @TableField(exist = false)
    private List<T> detailList;
}
