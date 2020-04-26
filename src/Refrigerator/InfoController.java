package Refrigerator;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class InfoController {
    public void BackBtn(ActionEvent actionEvent) throws IOException{
        Parent connector = (Parent) FXMLLoader.load(this.getClass().getResource("Door.fxml"));
        Scene scene = new Scene(connector);
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
