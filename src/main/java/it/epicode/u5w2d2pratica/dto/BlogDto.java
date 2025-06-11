package it.epicode.u5w2d2pratica.dto;


import lombok.Data;

@Data
public class BlogDto {
    private String categoria;
    private String titolo;
    private String contenuto;
    private int tempoDiLetturaMinuti;
    private int authorId;
}
