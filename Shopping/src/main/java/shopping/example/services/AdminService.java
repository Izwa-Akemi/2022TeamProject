package shopping.example.services;

import shopping.example.models.dao.AdminDao;
import shopping.example.models.entity.AdminAccountEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    private AdminDao adminDao;

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
}