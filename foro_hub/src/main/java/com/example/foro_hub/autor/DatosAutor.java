package com.example.foro_hub.autor;

import com.example.foro_hub.curso.DatosCurso;
import com.example.foro_hub.estado.Estado;
import com.example.foro_hub.perfil.Perfil;
import com.example.foro_hub.usuario.DatosUsuario;
import com.example.foro_hub.usuario.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosAutor(
        @NotBlank String nombre,
        @NotNull DatosUsuario usuario,
        @NotNull DatosCurso curso,
        @NotNull Perfil perfil

        ) {
        public DatosAutor(Autor autor){
                this(autor.getNombre(), new DatosUsuario(autor.getUsuario()) , new DatosCurso(autor.getCurso()),autor.getPerfil());
        }
}
