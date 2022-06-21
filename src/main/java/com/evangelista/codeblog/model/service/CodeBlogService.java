package com.evangelista.codeblog.model.service;

import com.evangelista.codeblog.model.Post;

import java.util.List;
import java.util.Optional;

public interface CodeBlogService {

    List<Post> findAll();
    Optional<Post> findById(long id);
    Post save(Post post);
    void deletePost(Long id);
}
