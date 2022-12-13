package shopping.example.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/admin")
public class AdminCategoryController {
    private static final Logger log = LoggerFactory.getLogger(AdminGoodsController.class);

    @RequestMapping("category")
    public String goodsLists(){
        log.debug("view category list");
        return "admin_categoryList";
    }
}
