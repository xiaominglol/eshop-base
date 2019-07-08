package com.gemini.cloud.framework.web.config;

import com.gemini.cloud.framework.web.exception.CloudCoreException;
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
