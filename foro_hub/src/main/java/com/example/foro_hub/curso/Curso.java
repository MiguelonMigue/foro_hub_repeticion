package com.example.foro_hub.curso;

import com.example.foro_hub.categoria.Categoria;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Enumerated;

@Embeddable
public class Curso {
    private String nombreCurso;
    @Enumerated
    private Categoria categoria;

    public Curso(DatosCurso datos){
        this.nombreCurso = datos.nombreCurso();
        this.categoria = datos.categoria();
    }

    public void actualizarInformacion(DatosCurso datos){
        if(datos.nombreCurso()!=null){
            this.nombreCurso = datos.nombreCurso();
        }
        if(datos.categoria()!=null){
            this.categoria = datos.categoria();
        }
    }
}
