package com.example.foro_hub.topico;

import com.example.foro_hub.autor.Autor;
import com.example.foro_hub.estado.Estado;
import com.example.foro_hub.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
@Entity(name="Topico")
@Table(name="topicos")


public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    @Embedded
    private Autor autor;
    @Enumerated(EnumType.ORDINAL)
    private Estado estado;
    private LocalDate fecha_de_creacion = LocalDate.now();

    public Topico(DatosRegistroTopico datos){
        this.id = null;
        this.titulo = datos.titulo();
        this.mensaje = datos.mensaje();
        this.autor = new Autor(datos.autor());
    }
    public void actualizarInformacion(DatosActualizacionTopico datos){
        if(datos.titulo()!=null){
            this.titulo = datos.titulo();
        }
        if(datos.mensaje()!=null){
            this.mensaje = datos.mensaje();
        }
    }


}
