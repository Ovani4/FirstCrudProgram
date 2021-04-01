package main.java.com.ovani4.crudprogram.repository;

import main.java.com.ovani4.crudprogram.model.User;

import java.util.List;

public interface UserRepository extends GenericRepository<User, Integer> {
    List<Integer> getUserPosts(Integer integer);
    Integer getUserRegion(Integer integer);
}
