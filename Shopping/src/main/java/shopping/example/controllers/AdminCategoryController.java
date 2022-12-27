package shopping.example.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import shopping.example.models.entity.CategoryEntity;
import shopping.example.models.entity.ItemEntity;
import shopping.example.services.AdminService;
import shopping.example.services.CategoryService;

import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/admin")
public class AdminCategoryController {

    @Autowired
    AdminService adminService;

    @Autowired
    CategoryService categoryService;
    private static final Logger log = LoggerFactory.getLogger(AdminGoodsController.class);

    @RequestMapping("/category")
    public String categoryListPage(Map<String,Object> map, Model model){
        log.debug("view category list");
        List<ItemEntity> itemList = adminService.getAllItems();
        List<CategoryEntity> categoryList = adminService.getAllCategories();
        map.put("categoryList",categoryList);
        return "admin_categoryList";
    }

    @RequestMapping("/deleteCategory/{categoryId}")
    public String deleteCategory(@PathVariable Long categoryId){
        log.debug("categoryId:",categoryId);
        categoryService.deleteCategory(categoryId);
        return "redirect:/admin/category";
    }

}
