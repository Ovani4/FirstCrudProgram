package main.java.com.ovani4.crudprogram.view;

import main.java.com.ovani4.crudprogram.controller.RegionController;
import main.java.com.ovani4.crudprogram.model.Region;
import java.util.Scanner;

public class RegionView {
    public RegionView() {
        RegionController rc = new RegionController();
        Scanner scan = new Scanner(System.in);
        boolean bool = true;
        int choice;
        System.out.println("Работаем с Region...");
        System.out.println(new StringBuilder().
                append("Для создания Region введи 1;\n").
                append("Для удаления Region по id введи 2;\n").
                append("Для получения информации о Region по id введи 3;\n").
                append("Для обновления информации Region по id введи 4;\n").
                append("Для получения списков всех Region введи 5;\n").
                append("Для возврата в предыдущее меню введи 0;").toString());

        while (bool) {
            choice = scan.nextInt();
            switch (choice) {
                case 1:
                    Region region = new Region();
                    region.setId(rc.getAll().size() + 1);
                    System.out.println("Введи имя Region");
                    region.setName(scan.nextLine());
                    System.out.println(rc.save(region).toString());
                    break;
                case 2:
                    System.out.println("Введи id Region, который необходимо удалить: ");
                    rc.deleteById(scan.nextInt());
                    break;
                case 3:
                    System.out.println("Введи id Region, ионформацию о котором хочешь получить:");
                    System.out.println(rc.getById(scan.nextInt()));
                    break;
                case 4:
                    Region region1 = new Region();
                    System.out.println("Введи id Region, в который необходимо внести изменения:");
                    region1.setId(scan.nextInt());
                    System.out.println("Введи новое имя Region:");
                    region1.setName(scan.nextLine());
                    rc.update(region1);
                    break;
                case 5:
                    System.out.println(rc.getAll().toString());
                    break;
                case 0:
                    MainView mv = new MainView();
                    bool = false;
                    break;
                default:
                    System.out.println(new StringBuilder().
                            append("Для создания Region введи 1;\n").
                            append("Для удаления Region по id введи 2;\n").
                            append("Для получения информации о Region по id введи 3;\n").
                            append("Для обновления информации Region по id введи 4;\n").
                            append("Для получения списков всех Region введи 5;\n").
                            append("Для возврата в предыдущее меню введи 0;").toString());
            }
        }
    }
}
