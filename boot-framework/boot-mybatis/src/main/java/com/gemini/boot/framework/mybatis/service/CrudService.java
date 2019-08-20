package com.gemini.boot.framework.mybatis.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gemini.boot.framework.mybatis.enums.LogicEnum;
import com.gemini.boot.framework.mybatis.po.BasePo;
import com.gemini.boot.framework.mybatis.utils.BeanUtils;
import com.gemini.boot.framework.mybatis.utils.StringUtils;
import org.slf4j.Logger;
import org.springframework.scheduling.annotation.Async;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Service基類
 * @author 小明不读书
 */
public interface CrudService<Pojo, Po extends BasePo, Mapper extends BaseMapper<Po>> {


    /**
     * 獲取uid
     *
     * @return Long
     */
    Long uid();

    /**
     * 獲取log
     *
     * @return Logger
     */
    Logger log();

    /**
     * 獲取mapper
     *
     * @return Mapper
     */
    Mapper mapper();

    /**
     * 獲取Pojo的class
     *
     * @return Class<Pojo>
     */
    default Class<Pojo> pojo() {
        return (Class<Pojo>) BeanUtils.types(this.getClass())[0];
    }

    /**
     * 獲取Po的class
     *
     * @return Class<Po>
     */
    default Class<Po> po() {
        return (Class<Po>) BeanUtils.types(this.getClass())[1];
    }

    ;

    /**
     * 新增之前執行的邏輯
     *
     * @param pojo
     * @param po
     */
    default void insertBefore(Pojo pojo, Po po) {
        BeanUtils.invoke(po, "setId", uid());
    }

    /**
     * 新增之后執行的邏輯
     *
     * @param pojo
     * @param po
     */
    default void insertAfter(Pojo pojo, Po po) {
    }

    /**
     * 更新之前執行的邏輯
     *
     * @param pojo
     * @param po
     */
    default void updateBefore(Pojo pojo, Po po) {
    }

    /**
     * 更新之后執行的邏輯
     *
     * @param pojo
     * @param po
     */
    default void updateAfter(Pojo pojo, Po po) {
    }

    /**
     * 刪除之前執行的邏輯
     *
     * @param ids 主鍵ID
     */
    default void deleteBefore(Long... ids) {
    }

    /**
     * 刪除之前執行的邏輯
     *
     * @param ids 主鍵ID
     */
    default void deleteAfter(Long... ids) {
    }

    /**
     * 复制po为pojo
     *
     * @param po
     * @return Pojo
     */
    default Pojo copy(Po po) {
        return BeanUtils.copy(po, pojo());
    }

    /**
     * 复制pojo为po
     *
     * @param pojo
     * @return Po
     */
    default Po copy(Pojo pojo) {
        return BeanUtils.copy(pojo, po());
    }

    /**
     * 复制pojo列表为po列表
     *
     * @param list，List<Po>
     * @return List<Pojo>
     */
    default List<Pojo> copy(List<Po> list) {
        return BeanUtils.copy(list, pojo());
    }

    /**
     * 复制pojo分页为po分页
     *
     * @param page，IPage<Po>
     * @return IPage<Pojo>
     */
    default IPage<Pojo> copy(IPage<Po> page) {
        return BeanUtils.copy(page, pojo());
    }

    /**
     * 獲取wrapper
     *
     * @return QueryWrapper<Po>
     */
    default QueryWrapper<Po> wrapper() {
        return new QueryWrapper<Po>();
    }

    ;

    /**
     * 根據pojo獲取wrapper
     *
     * @param pojo
     * @return QueryWrapper<Po>
     */
    default QueryWrapper<Po> wrapper(Pojo pojo) {
        QueryWrapper<Po> wrapper = wrapper();
        try {
            String ascs = (String) BeanUtils.invoke(pojo, "getAscs");
            String descs = (String) BeanUtils.invoke(pojo, "getDescs");
            if (ascs != null) {
                wrapper.orderByAsc(StringUtils.toUnderScoreCase(ascs).split(","));
            }
            if (descs != null) {
                wrapper.orderByDesc(StringUtils.toUnderScoreCase(descs).split(","));
            }
        } finally {
            return wrapper;
        }
    }

