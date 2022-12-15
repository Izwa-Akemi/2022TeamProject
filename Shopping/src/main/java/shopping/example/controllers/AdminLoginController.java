package shopping.example.controllers;

import shopping.example.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminLoginController {
    @Autowired
    AdminService adminService;

    @PostMapping("/admin/login")
    public ModelAndView login(String username,
                              @RequestParam String password,
                              ModelAndView mav) {
        if (adminService.validateAdminAccount(username,password)){
            mav.addObject("name",username);
            mav.setViewName("admin_itemsList.html");
        } else {
            mav.setViewName("admin_login.html");
        }
        return mav;
    }

}
