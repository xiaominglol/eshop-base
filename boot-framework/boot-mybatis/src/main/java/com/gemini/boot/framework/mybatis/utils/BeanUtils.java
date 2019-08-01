package com.gemini.boot.framework.mybatis.utils;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gemini.boot.framework.mybatis.entity.Dict;
import com.gemini.boot.framework.mybatis.service.DictService;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class BeanUtils extends org.springframework.beans.BeanUtils {

    /**
     * 為target對象設置枚舉值
     *
     * @param dictService 枚舉對象
     * @param target   設置值得對象
     */
    public static void setDict(DictService dictService, Object target) {
        Dict dict = dictService.dict();
        String className = dictService.getClass().getName();
        String name = className.substring(className.lastIndexOf(".") + 1, className.lastIndexOf("Enum"));//dictService.getClass().getName().replaceFirst("com.uepay.corebusiness.risk.base.enums.", "");
        invoke(target, "set" + name + "Id", dict.getId());
        invoke(target, "set" + name + "Code", dict.getCode());
        invoke(target, "set" + name + "Name", dict.getName());
    }

    /**
     * 為target對象對應的字段設置枚舉值
     *
     * @param dictService  枚舉對象
     * @param target    設置值的對象
     * @param fieldName 設置值的字段
     */
    public static void setDict(DictService dictService, Object target, String fieldName) {
        Dict dict = dictService.dict();
        String name = StringUtils.toUpperCaseFirstOne(fieldName);
        name = name.split("Enum")[0];
        invoke(target, "set" + name + "Id", dict.getId());
        invoke(target, "set" + name + "Code", dict.getCode());
        invoke(target, "set" + name + "Name", dict.getName());
    }

    /**
     * 通過class獲取類汎型類型
     *
     * @param c class
     * @return Type[]
     */
    public static Type[] types(Class c) {
        return ((ParameterizedType) c.getGenericSuperclass()).getActualTypeArguments();
    }

    /**
     * 反射調用對象的指定方法
     *
     * @param target     被調用對象實例
     * @param methodName 指定方法名
     * @param args       方法參數值（多個）
     * @param <Target>   被調用對象汎型
     * @return Object，異常返回空
     */
    public static <Target> Object invoke(Target target, String methodName, Object... args) {
        try {
            if (args == null) {
                return target.getClass().getMethod(methodName).invoke(target);
            }
            Class[] classes = new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                classes[i] = args[i].getClass();
            }
            return target.getClass().getMethod(methodName, classes).invoke(target, args);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 复制对象
     *
     * @param source      被复制对象
     * @param targetClass 复制生成对象的class
     * @param <Source>    被复制对象汎型
     * @param <Target>    复制生成对象汎型
     * @return Target
     */
    public static <Source, Target> Target copy(Source source, Class<Target> targetClass) {
        return copy(source, targetClass, null);
    }

    /**
     * 复制对象列表
     *
     * @param sourceList  被复制对象列表
     * @param targetClass 复制生成对象的class
     * @param <Source>    被复制对象汎型
     * @param <Target>    复制生成对象汎型
     * @return List<Target>
     */
    public static <Source, Target> List<Target> copy(List<Source> sourceList, Class<Target> targetClass) {
        return copy(sourceList, targetClass, null);
    }

    /**
     * 复制对象分页
     *
     * @param sourcePage  被复制对象分页
     * @param targetClass 复制生成对象的class
     * @param <Source>    被复制对象汎型
     * @param <Target>    复制生成对象汎型
     * @return IPage<Target>
     */
    public static <Source, Target> IPage<Target> copy(IPage<Source> sourcePage, Class<Target> targetClass) {
        return copy(sourcePage, targetClass, null);
    }

    /**
     * 复制对象
     *
     * @param source           被复制对象
     * @param targetClass      复制生成对象的class
     * @param ignoreProperties 不参与复制的字段
     * @param <Source>         被复制对象汎型
     * @param <Target>         复制生成对象汎型
     * @return Target
     */
    public static <Source, Target> Target copy(Source source, Class<Target> targetClass, String... ignoreProperties) {
        if (source == null) {
            return null;
        }
        Target target = instantiateClass(targetClass);
        copyProperties(source, target, ignoreProperties);
        return target;
    }

    /**
     * 复制对象列表
     *
     * @param sourceList       被复制对象列表
     * @param targetClass      复制生成对象的class
     * @param ignoreProperties 不参与复制的字段
     * @param <Source>         被复制对象汎型
     * @param <Target>         复制生成对象汎型
     * @return List<Target>
     */
    public static <Source, Target> List<Target> copy(List<Source> sourceList, Class<Target> targetClass, String... ignoreProperties) {
        if (sourceList == null) {
            return null;
        }
        List<Target> targetList = new ArrayList<>();
        for (Source source : sourceList) {
            Target target = copy(source, targetClass, ignoreProperties);
            targetList.add(target);
        }
        return targetList;
    }

    /**
     * 复制对象分页
     *
     * @param sourcePage       被复制对象分页
     * @param targetClass      复制生成对象的class
     * @param ignoreProperties 不参与复制的字段
     * @param <Source>         被复制对象汎型
     * @param <Target>         复制生成对象汎型
     * @return List<Target>
     */
    public static <Source, Target> IPage<Target> copy(IPage<Source> sourcePage, Class<Target> targetClass, String... ignoreProperties) {
        if (sourcePage == null) {
            return null;
        }
        List<Source> sourceList = sourcePage.getRecords();
        List<Target> targetList = copy(sourceList, targetClass, ignoreProperties);
        Page<Target> targetPage = new Page<>(sourcePage.getCurrent(), sourcePage.getSize());
        targetPage.setTotal(sourcePage.getTotal());
        targetPage.setPages(sourcePage.getPages());
        targetPage.setRecords(targetList);
        return targetPage;
    }
}
