package main.java.com.ovani4.crudprogram.controller;

import main.java.com.ovani4.crudprogram.model.Post;
import main.java.com.ovani4.crudprogram.repository.PostRepository;
import main.java.com.ovani4.crudprogram.repository.imp.JavaIOPostRepositoryImpl;

import java.util.List;

public class PostController {
    PostRepository pr = new JavaIOPostRepositoryImpl();

    public List<Post> getAll() {
        return pr.getAll();
    }

    public Post getById(Integer integer) {
        return pr.getById(integer);
    }

    public Post save(Post post) {
        return pr.save(post);
    }

    public Post update(Post post) {
        return pr.update(post);
    }

    public void deleteById(Integer integer) {
        pr.deleteById(integer);
    }

    public static List<Integer> getUserPosts(Integer integer) {
        return getUserPosts(integer);
    }
}
