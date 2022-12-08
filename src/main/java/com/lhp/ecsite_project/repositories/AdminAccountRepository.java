package com.lhp.ecsite_project.repositories;

import com.lhp.ecsite_project.models.AdminAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminAccountRepository extends JpaRepository<AdminAccount, Long> {
    AdminAccount findByUsername(String username);
    AdminAccount save(AdminAccount adminAccount);
}
