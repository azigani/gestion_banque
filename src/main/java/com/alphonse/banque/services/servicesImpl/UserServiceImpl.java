package com.alphonse.banque.services.servicesImpl;

import com.alphonse.banque.models.User;
import com.alphonse.banque.repositories.UserDao;
import com.alphonse.banque.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserDao userDao;


    @Override
    public User enregistrerUser(User user) {
        return userDao.save(user);
    }

    @Override
    public User findById(Long id) {
        return userDao.getOne(id);
    }

    @Override
    public List<User> listeUtilisateurs() {
        return userDao.findAll();
    }

    @Override
    public User findUserByLogin(String login) {
        return userDao.findByLogin(login);

    }

    @Override
    public List<User> findByRoleCode(String code) {
        return  userDao.findByRoleCode(code);
    }
}
