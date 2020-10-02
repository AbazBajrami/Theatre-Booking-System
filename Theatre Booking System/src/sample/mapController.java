package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import java.io.IOException;
import javafx.scene.control.Button;

public class mapController
{
    @FXML private Button login, ownerLog,currentShows, addNewShow, currentPerformances, addNewPerformance, customerLog, addNewBooking, viewAll;

    //LOGIN
    @FXML
    private void goToLogin(ActionEvent e) throws IOException {
        Scene sceneLogin = new Scene(FXMLLoader.load(getClass().getResource("../sample/Login.fxml")));
        Main.ps.setScene(sceneLogin);
    }

    //OWNER LOG
    @FXML
    private void goToOwnerLog(ActionEvent e) throws IOException {
        Scene sceneOwnerLog = new Scene(FXMLLoader.load(getClass().getResource("../sample/Owner/OwnerLog.fxml")));
        Main.ps.setScene(sceneOwnerLog);
    }

    //CURRENT SHOWS
    @FXML
    private void goToCurrentShows(ActionEvent e) throws IOException {
        Scene sceneCurrentShows = new Scene(FXMLLoader.load(getClass().getResource("../sample/Owner/Current Shows.fxml")));
        Main.ps.setScene(sceneCurrentShows);
    }

    //ADD NEW SHOW
    @FXML
    private void goToAddNewShow(ActionEvent e) throws IOException {
        Scene sceneAddNewShow = new Scene(FXMLLoader.load(getClass().getResource("../sample/Owner/Add New Show.fxml")));
        Main.ps.setScene(sceneAddNewShow);
    }

    //CURRENT PERFORMANCES
    @FXML
    private void goToCurrentPerformances(ActionEvent e) throws IOException {
        Scene sceneCurrentPerformance = new Scene(FXMLLoader.load(getClass().getResource("../sample/Owner/Current Performance.fxml")));
        Main.ps.setScene(sceneCurrentPerformance);
    }

    //ADD NEW PERFORMANCES
    @FXML
    private void goToAddNewPerformance(ActionEvent e) throws IOException {
    Scene sceneAddNewPerformance = new Scene(FXMLLoader.load(getClass().getResource("../sample/Owner/Add New Performance.fxml")));
    Main.ps.setScene(sceneAddNewPerformance);
    }

    //CUSTOMER LOG
    @FXML
    private void goToCustomerLog(ActionEvent e) throws IOException {
        Scene sceneCustomerLog = new Scene(FXMLLoader.load(getClass().getResource("../sample/Customer/CurrentBooking.fxml")));
        Main.ps.setScene(sceneCustomerLog);
    }

    //ADD NEW BOOKING
    @FXML
    private void goToAddNewBooking(ActionEvent e) throws IOException {
        Scene sceneNewBooking = new Scene(FXMLLoader.load(getClass().getResource("../sample/Customer/Add a Booking.fxml")));
        Main.ps.setScene(sceneNewBooking);
    }

    //VIEW ALL
    @FXML
    private void goToViewAll(ActionEvent e) throws IOException {
        Scene sceneViewAll = new Scene(FXMLLoader.load(getClass().getResource("../sample/ViewAll.fxml")));
        Main.ps.setScene(sceneViewAll);
    }





}
