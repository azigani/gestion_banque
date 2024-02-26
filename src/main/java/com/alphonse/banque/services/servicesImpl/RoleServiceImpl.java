package com.alphonse.banque.services.servicesImpl;

import com.alphonse.banque.models.Role;
import com.alphonse.banque.repositories.RoleDao;
import com.alphonse.banque.services.IServiceRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements IServiceRole {

    @Autowired
    RoleDao roleDao;


    public RoleServiceImpl() {
    }

    @Override
    public Role enregistrerRole(Role role) {
        return roleDao.save(role);
//        return roleDao.saveAndFlush(role);
    }

    @Override
    public Role findById(Long id) {
        /**
         * C'est comme findById
         */
        return roleDao.getOne(id);
    }

    @Override
    public List<Role> listeRoles() {
        return roleDao.findAll();
    }

    @Override
    public Role findRoleByCode(String code) {
        return roleDao.findRoleByCode(code);
    }
}
