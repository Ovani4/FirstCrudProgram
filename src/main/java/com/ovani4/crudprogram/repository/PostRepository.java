package main.java.com.ovani4.crudprogram.repository;

import main.java.com.ovani4.crudprogram.model.Post;

import java.util.List;

public interface PostRepository extends GenericRepository <Post, Integer>{

    List<Post> getUserPosts(Integer integer);
}
