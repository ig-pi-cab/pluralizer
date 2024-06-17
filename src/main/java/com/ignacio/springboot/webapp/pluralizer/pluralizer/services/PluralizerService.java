package com.ignacio.springboot.webapp.pluralizer.pluralizer.services;

import java.util.Map;
import java.util.TreeMap;

public class PluralizerService {
    public static String[] pluralizador(String[] palabras, Map<String, Integer> cantidadesPorRegla){
       
        //Variables de reglas
        String vocales ="aeiou";
        String sOX = "sx";
        String zeta = "z";

        String[] resultados = new String[palabras.length];
        
    
        //Contar cuantas veces aplica cada regla, itera por el largo del array de palabras
        for (int i = 0; i < palabras.length; i++) {
            String palabra = palabras[i].toLowerCase().trim();
            String resultado;

            cantidadesPorRegla.putIfAbsent("Rule 1", 0);
            System.out.println(cantidadesPorRegla);
            cantidadesPorRegla.putIfAbsent("Rule 2", 0);
            cantidadesPorRegla.putIfAbsent("Rule 3", 0);
            cantidadesPorRegla.putIfAbsent("Rule 4", 0);
            System.out.println(cantidadesPorRegla);


            //Obtiene el ultimo character
            char lastChar = palabra.charAt(palabra.length() - 1);

            if(palabra.startsWith("el ")){
                palabra = "los " + palabra.substring(3);
            }else if(palabra.startsWith("la ")){
                palabra = "las " + palabra.substring(3);
            }

            //Reglas aplicadas 
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
        System.out.println(cantidadesPorRegla);

        return resultados;
    }
    private static void incrementarRegla(Map<String, Integer> cantidadesPorRegla, String regla) {
        int count = cantidadesPorRegla.getOrDefault(regla, 0) + 1;
        cantidadesPorRegla.put(regla, count);
    }

    // private static void incrementarRegla(Map<String, Integer> cantidadesPorRegla, String regla) {
    //     cantidadesPorRegla.put(regla, cantidadesPorRegla.getOrDefault(regla, 0) + 1);
    // }
    
}
