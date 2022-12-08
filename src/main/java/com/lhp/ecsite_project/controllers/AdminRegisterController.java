package com.lhp.ecsite_project.controllers;

import com.lhp.ecsite_project.services.AdminAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("admin")
public class AdminRegisterController {
    @Autowired
    private AdminAccountService adminAccountService;

    @GetMapping("/register")
    public ModelAndView getRegisterPage(ModelAndView mav) {
        mav.addObject("error",false);
        mav.setViewName("register.html");
        return mav;
    }

    @PostMapping("/register")
    public ModelAndView register(@RequestParam String username,
                                 @RequestParam String password, ModelAndView mav) {
        if(adminAccountService.createAdminAccount(username, password)){
            mav.addObject("error",false);
            mav.setViewName("login.html");
        } else {
            mav.addObject("error",true);
            mav.setViewName("register.html");
        }
        return mav;

    }
}
