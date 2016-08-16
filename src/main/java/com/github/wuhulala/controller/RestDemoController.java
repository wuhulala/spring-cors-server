package com.github.wuhulala.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xueaohui
 */
@CrossOrigin("http://127.0.0.1")
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
