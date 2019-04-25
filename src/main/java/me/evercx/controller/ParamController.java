package me.evercx.controller;


import me.evercx.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletContext;


/*
* 请求参数绑定
* */
@Controller
@RequestMapping("/param")
public class ParamController {

    @RequestMapping("/testParam")
    public String testParam(String username){
        System.out.println("exc...");
        System.out.println("username: " + username);

        return "success";
    }



    @RequestMapping("/saveAccount")
    public String saveAccount(Account account){
        System.out.println("exc...");
        System.out.println(account);

        return "success";
    }

    @RequestMapping("/saveUser")
    public String saveUser(HttpServletRequest request, User user){
        System.out.println("exc...");
        System.out.println(user);

        System.out.println(request);
        HttpSession session = request.getSession();
        System.out.println(session);

        ServletContext servletContext = session.getServletContext();
        System.out.println(servletContext);
        return "success";
    }

}

