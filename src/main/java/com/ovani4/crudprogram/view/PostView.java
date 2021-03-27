package main.java.com.ovani4.crudprogram.view;

import main.java.com.ovani4.crudprogram.controller.PostController;
import main.java.com.ovani4.crudprogram.model.Post;

import java.util.Date;
import java.util.Scanner;

public class PostView {
    public PostView() {
        PostController pc = new PostController();
        Scanner scan = new Scanner(System.in);
        boolean bool = true;
        int choice;
        System.out.println("Работаем с Post...");
        System.out.println(new StringBuilder().
                append("Для создания Post введи 1;\n").
                append("Для удаления Post по id введи 2;\n").
                append("Для получения Post по id введи 3;\n").
                append("Для обновления информации Post по id введи 4;\n").
                append("Для получения списков всех Post введи 5;\n").
                append("Для возврата в предыдущее меню введи 0;").toString());

        while (bool){
            choice = scan.nextInt();
            switch (choice){
                case 1:
                    Post post = new Post();
                    post.setId(pc.getAll().size() + 1);
                    System.out.println("Введи сообщение: ");
                    post.setContent(scan.nextLine());
                    Date date = new Date();
                    post.setCreate(date);
                    post.setUpdate(date);
                    pc.save(post);
                    break;
                case 2:
                    System.out.println("Введи id Post который надо удалить: ");
                    pc.deleteById(scan.nextInt());
                    break;
                case 3:
                    System.out.println("Введи id Post, который хочешь получить:");
                    System.out.println(pc.getById(scan.nextInt()));
                    break;
                case 4:
                    Post post1 = new Post();
                    System.out.println("Введи id Post, в который необходимо внести изменения:");
                    post1.setId(scan.nextInt());
                    System.out.println("Введи новый Post:");
                    post1.setContent(scan.nextLine());
                    pc.update(post1);
                    break;
                case 5:
                    System.out.println(pc.getAll().toString());
                case 0:
                    MainView mv = new MainView();
                    bool = false;
                    break;
                default:
                    System.out.println(new StringBuilder().
                            append("Для создания Post введи 1;\n").
                            append("Для удаления Post по id введи 2;\n").
                            append("Для получения Post по id введи 3;\n").
                            append("Для обновления информации Post по id введи 4;\n").
                            append("Для получения списков всех Post введи 5;\n").
                            append("Для возврата в предыдущее меню введи 0;").toString());
            }
        }
    }
}
