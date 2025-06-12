package it.epicode.u5w2d2pratica.dto;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BlogDto {

    @NotEmpty(message = "la categoria non puo essere nullo o vuoto  ")

    private String categoria;
    @NotEmpty(message = "il titolo non puo essere nullo o vuoto  ")
    private String titolo;
    @NotEmpty(message = "il contenuto non puo essere nullo o vuoto  ")
    private String contenuto;
    @NotNull(message = "il tempo di lettura non puo essere nullo o vuoto  ")
    private int tempoDiLetturaMinuti;
    private int authorId;
}
