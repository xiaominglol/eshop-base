package com.gemini.boot.framework.core.config.impl;

import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLParser;
import com.gemini.boot.framework.core.config.ConfigPropertiesResolver;
import com.gemini.boot.framework.core.exception.CloudCoreException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Properties;

public class ConfigPropertiesResolverImpl implements ConfigPropertiesResolver {
    static Logger LOG = LoggerFactory.getLogger(ConfigPropertiesResolverImpl.class);
    private static final String ENCODING = "utf-8";

    @Override
    public Properties buildProperties(List<Resource> resources) throws CloudCoreException {
        LOG.info("》》》yml转换为properties start《《《");
        Properties properties = new Properties();
        for(Resource resource : resources){
            try {
                InputStream inputStream = resource.getInputStream();
                properties.putAll(ymlToProperties(inputStream));
            } catch (IOException e) {
                throw new CloudCoreException("yml转换为properties error", e);
            }
        }
        LOG.info("application-cloud-*.xml:"+properties.toString());
        LOG.info("》》》yml转换为properties end《《《");
        return properties;
    }

    /**
     * yml转换为properties
     * @param inputStream   yml的输入流
     * @return              properties
     */
    public static Properties ymlToProperties(InputStream inputStream) {
        Properties properties = new Properties();
        final String DOT = ".";
        try {
            YAMLFactory yamlFactory = new YAMLFactory();
            YAMLParser parser = yamlFactory.createParser(
                    new InputStreamReader(inputStream, Charset.forName(ENCODING)));

            String key = "";
            String value = null;
            JsonToken token = parser.nextToken();
            while (token != null) {
                if (JsonToken.START_OBJECT.equals(token)) {
                    // do nothing
                } else if (JsonToken.FIELD_NAME.equals(token)) {
                    if (key.length() > 0) {
                        key = key + DOT;
                    }
                    key = key + parser.getCurrentName();

                    token = parser.nextToken();
                    if (JsonToken.START_OBJECT.equals(token)) {
                        continue;
                    }
                    value = parser.getText();
                    properties.put(key,value);

                    int dotOffset = key.lastIndexOf(DOT);
                    if (dotOffset > 0) {
                        key = key.substring(0, dotOffset);
                    }
                    value = null;
                } else if (JsonToken.END_OBJECT.equals(token)) {
                    int dotOffset = key.lastIndexOf(DOT);
                    if (dotOffset > 0) {
                        key = key.substring(0, dotOffset);
                    } else {
                        key = "";
                    }
                }
                token = parser.nextToken();
            }
            parser.close();
        } catch (Exception e) {
            throw new RuntimeException("yml转换为properties异常",e);
        }
        return properties;
    }
}
