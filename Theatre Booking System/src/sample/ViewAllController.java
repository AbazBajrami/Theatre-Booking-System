package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.Customer.Booking;
import sample.Owner.Node;
import sample.Owner.Performance;
import sample.Owner.Show;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class ViewAllController implements Initializable
{
    //buttons
    @FXML private Button map;

    //shows
    @FXML private TableView<Show> tableView;
    @FXML private TableColumn<Show, LocalDate> startDate, endDate;
    @FXML private TableColumn<Show, String> titleColumn, runningTimeColumn, stallPrice, circlePrice, balconyPrice;

    //performances
    @FXML private TableView<Performance> tableViewPerformance;
    @FXML private TableColumn<Performance, String> titlePerfColumn, timeColumn;
    @FXML private TableColumn<Performance, LocalDate> dateColumn;

    //bookings
    @FXML private TableView<Booking> tableViewBooking;
    @FXML private TableColumn<Booking, String> name, bookingTitle, bookingTime, numberOfSeats, price, bookingID ;

    //INTITIALIZE
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        //shows
        titleColumn.setCellValueFactory(new PropertyValueFactory<Show, String>("title"));
        runningTimeColumn.setCellValueFactory(new PropertyValueFactory<Show, String>("runningTime"));
        startDate.setCellValueFactory(new PropertyValueFactory<Show, LocalDate>("startDate"));
        endDate.setCellValueFactory(new PropertyValueFactory<Show, LocalDate>("endDate"));
        stallPrice.setCellValueFactory(new PropertyValueFactory<Show, String>("stallPrice"));
        circlePrice.setCellValueFactory(new PropertyValueFactory<Show, String>("circlePrice"));
        balconyPrice.setCellValueFactory(new PropertyValueFactory<Show, String>("balconyPrice"));

        //performances
        titlePerfColumn.setCellValueFactory(new PropertyValueFactory<Performance, String>("perfTitle"));
        timeColumn.setCellValueFactory(new PropertyValueFactory<Performance, String>("time"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<Performance, LocalDate>("date"));

        //booking
        name.setCellValueFactory(new PropertyValueFactory<Booking, String>("name"));
        bookingTitle.setCellValueFactory(new PropertyValueFactory<Booking, String>("performanceChosen"));
        bookingTime.setCellValueFactory(new PropertyValueFactory<Booking, String>("time"));
        numberOfSeats.setCellValueFactory(new PropertyValueFactory<Booking, String>("numberOfSeats"));
        price.setCellValueFactory(new PropertyValueFactory<Booking, String>("price"));
        bookingID.setCellValueFactory(new PropertyValueFactory<Booking, String>("bookingId"));

        //load data

        //shows
        Node temp = (Node) Main.showLinkedList.head;
        while(temp != null) {
            tableView.getItems().add((Show) temp.getData());
            temp = temp.next;
        }

        //performances
        Node temp1 = (Node) Main.performanceLinkedList.head;
        while(temp1 != null) {
            tableViewPerformance.getItems().add((Performance) temp1.getData());
            temp1 = temp1.next;
        }

        //booking
        Node temp2 = (Node) Main.bookingLinkedList.head;
        while(temp2 != null) {
            tableViewBooking.getItems().add((Booking) temp2.getData());
            temp2 = temp2.next;
        }
    }

    //MAP
    @FXML
    private void goToMap(ActionEvent e) throws IOException {
        Scene mapping = new Scene(FXMLLoader.load(getClass().getResource("../sample/map.fxml")));
        Main.ps.setScene(mapping);
    }
}
