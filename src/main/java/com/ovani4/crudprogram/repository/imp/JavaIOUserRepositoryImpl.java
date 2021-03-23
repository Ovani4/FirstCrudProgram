package main.java.com.ovani4.crudprogram.repository.imp;

import main.java.com.ovani4.crudprogram.controller.PostController;
import main.java.com.ovani4.crudprogram.model.Post;
import main.java.com.ovani4.crudprogram.model.Region;
import main.java.com.ovani4.crudprogram.model.User;
import main.java.com.ovani4.crudprogram.repository.PostRepository;
import main.java.com.ovani4.crudprogram.repository.RegionRepository;
import main.java.com.ovani4.crudprogram.repository.UserRepository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JavaIOUserRepositoryImpl implements UserRepository {
    private final String FILE_PATH_USER = "src/data/users.txt";

    @Override
    public List<User> getAll() {
        return getListFromFile(FILE_PATH_USER);
    }

    @Override
    public User getById(Integer integer) {
        return getListFromFile(FILE_PATH_USER).stream().
                filter(user -> user.getId().equals(integer)).
                findFirst().orElse(null);
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public void deleteById(Integer integer) {

    }


    private List<User> getListFromFile(String filePath) {
        String s;
        String[] sm;
        List<User> users = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH_USER))) {
            while ((s = br.readLine()) != null) {
                User u = new User();
                sm = s.split(" ");
                u.setId(Integer.parseInt(sm[0]));
                u.setFirstName(sm[1]);
                u.setLastName(sm[2]);
            }
        } catch (IOException e) {
            System.err.println("error filling in the collection");
        }
        return users;
    }

}
