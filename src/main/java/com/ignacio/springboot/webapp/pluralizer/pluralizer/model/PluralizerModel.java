package com.ignacio.springboot.webapp.pluralizer.pluralizer.model;
import java.util.Map;

public class PluralizerModel {
    private String[] palabrasPluralizadas;
    private Map<String, Integer> cantidadesPorRegla;

    public PluralizerModel(String[] palabrasPluralizadas, Map<String, Integer> cantidadesPorRegla) {
        this.palabrasPluralizadas = palabrasPluralizadas;
        this.cantidadesPorRegla = cantidadesPorRegla;
    }

    public String[] getPalabrasPluralizadas() {
        return palabrasPluralizadas;
    }

    public void setPalabrasPluralizadas(String[] palabrasPluralizadas) {
        this.palabrasPluralizadas = palabrasPluralizadas;
    }

    public Map<String, Integer> getCantidadesPorRegla() {
        return cantidadesPorRegla;
    }

    public void setCantidadesPorRegla(Map<String, Integer> cantidadesPorRegla) {
        this.cantidadesPorRegla = cantidadesPorRegla;
    }
}
