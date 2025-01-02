package org.project.logic;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.project.logic.persistence.DaoFactory;
import org.project.logic.persistence.PersistenceProvider;
import org.project.logic.view.CliLogin;
import org.project.logic.view.Printer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;


public class Driver extends Application {

    public static void main(String[] args) throws IOException {

        setPersistenceProvider("in memory");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean quit = false;


        while(!quit) {
            Printer.printMsgln("[0: cli, 1: gui, 2: esci]");

            String action = br.readLine();

            switch (action) {
                case "0":
                    CliLogin login = new CliLogin();
                    login.loginMenu();
                    break;
                case "1":
                    launch();
                    break;
                case "2":
                    quit = true;
                    break;
                default:
                    break;
            }

        }


    }


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Driver.class.getResource("Accedi - BookX.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("BookX");
        stage.setScene(scene);
        stage.show();
    }


    private static void setPersistenceProvider(String provider) {
        for (PersistenceProvider p : PersistenceProvider.values()) {
            if (p.getName().equals(provider)) {
                try {
                    DaoFactory.setInstance(p.getDaoFactoryClass().getConstructor().newInstance());
                } catch (NoSuchMethodException | InvocationTargetException | InstantiationException
                         | IllegalAccessException e) {
                    throw new IllegalStateException("Invalid Provider");
                }
                return;
            }
        }
    }
}