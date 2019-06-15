package com.gemini.cloud;

/**
 * 核心接口
 * @author 小明不读书
 */
public interface CloudCore {
    static CloudCore buid() {
        return new CloudCoreImpl();
    }

    /**
     * 绑定指定类启动,klass与spring boot类似
     *
     * @param klass 绑定类
     * @param args  -D标记的jvm参数
     * @return
     * @throws CloudCoreException
     */
    Class<?> run(Class<?> klass, String[] args) throws CloudCoreException;
}
