package shopping.example.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import shopping.example.models.entity.CartEntity;
import shopping.example.models.entity.CartHistoryAndItemEntity;
import shopping.example.models.entity.CartHistoryEntity;
import shopping.example.models.entity.UserEntity;
import shopping.example.services.CartHistoryService;
import shopping.example.services.CartService;

@Controller
public class CartController {
	@Autowired
	HttpSession session;
	@Autowired
	CartService cartService;

	@Autowired
	CartHistoryService cartHistoryService;

	@GetMapping("/cart")
	public String getCartPage(Model model) {
		UserEntity userEntity = (UserEntity) session.getAttribute("user");
		
		Long userId = userEntity.getUserId();
		
		List<CartEntity> cart = cartService.selectByUserId(userId);
		
		//現在の時刻の取得
		Date nowDate  = new Date();
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String cartDate = date.format(nowDate);
		Long cartId;
		
		if(cart.isEmpty()) {
			//cartテーブルにユーザIDと現在時刻を追加する。
			cartService.insert(userId, cartDate);
			//ユーザIDを用いて、cartテーブルから、追加したばかりのカート情報を取得する。
			//cartテーブルのcartIdはAuto_Incrementにより自動生成されるため、ここで取得する。
			List<CartEntity>carts = cartService.selectByUserId(userId);
			//ユーザIdに紐づくカートは常に一つであるため、0番目の要素からカートIdを取得する。
			//ログアウト時や、商品購入時に、cart_historyやcartテーブルからカート情報は削除される
			cartId = carts.get(0).getCartId();

		}else {
			//もともとカート情報があれば、そのままカート情報を取得する。
			cartId = cart.get(0).getCartId();
		}
		
		//カートIDを指定して、cart_historyテーブルから商品情報のリストを取得する。
		List<CartHistoryAndItemEntity>newList = cartHistoryService.selectByCartId(cartId);
		
		UserEntity user = (UserEntity) session.getAttribute("user");
		String loginUserName = user.getUserName();
		
		model.addAttribute("loginUserName",loginUserName);
		model.addAttribute("newList", newList);
		model.addAttribute("cartId", cartId);
		
		return "cart.html";
	}
	

	

	@PostMapping("/addcart")
	public String AddCart(@RequestParam Long itemId, Model model) {

		UserEntity userEntity = (UserEntity) session.getAttribute("user");
		Long userId = userEntity.getUserId();
		List<CartEntity> cart = cartService.selectByUserId(userId);
		Date nowDate = new Date();
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String cartDate = date.format(nowDate);
		Long cartId;

		if (cart.isEmpty()) {
			// cartテーブルにユーザIDと現在時刻を追加する。
			cartService.insert(userId, cartDate);
			// ユーザIDを用いて、cartテーブルから、追加したばかりのカート情報を取得する。
			// cartテーブルのcartIdはAuto_Incrementにより自動生成されるため、ここで取得する。
			List<CartEntity> carts = cartService.selectByUserId(userId);
			// ユーザIdに紐づくカートは常に一つであるため、0番目の要素からカートIdを取得する。
			// ログアウト時や、商品購入時に、cart_historyやcartテーブルからカート情報は削除される
			cartId = carts.get(0).getCartId();

		} else {
			// もともとカート情報があれば、そのままカート情報を取得する。
			cartId = cart.get(0).getCartId();
		}
		// もともとのカートにある商品情報を取得
		List<CartHistoryEntity> currentlist = cartHistoryService.selectByCartIdAndItemId(cartId, itemId);
		int currentNum;
		
		// 新規にカートに対して商品を追加する場合（カート内が空の場合）
		if (currentlist.isEmpty()) {
			// カートへの追加ボタンでは1個のみ追加されるため、currentNumに1をセットする。
			currentNum = 1;
			// cart_historyテーブルに、カートに追加する商品情報をINSERTする。
			cartHistoryService.insert(itemId, currentNum, cartId);
		} else {
			// カートに既にほかの商品が入っている場合、その商品の個数を+1する。
			currentNum = currentlist.get(0).getNum() + 1;
			// cart_historyから、当該商品の情報を取得
			CartHistoryEntity entity = currentlist.get(0);
			// Entityに、更新後の個数をセットする。
			entity.setNum(currentNum);
			// cart_historyテーブルに更新をかける。cart_history_idが設定されているので、
			// INSERTではなくUPDATEがかかるようになっている。
			cartHistoryService.update(entity);

		}
		

		return "redirect:/cart";
	}

	@PostMapping("/cartchange")
	public String chagCart(@RequestParam int num,@RequestParam Long itemId,@RequestParam Long cartId) {
	// cart_historyテーブルから、カートIDと商品IDを指定して、カート内の商品情報を取得する。
	CartHistoryEntity cartHistoryEntity = cartHistoryService.selectByCartIdAndItemId(cartId, itemId).get(0);
	//商品情報に対して、個数を更新させる。
	 cartHistoryEntity.setNum(num);
	 //そしてcart_historyテーブルへ、商品情報の更新をする。
	 cartHistoryService.insert(cartHistoryEntity);
	 
	 return "redirect:/cart";
	
}
	
	@PostMapping("/delete")
	public String deleteCart(@RequestParam Long itemId,@RequestParam Long cartId) {
		CartHistoryEntity cartHistoryEntity = cartHistoryService.selectByCartIdAndItemId(cartId, itemId).get(0);
		//商品情報に対して、個数を更新させる。
		 cartHistoryEntity.setNum(0);
		 //そしてcart_historyテーブルへ、商品情報の更新をする。
		 cartHistoryService.insert(cartHistoryEntity);
		 
		 return "redirect:/cart";
		
	}

}
