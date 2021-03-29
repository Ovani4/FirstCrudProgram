package main.java.com.ovani4.crudprogram.repository.imp;

import main.java.com.ovani4.crudprogram.model.User;
import main.java.com.ovani4.crudprogram.repository.UserRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JavaIOUserRepositoryImpl implements UserRepository {
    private final String FILE_PATH_USER = "src/main/java/com/ovani4/crudprogram/data/users.txt";

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
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH_USER))) {
            getListFromFile(FILE_PATH_USER).add(user);
            for (User user1 : getListFromFile(FILE_PATH_USER)) {
                bw.write(user1.getId() + " "
                        + user1.getFirstName() + " "
                        + user1.getLastName() + " "
                        + user1.getRegion());
            }
        } catch (IOException e) {
            System.err.println("error in create user " + e.toString());
        }
        return user;
    }

    @Override
    public User update(User user) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH_USER))) {
            getListFromFile(FILE_PATH_USER).stream().
                    filter(user1 -> user1.getId().equals(user.getId())).
                    forEach(user1 -> {
                        user1.setFirstName(user.getFirstName());
                        user1.setLastName(user.getLastName());
                        user1.setRegion(user.getRegion());
                    });
            for (User user1 : getListFromFile(FILE_PATH_USER)) {
                bw.write(user1.getId() + " "
                        + user1.getFirstName() + " "
                        + user1.getLastName() + " "
                        + user1.getRegion());
            }
        } catch (IOException e) {
            System.err.println("error in update user " + e.toString());
        }
        return user;
    }

    @Override
    public void deleteById(Integer integer) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH_USER))) {
            getListFromFile(FILE_PATH_USER).remove(getListFromFile(FILE_PATH_USER).stream().
                    filter(user -> user.getId().equals(integer)));
            for (User user : getListFromFile(FILE_PATH_USER)) {
                bw.write(user.getId() + " "
                        + user.getFirstName() + " "
                        + user.getLastName() + " "
                        + user.getRegion());
            }
        } catch (IOException e) {
            System.out.println("error in delete user " + e.toString());
        }
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
