package it.epicode.u5w2d2pratica.controller;

import it.epicode.u5w2d2pratica.dto.AutoreDto;
import it.epicode.u5w2d2pratica.exception.AutoreNotFoundException;
import it.epicode.u5w2d2pratica.exception.ValidationException;
import it.epicode.u5w2d2pratica.model.Autore;
import it.epicode.u5w2d2pratica.service.AutoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
public class AutoreController {

    @Autowired
    private AutoreService autoreService;

    @PostMapping("/authors")
    private Autore saveAutore(@RequestBody @Validated AutoreDto autoreDto, BindingResult bindingResult) throws ValidationException {

        if (bindingResult.hasErrors()){
            throw  new ValidationException(bindingResult.getAllErrors().
                    stream().map(objectError ->objectError.getDefaultMessage()).reduce("",(e,s)->e+s));
        }

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
    public Autore updateAutore(@PathVariable int id,@RequestBody @Validated AutoreDto autoreDto,BindingResult bindingResult) throws AutoreNotFoundException, ValidationException {
        if (bindingResult.hasErrors()){
            throw  new ValidationException(bindingResult.getAllErrors().
                    stream().map(objectError ->objectError.getDefaultMessage()).reduce("",(e,s)->e+s));
        }
        return autoreService.updateAutore(id, autoreDto);
    }

    @DeleteMapping("/authors/{id}")
    public void deleteAutore(@PathVariable int id)throws AutoreNotFoundException{
        autoreService.deleteAutore(id);
    }

    //patch
    @PatchMapping("/authors/{id}")
    public String patchAutore(@PathVariable int id, MultipartFile file) throws AutoreNotFoundException, IOException {
        return autoreService.patchAutore(id, file);
    }
}
