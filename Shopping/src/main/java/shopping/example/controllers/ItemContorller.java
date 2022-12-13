package shopping.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import shopping.example.models.entity.ItemEntity;
import shopping.example.services.ItemService;
import shopping.example.services.UserService;

@Controller
public class ItemContorller {
	@Autowired
	private UserService userService;
	
	@Autowired
	ItemService itemService;
	
	//homepageの表示（ログイン操作無し）
	@GetMapping("/homepage")
	public String getHomePage(Model model) {
		List<ItemEntity>itemList =itemService.selectByAll();
		
		model.addAttribute("itemList",itemList);
		
		return "homepage.html";
	}
	
	
	
	
	
	
	
}
