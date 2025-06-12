package it.epicode.u5w2d2pratica.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AutoreDto {
    @NotEmpty(message = "il nome non puo essere nullo o vuoto  ")
    private  String nome;
    @NotEmpty(message = "il cognome non puo essere nullo o vuoto  ")
    private  String cognome;
    @NotEmpty(message = "il campo email non puo essere nullo o vuoto  ")
    private String email;
    @NotNull
    private LocalDate dataDiNascita;

}
