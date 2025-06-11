package it.epicode.u5w2d2pratica.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Blog {
    @Id
    @GeneratedValue
    private int id;
    private String categoria;
    private String titolo;
    private String cover;
    private String contenuto;
    private int tempoDiLetturaMinuti;

    @ManyToOne
    @JoinColumn(name = "autore_id")
    private Autore autore;
}
