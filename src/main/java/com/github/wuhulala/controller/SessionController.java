package com.github.wuhulala.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * @author wuhulala
 * @date 2016-10-20
 * @description
 */
@Controller
@Scope("prototype")
public class SessionController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute("username") != null) {
            System.out.println("---------username exits-----------");
            return "redirect:home";
        }
        return "user/session";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, Model model, String username, String password) {
        String name = "admin";
        String pass = "123456";
        if(username.equals(name)){
            model.addAttribute("username",username);
            if(password.equals(pass)){
                request.getSession().setAttribute("username",username);
                return "redirect:home";
            }else {
                model.addAttribute("error", "密码错误");
            }
        }else{
            model.addAttribute("error","用户名不存在");
        }
        return "user/session";
    }
}
