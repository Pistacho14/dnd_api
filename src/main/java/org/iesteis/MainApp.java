package org.iesteis;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.iesteis.importer.ApiImport;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

        public static Scene scene;

        private final ExecutorService executor = Executors.newSingleThreadExecutor();

    @Override 
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/mainMenu.fxml"));
        


        scene = new Scene(loader.load(), 1280, 800);
        scene.getStylesheets().add(
                getClass().getResource("/styles/Styles.css").toExternalForm());
        stage.setTitle("Dungeon and Dragons API");
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();

        iniciarImportacion();
    }

    private void iniciarImportacion() {

        Task<Void> importacion = new Task<>() {
                @Override
                protected Void call() throws Exception {
                        ApiImport.apiImport();
                        return null;
                }
        };

        executor.submit(importacion);
    }

    @Override
    public void stop() {
        executor.shutdown();
    }

    public static void main(String[] args) {
        launch();

    }  
}