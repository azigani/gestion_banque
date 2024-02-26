package com.alphonse.banque.services;


import com.alphonse.banque.models.Role;

import java.util.List;

public interface IServiceRole {

    Role enregistrerRole(Role role);

    Role findById(Long id);

    List<Role> listeRoles();

    Role findRoleByCode(String code);

}
