package com.example.foro_hub.curso;

import com.example.foro_hub.categoria.Categoria;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosCurso(
        @NotBlank String nombreCurso,
        @NotNull @Valid Categoria categoria){

    public DatosCurso(Curso curso){
        this(curso.getNombreCurso(), curso.getCategoria());
    }
}
