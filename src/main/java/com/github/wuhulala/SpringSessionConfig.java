package com.github.wuhulala;

import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @author wuhulala
 * @date 2016-10-19
 * @description springsession 设置
 */

@EnableRedisHttpSession
public class SpringSessionConfig {

        @Bean
        public JedisConnectionFactory connectionFactory() {
            return new JedisConnectionFactory();
        }

}
