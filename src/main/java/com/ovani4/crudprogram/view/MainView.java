package main.java.com.ovani4.crudprogram.view;

//тут дергаются все вьюшки, вьюшки дергают контроллеры (которые дублируют методы репозитория),
//Контроллеры дергают репозиториии, репозитории работают с файлами.


import java.util.Scanner;

public class MainView {
    public MainView() {
        Scanner scan = new Scanner(System.in);
        int choice;
        boolean have_choice = true;
        System.out.println("Программа запущена.");
        System.out.println("Для работы с User введи 1;\n" +
                "Для работы с Region введи 2;\n" +
                "Для работы с Post введи 3;" +
                "Для выхода введи 0;");
        while (have_choice) {
            choice = scan.nextInt();
            switch (choice) {
                case 1:
                    UserView uv = new UserView();
                    break;
                case 2:
                    RegionView rv = new RegionView();
                    break;
                case 3:
                    PostView pv = new PostView();
                    break;
                case 0:
                    System.out.println("Закрытие программы...");
                    break;
                default:
                    System.out.println("Для работы с User введи 1;\n" +
                            "Для работы с Region введи 2;\n" +
                            "Для работы с Post введи 3;\n" +
                            "Для выхода введи 0;");
                    have_choice = false;
            }
        }
    }
}
