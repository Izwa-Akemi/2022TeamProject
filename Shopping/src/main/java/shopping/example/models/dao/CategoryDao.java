package shopping.example.models.dao;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import shopping.example.models.entity.CategoryEntity;

import java.util.List;

public interface CategoryDao extends JpaRepository<CategoryEntity, Long> {
    CategoryEntity save(CategoryEntity categoryEntity);

    List<CategoryEntity> findAll();

    List<CategoryEntity> findByCateId(Long cateId);

    @Transactional
    List<CategoryEntity> deleteByCateId(Long cateId);

}
