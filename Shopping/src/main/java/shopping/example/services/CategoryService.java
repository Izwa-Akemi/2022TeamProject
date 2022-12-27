package shopping.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shopping.example.models.dao.CategoryDao;
import shopping.example.models.entity.CategoryEntity;

import java.util.List;

@Service
public class CategoryService {
	@Autowired
	CategoryDao categoryDao;

//	// 内容を保存
//	public void insert(String itemName, int cateId, String image, int price, int stock, String detail,
//			Integer adminId) {
//		itemDao.save(new ItemEntity(itemName, cateId, image, price, stock, detail, adminId));
//	}
//
//	// 内容を更新
//	public void upate(Long itemId, String itemName, int cateId, String image, int price, int stock, String detail,
//			int active, int adminId) {
//		itemDao.save(new ItemEntity(itemId, itemName, cateId, image, price, stock, detail, active, adminId));
//	}

	// 削除
	public List<CategoryEntity> deleteCategory(long categoryId) {
		return categoryDao.deleteByCateId(categoryId);
	}

}
