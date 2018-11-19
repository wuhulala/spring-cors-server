package com.github.wuhulala.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wuhulala
 *
 * <p>
 *     <code>@CrossOrigin</code> 里面的value必须是 协议（http/https）：ip(或者域名)：port
 * </p>
 */
@CrossOrigin("https://localhost")
@RestController
@RequestMapping("/api")
public class RestDemoController {
    @RequestMapping("/hello")
    public Map demo(){
        Map map = new HashMap();
        map.put("message",1000);
        map.put("code",200);
        return map;
    }

}
