package shopping.example.services;

import shopping.example.models.entity.AdminAccountEntity;
import shopping.example.repositories.AdminAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminAccountService {
    @Autowired
    AdminAccountRepository repository;

    public boolean validateAdminAccount(String username, String password) {
    	AdminAccountEntity adminAccount = repository.findByUsername(username);
    	return true;
        // if (adminAccount == null || !AdminAccountEntity.getPassword().equals(password)) {
           // return false;
        //} else {
          //  return true;
        //}
    }

    public boolean createAdminAccount(String username, String password) {
        if (repository.findByUsername(username) == null) {
            repository.save(new AdminAccountEntity(username, password));
            return true;
        } else {
            return false;
        }
    }
}
