package sample.Owner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import sample.Main;
import java.io.IOException;

public class OwnerLogController
{
    //BUTTONS
    @FXML private Button viewShows, map, viewPerformances, logOut;

    //VIEW SHOWS
    @FXML
    public void goToViewShows(ActionEvent e) throws IOException {
        Scene goToShows = new Scene(FXMLLoader.load(getClass().getResource("../Owner/Current Shows.fxml")));
        Main.ps.setScene(goToShows);
    }

    //VIEW PERFORMANCES
    @FXML
    public void goToViewPerformances(ActionEvent e) throws IOException {
        Scene goToPerformances = new Scene(FXMLLoader.load(getClass().getResource("../Owner/Current Performance.fxml")));
        Main.ps.setScene(goToPerformances);
    }

    //LOG OUT
    @FXML
    public void logout(ActionEvent e) throws IOException {
        Scene logO = new Scene(FXMLLoader.load(getClass().getResource("../Login.fxml")));
        Main.ps.setScene(logO);
    }

    //MAP
    @FXML
    private void goToMap(ActionEvent e) throws IOException {
        Scene mapping = new Scene(FXMLLoader.load(getClass().getResource("../map.fxml")));
        Main.ps.setScene(mapping);
    }
}
