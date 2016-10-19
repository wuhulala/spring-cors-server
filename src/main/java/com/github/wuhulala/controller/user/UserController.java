package com.github.wuhulala.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author wuhulala
 * @date 2016-10-19
 * @description
 */
@Controller
public class UserController {

    @RequestMapping(value = "/")
    public String home(Model model) {
        model.addAttribute("currentTime", new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(new Date()));
        return "user/welcome";
    }
}
