package main.java.com.ovani4.crudprogram.repository;

import main.java.com.ovani4.crudprogram.model.Region;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JavaIORegionRepositoryImpl implements RegionRepository {
    List<Region> regions = new ArrayList<>();
    BufferedReader br;
    BufferedWriter bw;

    @Override
    public List<Region> getAll() {
        Region region = new Region();
        try {
            br = new BufferedReader(new FileReader("/data/regions.txt"));
            String s;
            String [] sm;
            while ((s = br.readLine())!=null){
               sm = s.split(" ");
               region.setId(Integer.parseInt(sm[0]));
               region.setName(sm[1]);
               regions.add(region);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return regions;
    }

    @Override
    public Region getById(Integer integer) {
        Region region = new Region();
        try {
            br = new BufferedReader(new FileReader("data/regions.txt"));
            String s;
            String [] sm;
            while ((s = br.readLine()) != null){
                sm = br.readLine().split(" ");
                if (sm[0].equals(integer)){
                    region.setId(Integer.parseInt(sm[0]));
                    region.setName(sm[1]);
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return region;
    }

    @Override
    public Region save(Region region) {
        try {
            bw = new BufferedWriter(new FileWriter("src/data/regions.txt"));
            bw.write(region.getId() + " " + region.getName());
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return region;
    }

    @Override
    public Region update(Region region) {
        return null;
    }

    @Override
    public void deleteById(Integer integer) {
        String s;
        String[] sm;
        try {
            br = new BufferedReader(new FileReader("src/data/regions.txt"));
            while ((s = br.readLine())!= null){
                sm = s.split(" ");
                if (sm[0].equals(integer)){
                    //удалить строку
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
