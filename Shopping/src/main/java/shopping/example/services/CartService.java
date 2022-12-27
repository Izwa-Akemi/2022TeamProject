package shopping.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shopping.example.models.dao.CartDao;
import shopping.example.models.entity.CartEntity;


@Service
public class CartService {

	@Autowired
	CartDao cartDao;
	
	public List<CartEntity> selectByUserId(Long userId){
		
		return cartDao.findByUserId(userId);
	}
	//内容を保存
	public void insert(Long userId,String cartDate) {
		cartDao.save(new CartEntity(userId,cartDate));
	}
	
	// 削除
	public List<CartEntity>deleteCart(Long cartId){
		return cartDao.deleteByCartId(cartId);
	}
}
