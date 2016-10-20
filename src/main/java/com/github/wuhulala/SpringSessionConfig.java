package com.github.wuhulala;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;

/**
 * @author wuhulala
 * @date 2016-10-19
 * @description springsession 设置
 */
@Configuration
@EnableRedisHttpSession
public class SpringSessionConfig  {

    @Bean
    public JedisConnectionFactory connectionFactory() {
        JedisConnectionFactory connection = new JedisConnectionFactory();
        connection.setHostName("127.0.0.1");
        connection.setPort(6379);
        return connection;
    }
}
