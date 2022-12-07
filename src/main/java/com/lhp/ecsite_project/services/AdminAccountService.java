package com.lhp.ecsite_project.services;

import com.lhp.ecsite_project.models.AdminAccount;
import com.lhp.ecsite_project.repositories.AdminAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminAccountService {
    @Autowired
    AdminAccountRepository repository;

    public boolean validateAdminAccount(String username, String password) {
        AdminAccount adminAccount = repository.findByUsername(username);
        if (adminAccount == null || !adminAccount.getPassword().equals(password)) {
            return false;
        } else {
            return true;
        }
    }

    public boolean createAdminAccount(String username, String password) {
        if (repository.findByUsername(username) == null) {
            repository.save(new AdminAccount(username, password));
            return true;
        } else {
            return false;
        }
    }
}
