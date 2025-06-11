package it.epicode.u5w2d2pratica.service;

import it.epicode.u5w2d2pratica.dto.BlogDto;
import it.epicode.u5w2d2pratica.exception.AutoreNotFoundException;
import it.epicode.u5w2d2pratica.exception.BlogNotFoundException;
import it.epicode.u5w2d2pratica.model.Autore;
import it.epicode.u5w2d2pratica.model.Blog;
import it.epicode.u5w2d2pratica.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class BlogService {
    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    // qui facciamo l`autowired ad autoreservice  per collegarmi al autore per cercale il suo id
    // in quanto per creare un blog prima dobbiamo avere un autore
    private AutoreService autoreService;

    //metodo per salvare  un nuovo studente
    public Blog saveBlog(BlogDto blogDto)throws AutoreNotFoundException {
        Autore autore=autoreService.getAutore(blogDto.getAuthorId());

        Blog blog=new Blog();
        blog.setCategoria(blogDto.getCategoria());
        blog.setContenuto(blogDto.getContenuto());
        blog.setTitolo(blogDto.getTitolo());
        blog.setTempoDiLetturaMinuti(blogDto.getTempoDiLetturaMinuti());
        blog.setAutore(autore);
        blog.setCover("https://picsum.photos/200/300");
        return blogRepository.save(blog);
    }
    //metodo per trovare un blog passando l`id
    public Blog getBlog(int id) throws BlogNotFoundException{
//        return listaBlogs.stream().filter(blog -> blog.getId()==id).
//                findFirst().orElseThrow(() -> new BlogNotFoundException("Nessun blog con id "+id+" trovato"));
      return blogRepository.findById(id).orElseThrow(() -> new BlogNotFoundException("Nessun blog con id "+id+" trovato"));
    }

    // metodo per tornare la lista con i blog

    public Page<Blog> getListaBlogs(int page,int size, String sortBy){
        Pageable pageable= PageRequest.of(page,size, Sort.by(sortBy));
        return blogRepository.findAll(pageable);

    }

    //metodo per modificare un specifico blog

    public Blog updateBlog(int id,BlogDto blogDto)throws BlogNotFoundException,AutoreNotFoundException{
        // richiamo il metodo per cercare un blog per id per trovare quello che voglio modificare
        Blog blogDaCercare=getBlog(id);

        blogDaCercare.setCategoria(blogDto.getCategoria());
        blogDaCercare.setTitolo(blogDto.getTitolo());
        blogDaCercare.setContenuto(blogDto.getContenuto());
        blogDaCercare.setTempoDiLetturaMinuti(blogDto.getTempoDiLetturaMinuti());


        // questo passaggio mi tocca farlo in quanto su BlogDTO ha una variabile che si chiamare authoreID
        if (blogDaCercare.getAutore().getId()!=blogDto.getAuthorId()){
            Autore autore=autoreService.getAutore(blogDto.getAuthorId());
            blogDaCercare.setAutore(autore);

        }
        return blogRepository.save(blogDaCercare);


    }
    //delete
    public void deleteBlog(int id)throws BlogNotFoundException{

        Blog blogDaEliminare=getBlog(id);
        blogRepository.delete(blogDaEliminare);
    }

}
