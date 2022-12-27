package shopping.example.services;

import shopping.example.models.dao.AdminDao;
import shopping.example.models.dao.CategoryDao;
import shopping.example.models.dao.ItemDao;
import shopping.example.models.entity.AdminAccountEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shopping.example.models.entity.CategoryEntity;
import shopping.example.models.entity.ItemEntity;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    private AdminDao adminDao;

    @Autowired
    private ItemDao itemDao;

    @Autowired
    private CategoryDao categoryDao;

    public boolean validateAdminAccount(String username, String password) {
        AdminAccountEntity adminAccount = adminDao.findByUsername(username);
        if (adminAccount == null || !adminAccount.getPassword().equals(password)) {
            return false;
        } else {
            return true;
        }
    }

    public boolean createAdminAccount(String username, String password) {
        if (adminDao.findByUsername(username) == null) {
        	adminDao.save(new AdminAccountEntity(username, password));
            return true;
        } else {
            return false;
        }
    }

    public int getAdminId(String username){
        AdminAccountEntity adminAccountEntity = adminDao.findByUsername(username);
        return adminAccountEntity.getId();
    }

    // admin goodsList page
    public List<ItemEntity> getAllItems() {
        return itemDao.findAll();
    }

    public List<CategoryEntity> getAllCategories() {
        return categoryDao.findAll();
    }

    // search by item name
    public List<ItemEntity> selectByItemName(String itemName) {
        return itemDao.findByItemName(itemName);
    }

    public List selectByCategoryId(Long cateId) {
        return itemDao.findByCateId(cateId);
    }
}