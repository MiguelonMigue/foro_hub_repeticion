package com.example.foro_hub.usuario;

import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DatosUsuario(
        @NotBlank @Email String correo,
        @NotBlank  String contrasena
) {
}
