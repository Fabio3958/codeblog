package com.evangelista.codeblog.utils;

import com.evangelista.codeblog.model.Post;
import com.evangelista.codeblog.repository.CodeBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class DummyData {

    @Autowired
    CodeBlogRepository codeBlogRepository;

    @PostConstruct
    public void savePosts(){

        List<Post> postList = new ArrayList<>();
        Post post1 = new Post();
        Post post2 = new Post();

        post1.setAuthor("Fábio Evangelista");
        post1.setDate(LocalDate.now());
        post1.setTitle("Docker");
        post1.setText("Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...");

        post2.setAuthor("Fábio Evangelista");
        post2.setDate(LocalDate.now());
        post2.setTitle("API REST");
        post2.setText("Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...");

        postList.add(post1);
        postList.add(post2);

        for (Post post : postList) {

            Post postSaved = codeBlogRepository.save(post);
            System.out.println(postSaved.getId());

        }
    }

}
