package com.lhp.ecsite_project.controllers;

import com.lhp.ecsite_project.services.AdminAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("admin")
public class AdminLoginController {
    @Autowired
    AdminAccountService adminAccountService;

    @PostMapping("/login")
    public ModelAndView login(@RequstParam String username,
                              @RequestParam String password,
                              ModelAndView mav) {
        if (adminAccountService.validateAdminAccount(username,password)){
            mav.addObject("name",username);
            mav.setViewName("goodsList.html");
        } else {
            mav.setViewName("login.html");
        }
        return mav;
    }

}
