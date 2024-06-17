package com.ignacio.springboot.webapp.pluralizer.pluralizer.services;

import java.util.Map;

public class PluralizerService {
    public static String[] pluralizador(String[] palabras, Map<String, Integer> cantidadesPorRegla){
       
        //Variables de reglas
        String vocales ="aeiou";
        String sOX = "sx";
        String zeta = "z";

        String[] resultados = new String[palabras.length];
        
     

        System.out.println(cantidadesPorRegla);

        //Contar cuantas veces aplica cada regla, itera por el largo del array de palabras
        for (int i = 0; i < palabras.length; i++) {
            String palabra = palabras[i].toLowerCase().trim();
            String resultado;


            cantidadesPorRegla.put("Rule 1", 0);
            cantidadesPorRegla.put("Rule 2", 0);
            cantidadesPorRegla.put("Rule 3", 0);
            cantidadesPorRegla.put("Rule 4", 0);

            //Obtiene el ultimo character
            char lastChar = palabra.charAt(palabra.length() - 1);

            if(palabra.startsWith("el ")){
                palabra = "los " + palabra.substring(3);
            }else if(palabra.startsWith("la ")){
                palabra = "las " + palabra.substring(3);
            }

            if (vocales.indexOf(lastChar) != -1) {
                resultado = palabra + "s";
                incrementarRegla(cantidadesPorRegla, "Rule 1");
             } else if (sOX.indexOf(lastChar) != -1) {
                resultado = palabra;
                incrementarRegla(cantidadesPorRegla, "Rule 2");
            } else if (zeta.indexOf(lastChar) != -1) {
                resultado = palabra.substring(0, palabra.length() - 1) + "ces";
                incrementarRegla(cantidadesPorRegla, "Rule 3");
            } else {
                resultado = palabra + "es";
                incrementarRegla(cantidadesPorRegla, "Rule 4");
            }

            resultados[i] = resultado;
        }
        
        return resultados;
    }

    private static void incrementarRegla(Map<String, Integer> cantidadesPorRegla, String regla) {
        cantidadesPorRegla.put(regla, cantidadesPorRegla.getOrDefault(regla, 0) + 1);
    }
}
