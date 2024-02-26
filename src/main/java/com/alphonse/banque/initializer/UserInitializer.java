package com.alphonse.banque.initializer;

import com.alphonse.banque.models.Role;
import com.alphonse.banque.models.User;
import com.alphonse.banque.services.IServiceRole;
import com.alphonse.banque.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
@Order(2)
@Component
public class UserInitializer implements CommandLineRunner {
    @Autowired
    IServiceRole roleService;
    @Autowired
    IUserService userService;

    @Override
    public void run(String... args) throws Exception {
//verifier si ya pas de role admin on insert

        User userAdminOpt = userService.findUserByLogin("admin");
        if (userAdminOpt==null){
            Role roleAdmin = roleService.findRoleByCode("ADMIN");
            if (roleAdmin != null) {
                /**
                 * On ne peut enregistrer qu'un user si le role n'est pas triiuvé dans la BD
                 */
                User userAdmin = new User();
                //renseigner le code du role
                userAdmin.setRole(roleAdmin);
                userAdmin.setEmail("admin@gmail.com");
                userAdmin.setUsername("alphonse");
                userAdmin.setLogin("admin");
                userService.enregistrerUser(userAdmin);
            }
        }




        //find All
        roleService.listeRoles()
                .stream()
                .forEach(role -> {
                    System.out.println(role.getId() + " ," + role.getId() + " ," + role.getCode() + " ," + role.getNom());
                });

    }


}
