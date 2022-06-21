package com.evangelista.codeblog.controller;

import com.evangelista.codeblog.model.Post;
import com.evangelista.codeblog.model.service.CodeBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDate;
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
        codeBlogService.findById(id).ifPresent(o -> modelAndView.addObject("post", o));
        return modelAndView;
    }

    @GetMapping("/newpost")
    public String getPostForm(){
        return "postForm";
    }

    @PostMapping("/newpost")
    public String savePost(@Valid Post post, BindingResult result, RedirectAttributes redirectAttributes){

        if (result.hasErrors()){
            redirectAttributes.addFlashAttribute("m",
                    "Verifique se os campos obrigatórios foram preenchidos.");
            return "redirect:/newpost";
        }
        post.setDate(LocalDate.now());
        codeBlogService.save(post);
        return "redirect:/posts";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        codeBlogService.deletePost(id);
        return "redirect:/posts";
    }

}
