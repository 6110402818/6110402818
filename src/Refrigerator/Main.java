package Refrigerator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import models.Compartment;
import models.FreezingCompartment;
import models.Refrigerator;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Door.fxml"));
//        Parent root = FXMLLoader.load(getClass().getResource("RefrigeratorCompartment.fxml"));

        primaryStage.setTitle("Refrigerator");
        primaryStage.setScene(new Scene(root, 650, 950));
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
