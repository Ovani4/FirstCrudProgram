package main.java.com.ovani4.crudprogram.view;

import main.java.com.ovani4.crudprogram.model.Region;
import main.java.com.ovani4.crudprogram.repository.JavaIORegionRepositoryImpl;

import java.util.Scanner;

public class CrudStart {
    public CrudStart() {
        JavaIORegionRepositoryImpl newRegion = new JavaIORegionRepositoryImpl();
        Region region = new Region();
        region.setId(10);
        region.setName("Khimki");
        newRegion.save(region);
        Region region1 = new Region();
        region1.setId(101);
        region1.setName("Skhodnya");

        newRegion.save(region1);
    }
}
