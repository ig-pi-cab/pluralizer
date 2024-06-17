package com.ignacio.springboot.webapp.pluralizer.pluralizer.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ignacio.springboot.webapp.pluralizer.pluralizer.model.PluralizerModel;
import com.ignacio.springboot.webapp.pluralizer.pluralizer.services.PluralizerService;

@RestController
@RequestMapping("/api")
public class PluralizerController {

    @PostMapping("/pluralizar")
    public PluralizerModel pluralizar(@RequestBody String[] palabras) {
        if (palabras == null || palabras.length == 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El array de palabras no puede ser nulo o vacío");
        }
        try {
            Map<String, Integer> cantidadesPorRegla = new HashMap<>();
            String[] palabrasPluralizadas = PluralizerService.pluralizador(palabras, cantidadesPorRegla);
            return new PluralizerModel(palabrasPluralizadas, cantidadesPorRegla);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error interno del servidor", e);
        }
        
    }
}
