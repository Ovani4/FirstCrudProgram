package src.main.java.com.ovani4.crudprogram.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class User {
    private int id;
    private String firstName;
    private String lastName;
    private List<Post> posts;
    private Region region;

    public User(String firstName, String lastName) {

        this.id = generateId();
        this.firstName = firstName;
        this.lastName = lastName;
        this.posts = new ArrayList<>();
        this.region = new Region();
    }

    private int generateId(){
        int newId = 0;
        //метод генерирования ID + проверка на уникальность
        return newId;
    }


    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Region getRegion() {
        return region;
    }

}
