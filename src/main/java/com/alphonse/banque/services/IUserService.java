package com.alphonse.banque.services;


import com.alphonse.banque.models.Role;
import com.alphonse.banque.models.User;

import java.util.List;

public interface IUserService {

    User enregistrerUser(User user);

    User findById(Long id);

    List<User> listeUtilisateurs();

    User findUserByLogin(String login);

    List<User> findByRoleCode(String code);



}
