package com.ck.web.common.param;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.util.Properties;

/**
 * 自定义配置信息
 * Created by ChengK on 2016/12/8 0008.
 */
public class CustomizedPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {

    protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props) throws BeansException {
        super.processProperties(beanFactoryToProcess, props);
        for (Object key : props.keySet()) {
            String keyStr = key.toString();
            String value = props.getProperty(keyStr);
            Porperty.setProperty(keyStr, value);
        }
    }
}
