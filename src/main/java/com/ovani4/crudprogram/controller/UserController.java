package main.java.com.ovani4.crudprogram.controller;

import main.java.com.ovani4.crudprogram.repository.UserRepository;
import main.java.com.ovani4.crudprogram.repository.imp.JavaIOUserRepositoryImpl;

public class UserController {
    UserRepository ur = new JavaIOUserRepositoryImpl();
}
