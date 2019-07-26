package com.gemini.cloud.framework.core.resources;

import com.gemini.cloud.framework.core.exception.CloudCoreException;
import com.gemini.cloud.framework.core.resources.impl.SpringPatternPatResourceLoaderResolver;
import org.springframework.core.io.Resource;

import java.util.List;

/**
 * 资源分析加载结构
 * 
 * @author chenkui
 *
 */
public interface ResourceLoaderResolver {

	/**
	 * 获取配置文件路径
	 * 
	 * @return
	 */
	List<Resource> getConfigResources();

	static ResourceLoaderResolver build() throws CloudCoreException {
		synchronized (SpringPatternPatResourceLoaderResolver.class) {
			if (null == Resolver.resolver) {
				synchronized (SpringPatternPatResourceLoaderResolver.class) {
					Resolver.resolver = new SpringPatternPatResourceLoaderResolver().BuildResource();
				}
			}
			return Resolver.resolver;
		}
	}

	static void clean() {
		Resolver.resolver = null;
	}
}

class Resolver {
	static volatile ResourceLoaderResolver resolver;
}
