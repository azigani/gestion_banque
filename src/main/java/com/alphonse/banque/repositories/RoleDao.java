package com.alphonse.banque.repositories;

import com.alphonse.banque.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDao extends JpaRepository<Role, Long> {
//    @Query(value = "SELECT r FROM roles r WHERE r.code = :code", nativeQuery = true)
    Role findRoleByCode(String code);
}
