package com.example.foro_hub.topico;

import com.example.foro_hub.autor.Autor;
import com.example.foro_hub.autor.DatosAutor;
import com.example.foro_hub.estado.Estado;

import java.time.LocalDate;

public record DatosListaTopico(
        Long id,
        String titulo,
        String mensaje,
        Autor autor,
        Estado estado,
        LocalDate fecha_de_creacion
) {
    public DatosListaTopico(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getAutor(),
                topico.getEstado(), topico.getFecha_de_creacion());
    }
}
