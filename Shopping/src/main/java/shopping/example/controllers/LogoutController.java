package shopping.example.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


import jakarta.servlet.http.HttpSession;
import shopping.example.models.entity.CartEntity;
import shopping.example.models.entity.UserEntity;
import shopping.example.services.CartHistoryService;
import shopping.example.services.CartService;
import shopping.example.services.UserService;

@Controller
public class LogoutController {
	@Autowired
	UserService userService;
	@Autowired
	HttpSession session;
	@Autowired
	CartService cartService;
	@Autowired
	CartHistoryService cartHistoryService;
	
	//user_idをキーにして，cartからcart_idを取得．
	@GetMapping("/logout")
	public String logout() {
		//セッションを使用して、現在ログインしているユーザーの情報を取得する。
		UserEntity userEntity = (UserEntity) session.getAttribute("user");
//		//cartServiceクラスのselectByUserIdメソッドを使用して、該当するユーザー情報を取得する。
//		List<CartEntity>cartList = cartService.selectByUserId(userEntity.getUserId());
//		//もし、cartListが空でなかった場合
//		if(!cartList.isEmpty()) {
//			//cartHistoryServiceクラスのdeleteCartHistoryメソッドを使用して、該当するカート履歴情報を削除する。
//			cartHistoryService.deleteCartHistory(cartList.get(0).getCartId());
//			//cartServiceクラスのdeleteCartメソッドを使用して、該当するカート情報を削除する。
//			cartService.deleteCart(cartList.get(0).getCartId());
//		}
		//セッションの情報を削除する。
		session.invalidate();
		
		return "redirect:/homepage";
	}
	
}
