package shopping.example.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import shopping.example.models.entity.CategoryEntity;
import shopping.example.services.AdminService;

import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/admin")
public class AdminCategoryController {

    @Autowired
    AdminService adminService;
    private static final Logger log = LoggerFactory.getLogger(AdminGoodsController.class);

    @RequestMapping("category")
    public String categoryLists(Map<String,Object> map, Model model){
        log.debug("view category list");
        List<CategoryEntity> categoryList = adminService.getAllCategories();
        map.put("categoryList",categoryList);
        model.addAttribute("categoryList",categoryList);
        log.debug("cList:",categoryList);
        return "admin_categoryList.html";
    }

}
