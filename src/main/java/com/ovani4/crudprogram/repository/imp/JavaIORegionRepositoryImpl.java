package main.java.com.ovani4.crudprogram.repository.imp;

import main.java.com.ovani4.crudprogram.model.Region;
import main.java.com.ovani4.crudprogram.repository.RegionRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;


public class JavaIORegionRepositoryImpl implements RegionRepository {
    private final String FILE_PATH_REGIONS = "src/data/regions.txt";

    @Override
    public List<Region> getAll() {
        return getListFromFile(FILE_PATH_REGIONS);
    }

    @Override
    public Region getById(Integer integer) { //Иначе не додумался как из потока объект вытащить
        //попробовать вытащить Object  и привести его к Region...

        Region[] regions = (Region[]) getListFromFile(FILE_PATH_REGIONS).stream().
                filter(r -> r.equals(integer)).toArray();

        return regions[0];
    }

    @Override
    public Region save(Region region) {//додумался так, но тоже как то странновато...
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH_REGIONS))) {
            getListFromFile(FILE_PATH_REGIONS).add(region);
            getListFromFile(FILE_PATH_REGIONS).stream().forEach(region1 -> {
                try {
                    bw.write(region1.getId().toString() + " " + region1.getName() + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            System.err.println("error in create region");
        }
        return region;
    }

    @Override
    public Region update(Region region) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH_REGIONS))) {
            getListFromFile(FILE_PATH_REGIONS).stream().
                    filter(region1 -> region.getId().equals(region)).forEach(region1 -> {
                        //Еще не придумал, как зменить объект в потоке)
            });
        }catch (IOException e){
            System.err.println("error in update region");
        }
        return region;
    }

    @Override
    public void deleteById(Integer integer) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH_REGIONS))) {
            getListFromFile(FILE_PATH_REGIONS).stream().
                    filter(region -> region.getId() != integer).forEach(region -> {
                try {
                    bw.write(region.getId().toString() + " " + region.getName() + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }catch (IOException e){
            System.err.println("error in delete region by ID");
        }
    }

    public List<Region> getListFromFile(String filePath) {
        String s;
        String[] sm;
        List<Region> regions = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while ((s = br.readLine()) != null) {
                Region r = new Region();
                sm = s.split(" ");
                r.setId(Integer.parseInt(sm[0]));
                r.setName(sm[1]);
                regions.add(r);
            }
        } catch (IOException e) {
            System.err.println("error filling in the collection");
        }
        return regions;
    }
}
