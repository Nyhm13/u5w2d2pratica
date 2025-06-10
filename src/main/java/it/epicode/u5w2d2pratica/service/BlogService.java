package it.epicode.u5w2d2pratica.service;

import it.epicode.u5w2d2pratica.exception.BlogNotFoundException;
import it.epicode.u5w2d2pratica.model.Blog;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class BlogService {
    private List<Blog> listaBlogs= new ArrayList<>();

    //metodo per salvare  un nuovo studente
    public Blog saveBlog(Blog blog){
        blog.setId(new Random().nextInt(1,100000));
        blog.setCover("https://picsum.photos/200/300");
        listaBlogs.add(blog);
        return blog;
    }
    //metodo per trovare un blog passando l`id
    public Blog getBlog(int id) throws BlogNotFoundException{
        return listaBlogs.stream().filter(blog -> blog.getId()==id).
                findFirst().orElseThrow(() -> new BlogNotFoundException("Nessun blog con id "+id+" trovato"));

    }

    // metodo per tornare la lista con i blog

    public List<Blog> getListaBlogs(){
        return listaBlogs;

    }

    //metodo per modificare un specifico blog

    public Blog updateBlog(int id,Blog blog)throws BlogNotFoundException{
        // richiamo il metodo per cercare un blog per id per trovare quello che voglio modificare
        Blog blogDaCercare=getBlog(id);

        blogDaCercare.setCategoria(blog.getCategoria());
        blogDaCercare.setTitolo(blog.getTitolo());
        blogDaCercare.setContenuto(blog.getContenuto());
        blogDaCercare.setTempoDiLetturaMinuti(blog.getTempoDiLetturaMinuti());

        return blogDaCercare;


    }
    //delete
    public void deleteBlog(int id)throws BlogNotFoundException{

        Blog blogDaEliminare=getBlog(id);
        listaBlogs.remove(blogDaEliminare);
    }

}
