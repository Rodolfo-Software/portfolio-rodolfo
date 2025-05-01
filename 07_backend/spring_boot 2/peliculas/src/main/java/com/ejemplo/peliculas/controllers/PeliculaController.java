package com.ejemplo.peliculas.controllers;

import com.ejemplo.peliculas.models.Pelicula;
import com.ejemplo.peliculas.services.ImdbService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/peliculas")


public class PeliculaController {

    private final ImdbService imdbService;

    public PeliculaController(ImdbService imdbService) {
        this.imdbService = imdbService;
    }

    @GetMapping("/peor")
    public List<Pelicula> getPeoresPeliculas() {
        return imdbService.obtenerPeoresPeliculas();
    }
}

