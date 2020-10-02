package sample.Customer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.Main;
import sample.Owner.Show;
import sample.Owner.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CurrentBoookingController implements Initializable {
    //BUTTONS
    @FXML private TextField bookingToDelete;
    @FXML private Button newBookingButton, map, returnButton, deleteBooking;
    @FXML private TableView<Booking> tableView;
    @FXML private TableColumn<Booking, String> name, performanceTitle, time, numberOfSeats, price, bookingId;

    //ADD A BOOKING
    @FXML
    private void goToNewBooking(ActionEvent e) throws IOException {
        Scene newBookingB = new Scene(FXMLLoader.load(getClass().getResource("../Customer/Add a Booking.fxml")));
        Main.ps.setScene(newBookingB);
    }

    //INITIALIZE
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //set up the columns in the table
        name.setCellValueFactory(new PropertyValueFactory<Booking, String>("name"));
        performanceTitle.setCellValueFactory(new PropertyValueFactory<Booking, String>("performanceChosen"));
        time.setCellValueFactory(new PropertyValueFactory<Booking, String>("time"));
        numberOfSeats.setCellValueFactory(new PropertyValueFactory<Booking, String>("numberOfSeats"));
        price.setCellValueFactory(new PropertyValueFactory<Booking, String>("price"));
        bookingId.setCellValueFactory(new PropertyValueFactory<Booking, String>("bookingId"));

        //Load Dummy Data
        Node temp = (Node) Main.bookingLinkedList.head;
        while(temp != null)
        {
            tableView.getItems().add((Booking) temp.getData());
            temp = temp.next;
        }
    }

    //DELETE THE BOOKING
    @FXML
    public void deleteTheBooking(ActionEvent e) throws IOException{
        int i = 0;
        Node temp = (Node) Main.bookingLinkedList.head;

        while (temp != null) {
            if (Integer.parseInt(bookingToDelete.getText()) == (((Booking) temp.getData()).getBookingId()))
            {
                Main.bookingLinkedList.delete(i);
                Scene newShowB = new Scene(FXMLLoader.load(getClass().getResource("../Customer/CurrentBooking.fxml")));
                Main.ps.setScene(newShowB);
                break;
            }
            else {
                temp = temp.next;
                i = i + 1;
            }
        }
    }

    //GO BACK
    @FXML
    private void goBack(ActionEvent e) throws IOException {
        Scene returnB = new Scene(FXMLLoader.load(getClass().getResource("../Login.fxml")));
        Main.ps.setScene(returnB);
    }

    //MAP
    @FXML
    private void goToMap(ActionEvent e) throws IOException {
        Scene maps = new Scene(FXMLLoader.load(getClass().getResource("../map.fxml")));
        Main.ps.setScene(maps);
    }
}
