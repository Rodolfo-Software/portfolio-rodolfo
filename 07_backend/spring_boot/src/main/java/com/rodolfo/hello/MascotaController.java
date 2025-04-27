package com.rodolfo.hello;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/mascotas")
public class MascotaController {

    private List<String> mascotas = new ArrayList<>(List.of("Toby", "Luna", "Max"));

    // GET /mascotas
    @GetMapping
    public List<String> getMascotas() {
        return mascotas;
    }

    // POST /mascotas
    @PostMapping
    public String addMascota(@RequestBody String nombre) {
        mascotas.add(nombre);
        return "Mascota agregada: " + nombre;
    }

    // PUT /mascotas/{id}
    @PutMapping("/{id}")
    public String updateMascota(@PathVariable int id, @RequestBody String nuevoNombre) {
        if (id >= 0 && id < mascotas.size()) {
            mascotas.set(id, nuevoNombre);
            return "Mascota actualizada";
        } else {
            return "ID inválido";
        }
    }

    // DELETE /mascotas/{id}
    @DeleteMapping("/{id}")
    public String deleteMascota(@PathVariable int id) {
        if (id >= 0 && id < mascotas.size()) {
            String eliminada = mascotas.remove(id);
            return "Mascota eliminada: " + eliminada;
        } else {
            return "ID inválido";
        }
    }
}
