package shopping.example.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import shopping.example.services.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminItemController {
    @Autowired
    AdminService adminService;

    private static final Logger log = LoggerFactory.getLogger(AdminItemController.class);

    @RequestMapping("/item/list")
    public String itemListPage() {
        log.debug("view item list page");
        return "admin_itemsList.html";
    }
}