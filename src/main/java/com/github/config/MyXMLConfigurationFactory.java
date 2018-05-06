package com.github.config;

import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.ConfigurationFactory;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Order;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.xml.XmlConfiguration;
import org.apache.logging.log4j.util.LoaderUtil;

import java.net.URI;

/**
 * Created by jianghang on 2018/5/6.
 */
@Plugin(name = "MyXMLConfigurationFactory", category = ConfigurationFactory.CATEGORY)
@Order(30)
public class MyXMLConfigurationFactory extends ConfigurationFactory {

    @Override
    protected String[] getSupportedTypes() {
        return new String[]{".xml", "*"};
    }

    @Override
    public Configuration getConfiguration(LoggerContext loggerContext, ConfigurationSource source) {
        return new XmlConfiguration(loggerContext,source);
    }

    @Override
    public Configuration getConfiguration(LoggerContext loggerContext, String name, URI configLocation) {
        ClassLoader loader = LoaderUtil.getThreadContextClassLoader();
        ConfigurationSource source = ConfigurationSource.fromResource("log4j2.xml", loader);
//        ConfigurationSource source = ConfigurationSource.fromUri(configLocation);

        return new XmlConfiguration(loggerContext,source);
    }
}