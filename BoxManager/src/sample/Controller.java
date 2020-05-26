package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.scene.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private double xOffset = 0;
    private double yOffset = 0;

    @FXML private ListView<String> files;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Init");
        files.getItems().addAll("Test","Test1","Test2");
    }

    public void closeWindow(MouseEvent e) {
        Pane pane = (Pane)e.getSource();
        Stage window = (Stage)pane.getScene().getWindow();
        window.close();
    }

    public void minimizeWindow(MouseEvent e) {
        Pane pane = (Pane)e.getSource();
        Stage window = (Stage)pane.getScene().getWindow();
        window.setIconified(true);
    }

    public void setWindowLocation(MouseEvent e) {
        xOffset = e.getSceneX();
        yOffset = e.getSceneY();
    }

    public void moveWindow(MouseEvent e) {
        Stage window = (Stage)((Pane)e.getSource()).getScene().getWindow();
        window.setX(e.getScreenX() - xOffset);
        window.setY(e.getScreenY() - yOffset);
    }

}
