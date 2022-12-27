package shopping.example.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import jakarta.servlet.http.HttpSession;
import shopping.example.services.CartHistoryService;
import shopping.example.services.ItemService;
import shopping.example.services.OrderService;

@Controller
public class OrderController {
	@Autowired 
	private OrderService orderService;
	
	@Autowired 
	private CartHistoryService cartHistoryService;
	@Autowired
	ItemService itemService;
	@Autowired 
	HttpSession httpSession;
	
}
