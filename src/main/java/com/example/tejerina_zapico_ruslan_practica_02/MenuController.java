package com.example.tejerina_zapico_ruslan_practica_02;

import javafx.beans.value.ObservableListValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static com.example.tejerina_zapico_ruslan_practica_02.JSON.JSON_MAPPER;

public class MenuController implements Initializable {
    @FXML
    private Button button_insertar;

    @FXML
    private ListView<Pelicula> listview_peliculas;

    @FXML
    private TextField tf_director;

    @FXML
    private TextField tf_fecha;

    @FXML
    private TextField tf_genero;

    @FXML
    private TextField tf_titulo;
    private ObservableList<Pelicula> peliculas;

    // Este es el método que se ejecuta al inicializar la clase,
    // y recibe como parámetros la ubicación del archivo FXML y los recursos asociados.
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // Agrega un controlador de eventos de clic del ratón al ListView
        listview_peliculas.setOnMouseClicked(event -> {
            // Comprueba si se ha hecho doble clic
            if (event.getClickCount() == 2) {

                // Obtiene la película seleccionada en el ListView
                Pelicula p = this.listview_peliculas.getSelectionModel().getSelectedItem();

                // Si hay una película seleccionada, muestra sus datos en los campos de texto
                if (p != null) {
                    this.tf_titulo.setText(p.getTitulo());
                    this.tf_fecha.setText(p.getFecha());
                    this.tf_genero.setText(p.getGenero());
                    this.tf_director.setText(p.getDirector());
                }
            }
        });


    }

    // Este es un método que se ejecuta al pulsar el botón imprimirPeliculas en el ListView.
    @FXML
    public void imprimirPeliculas(ActionEvent event) {

        peliculas = FXCollections.observableArrayList(); // Crea una nueva lista observable vacía
        this.listview_peliculas.setItems(peliculas); // Asigna la lista observable al ListView

        ArrayList<Pelicula> peliculas;  // Declaramos una variable local para almacenar una lista de películas
        try {
            peliculas = JSON_MAPPER.readValue(new File("src/main/resources/JSON/peliculas.json"), // Lee el archivo JSON que contiene las películas
                    JSON_MAPPER.getTypeFactory().constructCollectionType(ArrayList.class, Pelicula.class));  // Convierte el contenido del archivo en una lista de objetos Pelicula
        } catch (IOException e) { // Captura la excepción si ocurre algún error al leer el archivo o convertirlo
            throw new RuntimeException(e);
        }

        for (int i = 0; i < peliculas.size(); i++) {

            Pelicula p = new Pelicula();
            p = (Pelicula) peliculas.get(i);
            this.peliculas.add(p); // Añade el objeto Pelicula a la lista observable
            this.listview_peliculas.refresh(); // Actualiza el ListView para mostrar los cambios
        }


    }


}