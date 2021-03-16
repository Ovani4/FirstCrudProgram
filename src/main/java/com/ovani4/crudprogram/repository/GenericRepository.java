package main.java.com.ovani4.crudprogram.repository;

import main.java.com.ovani4.crudprogram.model.Region;

import java.util.List;

public interface GenericRepository <T , ID>{
    List <T> getAll();
    T getById(ID id);
    T save(T t);
    T update(T t);
    void deleteById(ID id);

    private List<T> getListFromFile(String filePath) {
        return null;
    }
}
