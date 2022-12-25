package shopping.example.controllers;

import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import shopping.example.services.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminRegisterController {
    @Autowired
    private AdminService adminService;

    private static final Logger log = LoggerFactory.getLogger(AdminRegisterController.class);

    @RequestMapping("register")
    public String registerPage(){
        log.debug("view register page");
        return "admin_register";
    }

    @PostMapping("/register")
    public String register(@RequestParam("username") String username,
                           @RequestParam("password") String password,
                           HttpSession session) {
        log.debug("username:{},password:{}", username,password);
        try {
            if (adminService.createAdminAccount(username, password)) {
                log.debug("create account yes");
                session.setAttribute("admin_name", username);
                session.setAttribute("password", password);
            }
        }catch (Exception e){
            e.printStackTrace();
            return "admin_register.html";
        }
        return "redirect:admin/item/list";
    }
}