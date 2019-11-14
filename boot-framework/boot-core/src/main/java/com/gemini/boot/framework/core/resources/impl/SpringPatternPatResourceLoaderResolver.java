package com.gemini.boot.framework.core.resources.impl;

import com.gemini.boot.framework.core.exception.CoreException;
import com.gemini.boot.framework.core.resources.ResourceLoaderResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 加载并解析资源
 *
 * @author chenkui
 */

public class SpringPatternPatResourceLoaderResolver implements ResourceLoaderResolver {
    static Logger LOG = LoggerFactory.getLogger(SpringPatternPatResourceLoaderResolver.class);

    private ResourcePatternResolver resResolver;
    private String ConfigFilePath;
    private List<Resource> configResources;

    public SpringPatternPatResourceLoaderResolver() {
        resResolver = new PathMatchingResourcePatternResolver();
        ConfigFilePath = "classpath*:application-cloud-*.yml";
    }

    @Override
    public List<Resource> getConfigResources() {
        return configResources;
    }

    public ResourceLoaderResolver BuildResource() throws CoreException {
        LOG.info("》》》扫描默认yml配置 start《《《");

        try {
            configResources = Arrays.asList(resResolver.getResources(ConfigFilePath)).stream().filter(p -> p.exists()).collect(Collectors.toList());
        } catch (IOException e) {
            throw new CoreException("扫描默认yml配置 error", e);
        }

        LOG.info("》》》扫描默认yml配置 end《《《");
        return this;
    }

}
