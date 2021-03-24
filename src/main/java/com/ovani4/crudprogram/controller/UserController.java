package main.java.com.ovani4.crudprogram.controller;

import main.java.com.ovani4.crudprogram.model.User;
import main.java.com.ovani4.crudprogram.repository.UserRepository;
import main.java.com.ovani4.crudprogram.repository.imp.JavaIOUserRepositoryImpl;

import java.util.List;

public class UserController {
    UserRepository ur = new JavaIOUserRepositoryImpl();

    public List<User> getAll() {
        return ur.getAll();
    }

    public User getById(Integer integer) {
        return ur.getById(integer);
    }

    public User save(User user) {
        return ur.save(user);
    }

    public User update(User user) {
        return ur.save(user);
    }

    public void deleteById(Integer integer) {
        ur.deleteById(integer);
    }
}
