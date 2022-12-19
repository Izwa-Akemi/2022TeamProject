package shopping.example.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import shopping.example.services.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminLoginController {
    @Autowired
    AdminService adminService;

    private static final Logger log = LoggerFactory.getLogger(AdminGoodsController.class);

    @RequestMapping("login")
    public String loginPage() {
        log.debug("view login page");
        return "admin_login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model) {
        log.debug("username:{},password:{}", username,password);
        try {
            if (adminService.validateAdminAccount(username, password)) {
                log.debug("validate yes");
                model.addAttribute("admin_name", username);
                model.addAttribute("password", password);
            }
        }catch (Exception e){
            e.printStackTrace();
            return "admin_login";
        }
        return "admin_itemsList";
    }

}
