package com.gemini.cloud.framework.core.config;

import com.gemini.cloud.framework.core.exception.CloudCoreException;
import org.springframework.core.io.Resource;

import java.util.List;
import java.util.Properties;

/**
 * properties
 * 
 * @author chenkui
 *
 */
public interface ConfigPropertiesResolver {
	Properties buildProperties(List<Resource> resources) throws CloudCoreException;
}
