package it.epicode.u5w2d2pratica.service;

import it.epicode.u5w2d2pratica.exception.AutoreNotFoundException;
import it.epicode.u5w2d2pratica.model.Autore;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class AutoreService {

    List<Autore> listaAutori=new ArrayList<>();


    // metodo per creare un autore

    public Autore saveAutore(Autore autore){
        autore.setId(new Random().nextInt(1,10000));
        autore.setAvatar("https://ui-avatars.com/api/?name=" + autore.getNome() + "+" + autore.getCognome());
        listaAutori.add(autore);
        return autore;

    }
    // metodo per cercare un autore per id
    public Autore getAutore(int id) throws AutoreNotFoundException{
       return listaAutori.stream().filter(autore -> autore.getId()==id).
                findFirst().orElseThrow(() -> new AutoreNotFoundException("Autore con id "+id+"non trovato"));
    }
    // metodo get per l`intera lista di autori
    public List<Autore> getAllAutori(){
        return listaAutori;
    }

    // metodo per modificare un autore
    public Autore updateAutore(int id,Autore autore)throws AutoreNotFoundException{
        Autore autoreDaTrovate=getAutore(id);
        autoreDaTrovate.setNome(autore.getNome());
        autoreDaTrovate.setCognome(autore.getCognome());
        autoreDaTrovate.setEmail(autore.getEmail());
        autoreDaTrovate.setDataDiNascita(autore.getDataDiNascita());
        return autoreDaTrovate;
    }


    // metodo per deletare un autore passato un id
    public  void deleteAutore(int id)throws AutoreNotFoundException{
        Autore autoreDaElimiare= getAutore(id);
        listaAutori.remove(autoreDaElimiare);

    }
}
