package shopping.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import shopping.example.services.AdminService;

@Controller
public class AdminRegisterController {
    @Autowired
    private AdminService adminAccountService;

    @GetMapping("/admin/register")
    public ModelAndView getRegisterPage(ModelAndView mav) {
        mav.addObject("error",false);
        mav.setViewName("register.html");
        return mav;
    }

    @PostMapping("/admin/register")
    public ModelAndView register(@RequestParam String username,
                                 @RequestParam String password, ModelAndView mav) {
        if(adminAccountService.createAdminAccount(username, password)){
            mav.addObject("error",false);
            mav.setViewName("admin_login.html");
        } else {
            mav.addObject("error",true);
            mav.setViewName("register.html");
        }
        return mav;

    }
}