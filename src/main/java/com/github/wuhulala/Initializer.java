package com.github.wuhulala;

import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;

/**
 * @author wuhulala
 * @date 2016-10-19
 * @description
 */
public class Initializer extends AbstractHttpSessionApplicationInitializer {

    public Initializer() {
        super(SpringSessionConfig.class);
    }
}
