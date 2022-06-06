package com.evangelista.codeblog.controller;

import com.evangelista.codeblog.model.Post;
import com.evangelista.codeblog.model.service.CodeBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;


@Controller
public class CodeBlogController {

    @Autowired
    CodeBlogService codeBlogService;

    @GetMapping("/posts")
    public ModelAndView getPosts(){
        ModelAndView modelAndView = new ModelAndView("posts");
        List<Post> posts = codeBlogService.findAll();
        modelAndView.addObject("posts", posts);
        return modelAndView;
    }

    @GetMapping("/posts/{id}")
    public ModelAndView getPostDetails(@PathVariable("id") long id){
        ModelAndView modelAndView = new ModelAndView("postDetails");
        Optional<Post> post = codeBlogService.findById(id);
        modelAndView.addObject("post", post);
        return modelAndView;
    }

}
