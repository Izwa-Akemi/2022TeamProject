package shopping.example.controllers;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import shopping.example.models.entity.ItemEntity;
import shopping.example.services.ItemService;
import shopping.example.services.UserService;

@Controller
public class ItemController {
	@Autowired
	private UserService userService;
	
	@Autowired
	ItemService itemService;
	

	@GetMapping("/homepage")
	public String getHomePage(Model model) {
		List<ItemEntity>itemList =itemService.selectByAll();
		
		model.addAttribute("itemList",itemList);
		
		return "homepage.html";
	}
	
	

	@GetMapping("/item/add")
	public String addItem(){
		return "/admin/addGoods1.html";
	}
	
	@PostMapping("/item/addItem")
	public String addItem(@RequestParam String goodsName, @RequestParam("image") MultipartFile image,@RequestParam int price,@RequestParam String desc,@RequestParam int stock,Model model) {
	
		String fileName = image.getOriginalFilename();
		try {
			File itemimgFile = new File("./src/main/resources/static/img/item-image/"+fileName);
			byte[] bytes = image.getBytes();
			BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(itemimgFile));
			out.write(bytes);
			out.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		itemService.insert(goodsName, 0, fileName, price, stock, desc, 1);
		return "redirect:/homepage";
	}
	
	@GetMapping("/item/{itemId}")
	public String itemView(@PathVariable Long itemId,Model model) {
		ItemEntity items = itemService.findByItemId(itemId);
		
		model.addAttribute("items",items);	
		
		return "Goods_view.html";
	}

	

	
	
}
