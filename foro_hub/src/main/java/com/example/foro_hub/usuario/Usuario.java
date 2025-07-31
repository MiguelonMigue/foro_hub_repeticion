package com.example.foro_hub.usuario;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Embeddable
public class Usuario {
    private String correo;


    public Usuario(DatosUsuario datos){
        this.correo = datos.correo();
    }

    public void actualizarInformacion(DatosUsuario datos){
        if(datos.correo()!=null){
            this.correo = datos.correo();
        }

    }
}
