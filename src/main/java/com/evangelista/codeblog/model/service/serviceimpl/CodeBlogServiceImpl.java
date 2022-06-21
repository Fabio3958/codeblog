package com.evangelista.codeblog.model.service.serviceimpl;

import com.evangelista.codeblog.model.Post;
import com.evangelista.codeblog.model.service.CodeBlogService;
import com.evangelista.codeblog.repository.CodeBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CodeBlogServiceImpl implements CodeBlogService {

    @Autowired
    CodeBlogRepository codeBlogRepository;

    @Override
    public List<Post> findAll() {
        return codeBlogRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    @Override
    public Optional<Post> findById(long id) {
        return codeBlogRepository.findById(id);
    }

    @Override
    public Post save(Post post) {
        return codeBlogRepository.save(post);
    }

    @Override
    public void deletePost(Long id) {
        codeBlogRepository.deleteById(id);
    }
}
