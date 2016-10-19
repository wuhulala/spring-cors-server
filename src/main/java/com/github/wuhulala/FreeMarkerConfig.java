package com.github.wuhulala;

import freemarker.template.utility.XmlEscape;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;


import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author ucmed
 * @date 2016-10-19
 * @description
 */
@Configuration
public class FreeMarkerConfig extends WebMvcConfigurerAdapter {

    @Bean
    public FreeMarkerConfigurer getFreemarkerConfig() {
        FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
        configurer.setTemplateLoaderPath("/WEB-INF/views/");
        Properties properties = new Properties();
        properties.setProperty("template_update_delay","0");
        properties.setProperty("default_encoding","UTF-8");
        properties.setProperty("locale","zh_CN");
        properties.setProperty("datetime_format","yyyy-MM-dd HH:mm:ss");
        properties.setProperty("date_format","yyyy-MM-dd");
        properties.setProperty("time_format","HH:mm:ss");
        configurer.setFreemarkerSettings(properties);

        return configurer;
    }

    @Bean
    public FreeMarkerViewResolver getViewResolver() {
        FreeMarkerViewResolver viewResolver = new FreeMarkerViewResolver();
        viewResolver.setContentType("text/html; charset=UTF-8");
        viewResolver.setCache(true);
        viewResolver.setSuffix(".ftl");
        return viewResolver;
    }
}
