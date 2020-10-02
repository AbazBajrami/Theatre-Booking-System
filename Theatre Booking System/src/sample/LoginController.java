package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import java.io.IOException;

public class LoginController
{
    //Buttons
    @FXML private Button logAsCustomer, logAsOwner, reset, save, map;

    //LOGIN AS THE OWNER
    @FXML
    private void logO(ActionEvent e) throws IOException {
        Scene ownerLog = new Scene(FXMLLoader.load(getClass().getResource("../sample/Owner/OwnerLog.fxml")));
        Main.ps.setScene(ownerLog);
    }
        //LOGIN AS THE CUSTOMER
    @FXML
    private void logC(ActionEvent e) throws IOException {
        Scene customerLog = new Scene(FXMLLoader.load(getClass().getResource("../sample/Customer/CurrentBooking.fxml")));
        Main.ps.setScene(customerLog);
    }

    //RESET EVERYTHING
    @FXML
    private void resetAll(ActionEvent e) throws IOException
    {
        Main.showLinkedList.deleteAll(1);
        Main.performanceLinkedList.deleteAll(1);
        Main.bookingLinkedList.deleteAll(1);
    }

    //SAVE ALL
    @FXML
    private void saveAll(ActionEvent e) throws IOException
    {
        try{
            Main.save();
        }
        catch (Exception ex){
            System.err.println("Errror writing to file: " + ex);
        }
    }

    //LOAD ALL
    @FXML
    private void loadAll(ActionEvent e) throws IOException
    {
        try{
            Main.load();
        }
        catch (Exception ex){
            System.err.println("Error loading from file: " + ex);
        }
    }

    //MAP
    @FXML
    private void goToMap(ActionEvent e) throws IOException {
        Scene mapping = new Scene(FXMLLoader.load(getClass().getResource("../sample/map.fxml")));
        Main.ps.setScene(mapping);
    }

}

