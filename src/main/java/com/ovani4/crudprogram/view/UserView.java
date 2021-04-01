package main.java.com.ovani4.crudprogram.view;

import main.java.com.ovani4.crudprogram.controller.PostController;
import main.java.com.ovani4.crudprogram.controller.UserController;
import main.java.com.ovani4.crudprogram.model.User;
import main.java.com.ovani4.crudprogram.repository.RegionRepository;
import main.java.com.ovani4.crudprogram.repository.imp.JavaIORegionRepositoryImpl;

import java.util.Scanner;

public class UserView {
    public UserView() {
        UserController uc = new UserController();
        Scanner scan = new Scanner(System.in);
        boolean bool = true;
        int choice;
        System.out.println("Работаем с User...");
        System.out.println(new StringBuilder().
                append("Для создания User введи 1;\n").
                append("Для удаления User по id введи 2;\n").
                append("Для получения User по id введи 3;\n").
                append("Для обновления информации User по id введи 4;\n").
                append("Для получения списков всех User введи 5;\n").
                append("Для возврата в предыдущее меню введи 0;").toString());

        while (bool){
            choice = scan.nextInt();
            switch (choice) {
                case 1:
                    User user = new User();
                    Integer userId = uc.getAll().size() + 1;
                    user.setId(userId);
                    System.out.println("Введи Имя: ");
                    user.setFirstName(scan.nextLine());
                    System.out.println("Введи Фамилию: ");
                    user.setLastName(scan.nextLine());
                    user.setPosts(PostController.getUserPosts(userId));
                    System.out.println("Выбери номер региона из списка: ");
                    RegionRepository rr = new JavaIORegionRepositoryImpl();
                    rr.getAll().stream().forEach(System.out::println);
                    Integer choiceRegion = scan.nextInt();
                    user.setRegion(choiceRegion);
                    break;
                case 2:
                    System.out.println("Введи id User который надо удалить: ");
                    uc.deleteById(scan.nextInt());
                    break;
                case 3:
                    System.out.println("Введи id User, который хочешь получить: ");
                    System.out.println(uc.getById(scan.nextInt()));
                    break;
                case 4:
                    User user1 = new User();
                    System.out.println("Введи id User, в который необходимо внести изменения:");
                    user1.setId(scan.nextInt());
                    System.out.println("Введи новое Имя: ");
                    user1.setFirstName(scan.nextLine());
                    System.out.println("Введи новую Фамилию: ");
                    user1.setLastName(scan.nextLine());
                    System.out.println("Выбери новый регион: ");
                    RegionRepository rr1 = new JavaIORegionRepositoryImpl();
                    rr1.getAll().stream().forEach(System.out::println);
                    Integer choiceRegion1 = scan.nextInt();
                    user1.setRegion(choiceRegion1);
                    break;
                case 5:
                    uc.getAll().stream().forEach(System.out::println);
                    break;
                case 0:
                    MainView mv = new MainView();
                    bool = false;
                    break;
                default:
                    System.out.println(new StringBuilder().
                            append("Для создания User введи 1;\n").
                            append("Для удаления User по id введи 2;\n").
                            append("Для получения User по id введи 3;\n").
                            append("Для обновления информации User по id введи 4;\n").
                            append("Для получения списков всех User введи 5;\n").
                            append("Для возврата в предыдущее меню введи 0;").toString());
                    break;
            }
        }
    }
}
