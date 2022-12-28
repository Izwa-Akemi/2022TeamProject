package shopping.example.controllers;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpSession;
import shopping.example.models.entity.CartEntity;
import shopping.example.models.entity.CartHistoryAndItemEntity;
import shopping.example.models.entity.CartHistoryEntity;
import shopping.example.models.entity.OrderEntity;
import shopping.example.models.entity.UserEntity;
import shopping.example.services.CartHistoryService;
import shopping.example.services.CartService;
import shopping.example.services.ItemService;
import shopping.example.services.OrderService;
import shopping.example.services.UserService;

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

	@Autowired
	CartService cartService;
	
	@Autowired
	UserService userService;

	@GetMapping("/order")
	public String Order(Model model) {
		UserEntity userEntity = (UserEntity) httpSession.getAttribute("user");
		Long userId = userEntity.getUserId();

		List<CartEntity> cart = cartService.selectByUserId(userId);
		Long cartId;
		cartId = cart.get(0).getCartId();
		List<CartHistoryAndItemEntity> newList = cartHistoryService.selectByCartId(cartId);

		model.addAttribute("newList", newList);
		return "order.html";
	}

	@PostMapping("/pay")
	public String addItem(@RequestParam String zip_code, @RequestParam String address,
			Model model) {
		UserEntity userEntity = (UserEntity) httpSession.getAttribute("user");

		Long userId = userEntity.getUserId();
		
		userService.update(userId, zip_code, address);
		
		return "pay.html";
	}

	@PostMapping("/ordersucceed")
	public String OrderRegister(Model model) {
		UserEntity userEntity = (UserEntity) httpSession.getAttribute("user");
		Long userId = userEntity.getUserId();

	
		
		return "order_succeed.html";
	}
		
	
	
}
