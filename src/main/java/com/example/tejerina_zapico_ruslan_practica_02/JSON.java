package com.example.tejerina_zapico_ruslan_practica_02;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.controlsfx.control.tableview2.filter.filtereditor.SouthFilter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class JSON {

    public static final ObjectMapper JSON_MAPPER = new ObjectMapper();

    public static void main(String[] args) {

        ArrayList<Pelicula> peliculas;
        try {
            peliculas = JSON_MAPPER.readValue(new File("src/main/resources/JSON/peliculas.json"),
                    JSON_MAPPER.getTypeFactory().constructCollectionType(ArrayList.class, Pelicula.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < peliculas.size(); i++) {

            System.out.println(peliculas.get(i).getId());
            System.out.println(peliculas.get(i).getTitulo());
            System.out.println(peliculas.get(i).getFecha());
            System.out.println(peliculas.get(i).getDirector());
            System.out.println(peliculas.get(i).getGenero());
            Pelicula p = new Pelicula();
            p = (Pelicula) peliculas.get(i);
            System.out.println(p);
        }
    }
}
