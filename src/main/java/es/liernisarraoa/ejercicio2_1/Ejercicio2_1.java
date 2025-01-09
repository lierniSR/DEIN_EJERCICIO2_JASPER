package es.liernisarraoa.ejercicio2_1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Ejercicio2_1 extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Ejercicio2_1.class.getResource("FXML/ejercicio1.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        //Obtener el controlador y pasar la escena; Esto sirve para que escenaAplicacion de HelloController no de null
        ControladorAgenda controlador = fxmlLoader.getController();
        controlador.setEjercicioStage(stage);
        stage.setTitle("Informes");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}