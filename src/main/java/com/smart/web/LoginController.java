package com.smart.web;

import com.smart.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
    private UserService userService;

    @RequestMapping(value = "/index.html")
    public String loginPage(){
        return "login";
    }

    //@RequestMapping(value = "/loginCheck.html")
    //public String loginCheck(HttpServletRequest request, LoginC)
}
