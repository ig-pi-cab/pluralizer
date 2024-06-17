package com.ignacio.springboot.webapp.pluralizer.pluralizer.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ignacio.springboot.webapp.pluralizer.pluralizer.model.PluralizerModel;
import com.ignacio.springboot.webapp.pluralizer.pluralizer.services.PluralizerService;

@RestController
@RequestMapping("/api")
public class PluralizerController {

    @PostMapping("/pluralizar")
    public PluralizerModel pluralizar(@RequestBody String[] palabras) {
        Map<String, Integer> cantidadesPorRegla = new HashMap<>();
        String[] palabrasPluralizadas = PluralizerService.pluralizador(palabras, cantidadesPorRegla);
        return new PluralizerModel(palabrasPluralizadas, cantidadesPorRegla);
    }
}
