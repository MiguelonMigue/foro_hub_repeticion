package com.example.foro_hub.autor;

import com.example.foro_hub.curso.Curso;
import com.example.foro_hub.estado.Estado;
import com.example.foro_hub.perfil.Perfil;
import com.example.foro_hub.usuario.Usuario;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.Enumerated;

@Embeddable
public class Autor {

    private String nombre;
    @Embedded
    private Usuario usuario;
    @Embedded
    private Curso curso;
    @Enumerated
    private Perfil perfil;

    public Autor(DatosAutor datos){
        this.nombre = datos.nombre();
        this.usuario = new Usuario(datos.usuario());
        this.curso = new Curso(datos.curso());
        this.perfil = datos.perfil();
    }

    public void actualizarInformacion(DatosAutor datos){
        if(datos.nombre()!=null){
            this.nombre= datos.nombre();
        }
        if(datos.usuario()!=null){
            this.usuario.actualizarInformacion(datos.usuario());
        }
        if(datos.curso()!=null){
            this.curso.actualizarInformacion(datos.curso());
        }
        if(datos.perfil()!=null){
            this.perfil = datos.perfil();
        }
    }
}
