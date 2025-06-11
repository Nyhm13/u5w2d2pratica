package it.epicode.u5w2d2pratica.controller;

import it.epicode.u5w2d2pratica.dto.AutoreDto;
import it.epicode.u5w2d2pratica.exception.AutoreNotFoundException;
import it.epicode.u5w2d2pratica.model.Autore;
import it.epicode.u5w2d2pratica.service.AutoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AutoreController {

    @Autowired
    private AutoreService autoreService;

    @PostMapping("/authors")
    private Autore saveAutore(@RequestBody AutoreDto autoreDto){
        return autoreService.saveAutore(autoreDto);
    }

    @GetMapping("/authors/{id}")
    public Autore getAutore(@PathVariable int id)throws AutoreNotFoundException{
        return autoreService.getAutore(id);
    }

    @GetMapping("/authors")
    public List<Autore> getAllAutori(){
        return  autoreService.getAllAutori();
    }

    @PutMapping("/authors/{id}")
    public Autore updateAutore(@PathVariable int id,@RequestBody AutoreDto autoreDto)throws AutoreNotFoundException{
        return autoreService.updateAutore(id, autoreDto);
    }

    @DeleteMapping("/authors/{id}")
    public void deleteAutore(@PathVariable int id)throws AutoreNotFoundException{
        autoreService.deleteAutore(id);
    }
}
