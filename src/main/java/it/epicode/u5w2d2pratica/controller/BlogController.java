package it.epicode.u5w2d2pratica.controller;

import it.epicode.u5w2d2pratica.exception.AutoreNotFoundException;
import it.epicode.u5w2d2pratica.exception.BlogNotFoundException;
import it.epicode.u5w2d2pratica.model.Autore;
import it.epicode.u5w2d2pratica.model.Blog;
import it.epicode.u5w2d2pratica.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {

    @Autowired
    public BlogService blogService;

    @PostMapping("/blogPosts")
    private Blog saveBlog(@RequestBody Blog blog){
        return blogService.saveBlog(blog);
    }

    @GetMapping("/blogPosts/{id}")
    public Blog getBlog(@PathVariable int id)throws BlogNotFoundException {
        return blogService.getBlog(id);
    }

    @GetMapping("/blogPosts")
    public List<Blog> getAllBlogs(){
        return  blogService.getListaBlogs();
    }

    @PutMapping("/blogPosts/{id}")
    public Blog updateAutore(@PathVariable int id,@RequestBody Blog blog)throws BlogNotFoundException{
        return blogService.updateBlog(id, blog);
    }

    @DeleteMapping("/blogPosts/{id}")
    public void deleteAutore(@PathVariable int id)throws BlogNotFoundException {
        blogService.deleteBlog(id);
    }
}
