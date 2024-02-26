package com.alphonse.banque.repositories;

import java.util.List;

import com.alphonse.banque.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

    User findByUsername(String username);

    User findByLogin(String login);
   List <User> findByRoleCode(String code);

/*    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);*/
}
