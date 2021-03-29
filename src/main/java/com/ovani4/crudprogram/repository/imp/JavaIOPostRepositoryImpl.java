package main.java.com.ovani4.crudprogram.repository.imp;

import main.java.com.ovani4.crudprogram.model.Post;
import main.java.com.ovani4.crudprogram.repository.PostRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JavaIOPostRepositoryImpl implements PostRepository {
    private final String FILE_PATH_POST = "src/data/post.txt";

    @Override
    public List<Post> getAll() {
        return getListFromFile(FILE_PATH_POST);
    }

    @Override
    public Post getById(Integer integer) {
        return getListFromFile(FILE_PATH_POST).stream().
                filter(post -> post.getId().equals(integer)).
                findFirst().orElse(null);
    }

    @Override
    public Post save(Post post) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH_POST))) {
            getListFromFile(FILE_PATH_POST).add(post);
            for (Post post1 : getListFromFile(FILE_PATH_POST)) {
                bw.write(post1.getId().toString() + " "
                        + post1.getUserId().toString() + " "
                        + post1.getContent() + " "
                        + post1.getCreate().toString() + " "
                        + post1.getUpdate().toString());
            }
        } catch (IOException e) {
            System.err.println("error in create post" + e.toString());
        }
        return post;
    }

    @Override
    public Post update(Post post) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH_POST))) {
            getListFromFile(FILE_PATH_POST).stream().
                    filter(post1 -> post1.getId().equals(post.getId())).
                    forEach(post1 -> {
                        post1.setContent(post.getContent());
                        post1.setUpdate(new Date());
                    });
            for (Post post1 : getListFromFile(FILE_PATH_POST)) {
                bw.write(post1.getId().toString() + " "
                        + post1.getContent() + " "
                        + post1.getCreate().toString() + " "
                        + post1.getUpdate().toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return post;
    }

    @Override
    public void deleteById(Integer integer) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH_POST))) {
            getListFromFile(FILE_PATH_POST).remove(getListFromFile(FILE_PATH_POST).
                    stream().filter(post -> post.getId().equals(integer)));
            for (Post post1 : getListFromFile(FILE_PATH_POST)) {
                bw.write(post1.getId().toString() + " "
                        + post1.getContent() + " "
                        + post1.getCreate().toString() + " "
                        + post1.getUpdate().toString());
            }
        } catch (IOException e) {
            System.err.println("error in delete post" + e.toString());
        }
    }

    @Override
    public List<Integer> getUserPosts(Integer integer) {
        List<Integer> postsUser = new ArrayList<>();
        getListFromFile(FILE_PATH_POST).stream().filter(post -> post.getUserId().
                equals(integer)).forEach(post -> postsUser.add(post.getUserId()));
        return postsUser;
    }

    private List<Post> getListFromFile(String filePath) {

        String s;
        String[] sm;
        List<Post> posts = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH_POST))) {
            while ((s = br.readLine()) != null) {
                Post p = new Post();
                sm = s.split(" ");
                p.setId(Integer.parseInt(sm[0]));
                p.setContent(sm[1]);
                p.setCreate(new Date());
                p.setUpdate(new Date());
                posts.add(p);
            }
        } catch (IOException e) {
            System.err.println("error filling in the collection");
        }
        return posts;
    }

}
