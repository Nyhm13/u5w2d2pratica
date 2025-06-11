package it.epicode.u5w2d2pratica.controller;

import it.epicode.u5w2d2pratica.dto.BlogDto;
import it.epicode.u5w2d2pratica.exception.AutoreNotFoundException;
import it.epicode.u5w2d2pratica.exception.BlogNotFoundException;
import it.epicode.u5w2d2pratica.model.Autore;
import it.epicode.u5w2d2pratica.model.Blog;
import it.epicode.u5w2d2pratica.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {

    @Autowired
    public BlogService blogService;

    @PostMapping("/blogPosts")
    private Blog saveBlog(@RequestBody BlogDto blogDto)throws AutoreNotFoundException {
        return blogService.saveBlog(blogDto);
    }

    @GetMapping("/blogPosts/{id}")
    public Blog getBlog(@PathVariable int id)throws BlogNotFoundException {
        return blogService.getBlog(id);
    }

    @GetMapping("/blogPosts")
    public Page<Blog> getAllBlogs(    @RequestParam(defaultValue = "0") int page,
                                      @RequestParam(defaultValue = "10")int size,
                                      @RequestParam(defaultValue = "id")String sortBy){
        return  blogService.getListaBlogs(page, size, sortBy);
    }

    @PutMapping("/blogPosts/{id}")
    public Blog updateAutore(@PathVariable int id,@RequestBody BlogDto blogDto)throws BlogNotFoundException,AutoreNotFoundException{
        return blogService.updateBlog(id, blogDto);
    }

    @DeleteMapping("/blogPosts/{id}")
    public void deleteAutore(@PathVariable int id)throws BlogNotFoundException {
        blogService.deleteBlog(id);
    }
}
