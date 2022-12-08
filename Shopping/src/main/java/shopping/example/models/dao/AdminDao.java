package shopping.example.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import shopping.example.models.entity.AdminAccountEntity;


public interface AdminDao extends JpaRepository<AdminAccountEntity, Long> {
	AdminAccountEntity findByUsername(String username);
	AdminAccountEntity save(AdminAccountEntity adminAccount);
}