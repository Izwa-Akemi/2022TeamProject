package shopping.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shopping.example.models.dao.ItemDao;
import shopping.example.models.entity.ItemEntity;

@Service
public class ItemService {
	@Autowired
	ItemDao itemDao;

	// 内容を保存
	public void insert(String itemName, int cateId, String image, int price, int stock, String detail,
			Integer adminId) {
		itemDao.save(new ItemEntity(itemName, cateId, image, price, stock, detail, adminId));
	}

	// 内容を更新
	public void upate(Long itemId, String itemName, int cateId, String image, int price, int stock, String detail,
			int active, int adminId) {
		itemDao.save(new ItemEntity(itemId, itemName, cateId, image, price, stock, detail, active, adminId));
	}

	// 商品詳細
	public ItemEntity findByItemId(Long itemId) {
		return itemDao.findByItemId(itemId);
	}

	// 商品一覧
	public List<ItemEntity> selectByAll() {
		return itemDao.findAll();
	}

	// 削除
	public List<ItemEntity> deletItem(Long itemId) {
		return itemDao.deleteByItemId(itemId);
	}

}
