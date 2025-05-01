package com.ejemplo.peliculas.services;

import com.ejemplo.peliculas.models.Pelicula;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.json.*;

import java.util.*;


import org.springframework.beans.factory.annotation.Value;


@Service
public class ImdbService {

    private final RestTemplate restTemplate;


    @Value("${rapidapi.key}")
    private String apiKey;


    public ImdbService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Pelicula> obtenerPeoresPeliculas() {
        String url = "https://imdb236.p.rapidapi.com/imdb/lowest-rated-movies";

        HttpHeaders headers = new HttpHeaders();
        headers.set("x-rapidapi-host", "imdb236.p.rapidapi.com");
        headers.set("x-rapidapi-key", apiKey); // ← XXX

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        JSONArray jsonArray = new JSONArray(response.getBody());
        List<Pelicula> peliculas = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject obj = jsonArray.getJSONObject(i);

            Pelicula p = new Pelicula(
                    obj.optString("id"),
                    obj.optString("primaryTitle"),
                    obj.optString("description"),
                    obj.optString("trailer"),
                    obj.optString("primaryImage"),
                    obj.optString("releaseDate")
            );

            peliculas.add(p);
        }

        return peliculas;
    }
}



