package test;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public AnchorPane anchorPane;
    FXMLLoader loader;
    public void onClick1() throws IOException{
        loader = new FXMLLoader(getClass().getResource("one.fxml"));
        anchorPane.getChildren().add(loader.load());
    }
    public void onClick2() throws IOException{
        loader= new FXMLLoader(getClass().getResource("two.fxml"));
        anchorPane.getChildren().add(loader.load());
    }
    public void onClick3() throws IOException{
        loader = new FXMLLoader(getClass().getResource("three.fxml"));
        anchorPane.getChildren().add(loader.load());
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
