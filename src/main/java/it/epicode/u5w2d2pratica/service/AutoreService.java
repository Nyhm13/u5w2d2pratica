package it.epicode.u5w2d2pratica.service;

import it.epicode.u5w2d2pratica.dto.AutoreDto;
import it.epicode.u5w2d2pratica.exception.AutoreNotFoundException;
import it.epicode.u5w2d2pratica.model.Autore;
import it.epicode.u5w2d2pratica.repository.AutoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class AutoreService {

   @Autowired
   private AutoreRepository autoreRepository;

   //


    // metodo per creare un autore

    public Autore saveAutore(AutoreDto autoreDto){
        Autore autore=new Autore();
        autore.setNome(autoreDto.getNome());
        autore.setCognome(autoreDto.getCognome());
        autore.setEmail(autoreDto.getEmail());
        autore.setDataDiNascita(autoreDto.getDataDiNascita());
        autore.setAvatar("https://ui-avatars.com/api/?name=" + autoreDto.getNome() + "+" + autoreDto.getCognome());
        return  autoreRepository.save(autore);


    }
    // metodo per cercare un autore per id
    public Autore getAutore(int id) throws AutoreNotFoundException{
//       return listaAutori.stream().filter(autore -> autore.getId()==id).
//                findFirst().orElseThrow(() -> new AutoreNotFoundException("Autore con id "+id+"non trovato"));
        return autoreRepository.findById(id).orElseThrow(() ->new AutoreNotFoundException("Autore con id "+id+" non trovato"));

    }
    // metodo get per l`intera lista di autori
    public List<Autore> getAllAutori(){
        return autoreRepository.findAll();
    }

    // metodo per modificare un autore
    public Autore updateAutore(int id,AutoreDto autoreDto)throws AutoreNotFoundException{
        Autore autoreDaTrovate=getAutore(id);
        autoreDaTrovate.setNome(autoreDto.getNome());
        autoreDaTrovate.setCognome(autoreDto.getCognome());
        autoreDaTrovate.setEmail(autoreDto.getEmail());
        autoreDaTrovate.setDataDiNascita(autoreDto.getDataDiNascita());
        autoreDaTrovate.setAvatar("https://ui-avatars.com/api/?name="+autoreDto.getNome()+"+"+autoreDto.getCognome());
        return autoreRepository.save(autoreDaTrovate);
    }


    // metodo per deletare un autore passato un id
    public  void deleteAutore(int id)throws AutoreNotFoundException{
        Autore autoreDaElimiare= getAutore(id);
        autoreRepository.delete(autoreDaElimiare);

    }
}
