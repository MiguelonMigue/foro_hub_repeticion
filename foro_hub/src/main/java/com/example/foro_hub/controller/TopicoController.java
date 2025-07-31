package com.example.foro_hub.controller;

import com.example.foro_hub.topico.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/topicos")
public class TopicoController {
    @Autowired
    private TopicoRepository repository;

    @Transactional
    @PostMapping
    public void registrar(@RequestBody @Valid DatosRegistroTopico datos){
        repository.save(new Topico(datos));
    }

    @GetMapping
    public Page<DatosListaTopico>listar(@PageableDefault(size=10, sort={"titulo"})Pageable paginacion){
        return repository.findAll(paginacion).map(DatosListaTopico::new);
    }

    @GetMapping ("/{id}")
    public ResponseEntity<DatosListaTopico>detallar(@PathVariable Long id){
        var topico = repository.findById(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Tópico no encontrado"));
        DatosListaTopico datos = new DatosListaTopico(topico);
        return ResponseEntity.ok(datos);
    }

    @PutMapping
    public void actualizar(@RequestBody @Valid DatosActualizacionTopico datos){
        var topico = repository.getReferenceById(datos.id());
        topico.actualizarInformacion(datos);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id){
        repository.deleteById(id);
    }


}
