package shopping.example.repositories;

import shopping.example.models.entity.AdminAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminAccountRepository extends JpaRepository<AdminAccountEntity, Long> {
	AdminAccountEntity findByUsername(String username);
	AdminAccountEntity save(AdminAccountEntity adminAccount);
}
