package main.java.com.ovani4.crudprogram.controller;

import main.java.com.ovani4.crudprogram.model.Region;
import main.java.com.ovani4.crudprogram.repository.imp.JavaIORegionRepositoryImpl;

import java.util.List;

public class RegionController {
    public RegionController() {

    }

    public List<Region> getAll() {
        JavaIORegionRepositoryImpl rr = new JavaIORegionRepositoryImpl();
        return rr.getAll();
    }


    public Region getById(Integer integer) {
        JavaIORegionRepositoryImpl rr = new JavaIORegionRepositoryImpl();
        return rr.getById(integer);
    }


    public Region save(Region region) {
        JavaIORegionRepositoryImpl rr = new JavaIORegionRepositoryImpl();
        return rr.save(region);
    }


    public Region update(Region region) {
        JavaIORegionRepositoryImpl rr = new JavaIORegionRepositoryImpl();
        return rr.update(region);
    }


    public void deleteById(Integer integer) {
        JavaIORegionRepositoryImpl rr = new JavaIORegionRepositoryImpl();
        rr.deleteById(integer);
    }

}
