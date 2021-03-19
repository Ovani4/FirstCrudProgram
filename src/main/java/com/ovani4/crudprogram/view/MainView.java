package main.java.com.ovani4.crudprogram.view;

//тут дергаются все вьюшки, вьюшки дергают контроллеры (которые дублируют методы репозитория),
//Контроллеры дергают репозиториии, репозитории работают с файлами.


import java.util.Scanner;

public class MainView {
    public MainView() {
        Scanner scan = new Scanner(System.in);
        int choice;
        boolean bool = true;
        System.out.println("Программа запущена.");
        System.out.println(new StringBuilder().
                append("Для работы с User введи 1;\n").
                append("Для работы с Region введи 2;\n").
                append("Для работы с Post введи 3;\n").
                append("Для выхода введи 0;").toString());
        while (bool) {
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
                    bool = false;
                    break;
                default:
                    System.out.println(new StringBuilder().
                            append("Для работы с User введи 1;\n").
                            append("Для работы с Region введи 2;\n").
                            append("Для работы с Post введи 3;\n").
                            append("Для выхода введи 0;").toString());
            }
        }
    }
}
