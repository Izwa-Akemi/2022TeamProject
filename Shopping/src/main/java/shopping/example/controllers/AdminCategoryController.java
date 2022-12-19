package shopping.example.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/admin")
public class AdminCategoryController {
    private static final Logger log = LoggerFactory.getLogger(AdminGoodsController.class);

    @RequestMapping("/category/list")
    public String goodsLists(){
        log.debug("view category list");
        return "admin_categoryList.html";
    }

    @PostMapping("/category/add")
    public String addCategory(){
        log.debug("add category");
        return "admin_addCategory.html";
    }

    @PostMapping("/category/edit")
    public String editCategory() {
        log.debug("edit category");
        return "admin_editCategory.html";
    }

}