    /**
     * 根據map獲取wrapper
     *
     * @param map 字段名為key，字段值為value
     * @return QueryWrapper<Po>
     */
    default QueryWrapper<Po> wrapper(Map<String, Object> map) {
        QueryWrapper<Po> wrapper = wrapper();
        if (map != null) {
            for (String key : map.keySet()) {
                wrapper.eq(StringUtils.toUnderScoreCase(key), map.get(key));
            }
            if (map.get("ascs") != null) {
                wrapper.orderByAsc(StringUtils.toUnderScoreCase((String) map.get("ascs")).split(","));
            }
            if (map.get("descs") != null) {
                wrapper.orderByDesc(StringUtils.toUnderScoreCase((String) map.get("descs")).split(","));
            }
        }
        return wrapper;
    }

    /**
     * 根據字段名、字段值獲取wrapper
     *
     * @param name   字段名
     * @param values 字段值
     * @return QueryWrapper<Po>
     */
    default QueryWrapper<Po> wrapper(String name, String values) {
        return wrapper().in(StringUtils.toUnderScoreCase(name), values);
    }

    /**
     * 根據字段名、字段值獲取wrapper
     *
     * @param name   字段名
     * @param values 字段值
     * @return QueryWrapper<Po>
     */
    default QueryWrapper<Po> wrapper(String name, Object... values) {
        return wrapper().in(StringUtils.toUnderScoreCase(name), values);
    }

    /**
     * 根據邏輯名稱、字段名、字段值獲取wrapper
     *
     * @param logic 邏輯名稱
     * @param name  字段名
     * @param value 字段值
     * @return QueryWrapper<Po>
     */
    default QueryWrapper<Po> wrapper(LogicEnum logic, String name, Object value) {
        QueryWrapper<Po> wrapper = wrapper();
        BeanUtils.invoke(wrapper, logic.toString(), StringUtils.toUnderScoreCase(name), value);
        return wrapper;
    }

    /**
     * 插入記錄
     *
     * @param pojo
     */
    @Async
    default void insert(Pojo pojo) {
        log().info("新增数据：{}", pojo);
        Po po = copy(pojo);
        insertBefore(pojo, po);
        mapper().insert(po);
        insertAfter(pojo, po);
    }

    /**
     * 批量插入記錄
     *
     * @param list，List<Pojo>
     */
    @Async
    default void insert(List<Pojo> list) {
        if (list != null) {
            for (Pojo pojo : list) {
                insert(pojo);
            }
        }
    }

    /**
     * 根據ID更新記錄
     *
     * @param pojo
     */
    @Async
    default void update(Pojo pojo) {
        log().info("更新数据：{}", pojo);
        Po po = copy(pojo);
        updateBefore(pojo, po);
        mapper().updateById(po);
        updateAfter(pojo, po);
    }

    /**
     * 批量更新記錄
     *
     * @param list，List<Pojo>
     */
    @Async
    default void update(List<Pojo> list) {
        if (list != null) {
            for (Pojo pojo : list) {
                update(pojo);
            }
        }
    }

    /**
     * 根據ID刪除記錄
     *
     * @param ids 主鍵ID
     */
    @Async
    default void delete(Long... ids) {
        log().error("删除数据：{}", ids);
        deleteBefore(ids);
        mapper().deleteBatchIds(Arrays.asList(ids));
        deleteAfter(ids);
    }

    /**
     * 根據pojo刪除記錄
     *
     * @param pojo
     */
    @Async
    default void delete(Pojo pojo) {
        log().error("删除数据：{}", pojo);
        mapper().delete(wrapper(pojo));
    }

