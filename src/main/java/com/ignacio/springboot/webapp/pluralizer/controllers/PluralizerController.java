package com.ignacio.springboot.webapp.pluralizer.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ignacio.springboot.webapp.pluralizer.model.PluralizerModel;

@RestController
@RequestMapping("/api")
public class PluralizerController {
    @PostMapping("/pluralizar")
    public PluralizerModel pluralizar(@RequestBody String[] palabras){
        return new PluralizerModel(palabras, null);
    }
}
