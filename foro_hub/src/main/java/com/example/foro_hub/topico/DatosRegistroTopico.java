package com.example.foro_hub.topico;

import com.example.foro_hub.autor.DatosAutor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DatosRegistroTopico(
        @NotBlank String titulo,
        @NotBlank String mensaje,
        @NotNull DatosAutor autor
        ) {
}