    /**
     * 根據map刪除記錄
     *
     * @param map 字段名為key，字段值為value
     */
    @Async
    default void delete(Map<String, Object> map) {
        log().error("删除数据：{}", map);
        mapper().deleteByMap(map);
    }

    /**
     * 根據wrapper刪除記錄
     *
     * @param wrapper，QueryWrapper<Po>
     */
    @Async
    default void delete(QueryWrapper<Po> wrapper) {
        log().error("删除数据：{}", wrapper);
        mapper().delete(wrapper);
    }

    /**
     * 根據字段名、字段值刪除記錄
     *
     * @param name   字段名
     * @param values 字段值
     */
    @Async
    default void delete(String name, Object... values) {
        log().error("删除数据：{}，{}", name, values);
        mapper().delete(wrapper(name, values));
    }

    /**
     * 根據ID查詢記錄
     *
     * @param id 主鍵ID
     * @return Pojo
     */
    default Pojo get(Long id) {
        Po po = mapper().selectById(id);
        Pojo pojo = copy(po);
        return pojo;
    }

    /**
     * 查詢所有記錄列表
     *
     * @return List<T>>
     */
    default List<Pojo> list() {
        List<Po> poList = mapper().selectList(new QueryWrapper<Po>());
        List<Pojo> pojoList = copy(poList);
        return pojoList;
    }

    /**
     * 根據pojo查詢記錄列表
     *
     * @param pojo
     * @return List<Pojo>
     */
    default List<Pojo> list(Pojo pojo) {
        List<Po> poList = mapper().selectList(wrapper(pojo));
        List<Pojo> pojoList = copy(poList);
        return pojoList;
    }

    /**
     * 根據map查詢記錄列表
     *
     * @param map 字段名為key，字段值為value
     * @return List<Pojo>
     */
    default List<Pojo> list(Map<String, Object> map) {
        List<Po> poList = mapper().selectList(wrapper(map));
        List<Pojo> pojoList = copy(poList);
        return pojoList;
    }

    /**
     * 根據wrapper查詢記錄列表
     *
     * @param wrapper
     * @return List<Pojo>
     */
    default List<Pojo> list(QueryWrapper<Po> wrapper) {
        List<Po> poList = mapper().selectList(wrapper);
        List<Pojo> pojoList = copy(poList);
        return pojoList;
    }

    /**
     * 根據更新時間查詢記錄列表
     *
     * @param modifyDateMin 更新時間搓最小值
     * @param modifyDateMax 更新時間錯最大值
     * @return List<Pojo>>
     */
    default List<Pojo> list(Long modifyDateMin, Long modifyDateMax) {
        QueryWrapper wrapper = wrapper().between("modify_date", modifyDateMin, modifyDateMax);
        List<Po> poList = mapper().selectList(wrapper);
        List<Pojo> pojoList = copy(poList);
        return pojoList;
    }

    /**
     * 查詢記錄分頁
     *
     * @param pojo
     * @param current 第幾頁
     * @param size    一頁幾條記錄
     * @return IPage<Pojo>
     */
    default IPage<Pojo> page(Pojo pojo, Long current, Long size) {
        Page<Po> page = new Page<>(current == null ? 1L : current, size == null ? 10L : size);
        IPage<Po> poPage = mapper().selectPage(page, wrapper(pojo));
        IPage<Pojo> pojoPage = copy(poPage);
        return pojoPage;
    }

    /**
     * 根據map查詢記錄分頁
     *
     * @param map 字段名為key，字段值為value
     * @return IPage<Pojo>
     */
    default IPage<Pojo> page(Map<String, Object> map) {
        Long current = (Long) map.get("current");
        Long size = (Long) map.get("size");
        Page<Po> page = new Page<>(current == null ? 1L : current, size == null ? 10L : size);
        IPage<Po> poPage = mapper().selectPage(page, wrapper(map));
        IPage<Pojo> entityPage = copy(poPage);
        return entityPage;
    }
}
