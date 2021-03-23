package main.java.com.ovani4.crudprogram.model;

import java.util.ArrayList;
import java.util.List;


public class User {
    private int id;
    private String firstName;
    private String lastName;
    private List<Post> posts;
    private Region region;

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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", posts=" + posts +
                ", region=" + region +
                '}';
    }
}
