package shopping.example.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import jakarta.transaction.Transactional;
import shopping.example.models.entity.ItemEntity;

public interface ItemDao extends JpaRepository<ItemEntity, Long> {
	// 商品の内容を保存
	ItemEntity save(ItemEntity itemEntity);

	// Idを使用してDBに検索をかける
	ItemEntity findByItemId(Long itemId);

	// すべての商品情報を取得
	List<ItemEntity> findAll();

	//List<ItemEntity> findByCategoryId(int categoryId);

	// Idを取得して該当する情報を削除する
	@Transactional
	List<ItemEntity> deleteByItemId(Long itemId);

}
