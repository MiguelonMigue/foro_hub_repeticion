package com.example.foro_hub.usuario;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;

@Embeddable
public class Usuario {
    private String correo;
    private String contrasena;

    public Usuario(DatosUsuario datos){
        this.correo = datos.correo();
        this.contrasena = datos.contrasena();
    }

    public void actualizarInformacion(DatosUsuario datos){
        if(datos.correo()!=null){
            this.correo = datos.correo();
        }
        if(datos.contrasena()!=null){
            this.contrasena = datos.contrasena();
        }
    }
}
