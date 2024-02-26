package com.alphonse.banque.initializer;

import com.alphonse.banque.models.Role;
import com.alphonse.banque.repositories.RoleDao;
import com.alphonse.banque.services.IServiceRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
@Order(1)
@Component
public class RoleInitializer implements CommandLineRunner {
    @Autowired
    IServiceRole roleService;

    @Override
    public void run(String... args) throws Exception {
//verifier si ya pas de role admin on insert
        if (roleService.findRoleByCode("ADMIN") == null) {
            Role role1 = new Role();
            role1.setCode("ADMIN");
            role1.setNom(" Administrateur Gestion de banque ");
//            role1.setCode("");
            roleService.enregistrerRole(role1);
        }


        //find All
        roleService.listeRoles()
                .stream()
                .forEach(role -> {
                    System.out.println(role.getId() + " ," + role.getId() + " ," + role.getCode() + " ," + role.getNom());
                });

    }


}
