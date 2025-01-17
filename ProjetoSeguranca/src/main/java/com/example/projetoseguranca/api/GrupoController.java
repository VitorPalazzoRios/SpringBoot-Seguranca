package com.example.projetoseguranca.api;

import com.example.projetoseguranca.domain.entity.Grupo;
import com.example.projetoseguranca.domain.repository.GrupoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grupo")
@RequiredArgsConstructor
public class GrupoController {

    private final GrupoRepository grupoRepository;

    @GetMapping
    public ResponseEntity<List<Grupo>> findAll() {
        List<Grupo> grupos = grupoRepository.findAll();
        return ResponseEntity.ok(grupos);
    }



    @Transactional
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Grupo> salvar(@RequestBody Grupo grupo) {
        grupoRepository.save(grupo);
        return ResponseEntity.ok(grupo);
    }



}
