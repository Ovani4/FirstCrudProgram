package main.java.com.ovani4.crudprogram.view;

import main.java.com.ovani4.crudprogram.controller.RegionController;
import main.java.com.ovani4.crudprogram.model.Region;
import java.util.Scanner;

public class RegionView {
    public RegionView() {
        RegionController rc = new RegionController();
        Scanner scan = new Scanner(System.in);
        int choice;
        System.out.println("Работаем с Region...");
        System.out.println(new StringBuilder().
                append("Для создания Region введи 1;\n").
                append("Для удаления Region по id введи 2;\n").
                append("Для получения информации о Region по id введи 3;\n").
                append("Для обновления информации Region по id введи 4;\n").
                append("Для получения списков всех Region введи 5;").toString());
        choice = scan.nextInt();
        while (true) {
            switch (choice) {
                case 1:
                    Region region = new Region();
                    region.setId(rc.getAll().size() + 1);
                    System.out.println("Введи имя Region");
                    region.setName(scan.nextLine()); // пока что без проверки
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
                    System.out.println("Введи id Region, в который необходимо внести изменения:"); // В процессе ============
                    region1.setId(scan.nextInt());
                    System.out.println("Введи новое имя Region:");
                    region1.setName(scan.nextLine());
                    rc.update(region1);
                case 0:
                    System.out.println("Закрытие программы...");
                    break;
                default:
                    System.out.println("Для работы с User введи 1;\n" +
                            "Для работы с Region введи 2;\n" +
                            "Для работы с Post введи 3;" +
                            "Для выхода введи 0;");
            }
        }
    }
}
