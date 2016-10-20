package com.github.wuhulala.controller.user;

import com.github.wuhulala.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author wuhulala
 * @date 2016-10-19
 * @description
 */
@Controller
public class UserController {


    @RequestMapping(value = "/home")
    public String home(Model model) {

        //create model
        Product baidu = new Product("https://www.baidu.com  ","baidu");
        Product sougou = new Product("https://www.sogou.com/","sougou");
        Product google = new Product("https://www.google.com","google");

        //create list
        List<Product> products = new ArrayList<>();
        products.add(baidu);
        products.add(sougou);
        products.add(google);

        //add some variable
        model.addAttribute("currentTime", new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(new Date()));
        model.addAttribute("aProduct",baidu);
        model.addAttribute("products",products);
        model.addAttribute("username","张三");
        model.addAttribute("nowDateTime",new Date());

        return "user/welcome";
    }
}
