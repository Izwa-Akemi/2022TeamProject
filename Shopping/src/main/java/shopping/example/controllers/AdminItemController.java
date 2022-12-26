package shopping.example.controllers;

import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import shopping.example.models.entity.CategoryEntity;
import shopping.example.models.entity.ItemEntity;
import shopping.example.services.AdminService;
import shopping.example.services.ItemService;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminItemController {
    @Autowired
    AdminService adminService;

    @Autowired
    ItemService itemService;

    private static final Logger log = LoggerFactory.getLogger(AdminItemController.class);

    @RequestMapping("/item/list")
    public String itemListPage(Map<String,Object> map) {
        List<ItemEntity> itemList = adminService.getAllItems();
        map.put("itemList",itemList);
        List<CategoryEntity> categoryList = adminService.getAllCategories();
        map.put("categoryList",categoryList);
        return "admin_itemsList.html";
    }

    @RequestMapping("/item/add")
    public String addItemPage(Map<String,Object> map){
        List<CategoryEntity> categoryList = adminService.getAllCategories();
        map.put("categoryList",categoryList);
        return "admin_addGoods.html";
    }

    @PostMapping("/item/addItem")
    public String addItem(@RequestParam("goodsName") String goodsName, @RequestParam("category") int cateId, @RequestParam("image") MultipartFile image, @RequestParam("price") int price,
                          @RequestParam("desc") String desc, @RequestParam("stock") int stock,
                          Model model, HttpSession session) {

        String fileName = image.getOriginalFilename();
//        log.debug("goodsName:{},stock:{}",goodsName,stock);
//        log.debug("cateId:{}",cateId);
        try {
            File itemimgFile = new File("./src/main/resources/static/img/item-image/"+fileName);
            byte[] bytes = image.getBytes();
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(itemimgFile));
            out.write(bytes);
            out.close();
            String username = (String) session.getAttribute("admin_name");
//            log.debug("get:{}",session.getAttribute("admin_name"));
//            log.debug("username:{}",username);
            int adminId = adminService.getAdminId(username);
//            log.debug("adminId:{}",adminId);
            itemService.insert(goodsName, cateId, fileName, price, stock, desc, adminId);
        }catch(Exception e) {
            e.printStackTrace();
        }
        return "redirect:/admin/item/list";
    }

    @PostMapping("/item/editItem/{itemId}")
    public String editItem(@RequestParam("goodsName") String goodsName, @RequestParam("category") int cateId, @RequestParam("image") MultipartFile image, @RequestParam("price") int price,
                           @RequestParam("desc") String desc, @RequestParam("stock") int stock,
                           Model model, HttpSession session) {

        String fileName = image.getOriginalFilename();
//        log.debug("goodsName:{},stock:{}",goodsName,stock);
//        log.debug("cateId:{}",cateId);
        try {
            File itemimgFile = new File("./src/main/resources/static/img/item-image/"+fileName);
            byte[] bytes = image.getBytes();
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(itemimgFile));
            out.write(bytes);
            out.close();
            String username = (String) session.getAttribute("admin_name");
//            log.debug("get:{}",session.getAttribute("admin_name"));
//            log.debug("username:{}",username);
            int adminId = adminService.getAdminId(username);
//            log.debug("adminId:{}",adminId);
            itemService.insert(goodsName, cateId, fileName, price, stock, desc, adminId);
        }catch(Exception e) {
            e.printStackTrace();
        }
        return "redirect:/admin/item/list";
    }

    @RequestMapping("/item/editItem/{itemId}")
    public String editPageView(@PathVariable Long itemId, Model model){
        ItemEntity items = itemService.findByItemId(itemId);
        List<CategoryEntity> categoryList = adminService.getAllCategories();
        model.addAttribute("items",items);
        model.addAttribute("categoryList",categoryList);
        return "admin_editGoods.html";
    }

    @GetMapping("/item/{itemId}")
    public String itemView(@PathVariable Long itemId, Model model) {
        ItemEntity items = itemService.findByItemId(itemId);

        model.addAttribute("items",items);

        return "Goods_view.html";
    }

    @RequestMapping("/item/deleteItem/{itemId}")
    public String deleteItem(@PathVariable Long itemId){
        log.debug("itemId:",itemId);
        itemService.deletItem(itemId);
        return "redirect:/admin/item/list";
    }

    @RequestMapping("/stock")
    public String stockListPage(Map<String,Object> map) {
        List<ItemEntity> itemList = adminService.getAllItems();
        map.put("itemList",itemList);
        return "admin_stockList";
    }
}