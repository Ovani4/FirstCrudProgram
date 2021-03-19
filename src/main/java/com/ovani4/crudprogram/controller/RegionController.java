package main.java.com.ovani4.crudprogram.controller;

import main.java.com.ovani4.crudprogram.model.Region;
import main.java.com.ovani4.crudprogram.repository.RegionRepository;
import main.java.com.ovani4.crudprogram.repository.imp.JavaIORegionRepositoryImpl;

import java.util.List;

public class RegionController {
    RegionRepository rr = new JavaIORegionRepositoryImpl();
    public RegionController() {

    }

    public List<Region> getAll() {
        return rr.getAll();
    }


    public Region getById(Integer integer) {
        return rr.getById(integer);
    }


    public Region save(Region region) {
        return rr.save(region);
    }


    public Region update(Region region) {
        return rr.update(region);
    }


    public void deleteById(Integer integer) {
        rr.deleteById(integer);
    }

}
