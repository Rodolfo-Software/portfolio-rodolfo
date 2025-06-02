package com.rodolfo.taskmanager.repository;

import com.rodolfo.taskmanager.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Integer> {
}
