package com.rodolfo.taskmanager.controller;

import com.rodolfo.taskmanager.model.City;
import com.rodolfo.taskmanager.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
@CrossOrigin(origins = "*")
public class CityController {

    @Autowired
    private CityRepository cityRepository;

    @GetMapping
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    @GetMapping("/{id}")
    public City getCityById(@PathVariable Integer id) {
        return cityRepository.findById(id).orElseThrow();
    }
}
