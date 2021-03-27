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
                append("Для получения всех Post User по Id введи 6;\n").
                append("Для возврата в предыдущее меню введи 0;").toString());

        while (bool){
            choice = scan.nextInt();
            switch (choice){
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
                    user.setRegion(rr.getAll().stream().filter(region -> region.getId().equals(choiceRegion)).findFirst().orElse(null));
            }
        }
    }
}
