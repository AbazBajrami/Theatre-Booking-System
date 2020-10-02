package sample.Customer;
import java.net.URL;
import java.util.Random;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import sample.Main;
import sample.Owner.Node;
import java.util.ResourceBundle;
import sample.Owner.Show;
import java.io.IOException;

public class AddABookingController implements Initializable
{
    //LIST
    ObservableList timeList = FXCollections.observableArrayList();

    //BUTTONS
    @FXML private TextField name;
    @FXML private Button addBooking, map, returnButton;
    @FXML private ComboBox<String> pickPerf, pickTime;
    @FXML private Text totalPrice, bookingID, stallPrice, circlePrice, balconyPrice;
    @FXML private TextField stall, circle, balcony;

    //INITIALIZE
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        pickPerfChoiceBox();
        pickTheTime();
        getRandomId();
    }

    //SHOW CHOICE BOX
    @FXML
    private void pickPerfChoiceBox()
    {
        int i = 0;
        Node temp = (Node) Main.showLinkedList.head;

        while (temp != null) { //goes through linked list and add the titles that are in the list to the combobox
            pickPerf.getItems().add(String.valueOf(Main.showLinkedList.getNode(i).getData().getTitle()));
            temp = temp.next;
            i = i + 1;
        }
    }

    //TIMES
    @FXML
    private void pickTheTime()
    {
        timeList.add("Matinee 2:00");
        timeList.add("Evening 6:00");
        pickTime.getItems().addAll(timeList);
    }

    //RANDOM
    private void getRandomId()
    {
        int i = 0;
        Node temp = (Node) Main.bookingLinkedList.head;

        Random random = new Random();
        int id = random.nextInt( 99999999);
        bookingID.setText(String.valueOf(id));

        while (temp != null)
        {
            if (Integer.parseInt(bookingID.getText()) == (Main.bookingLinkedList.getNode(i).getData().getBookingId()))
            {
                id = random.nextInt(99999999);
                bookingID.setText(String.valueOf(id));
                break;
            }
            temp = temp.next;
            i++;
        }
    }

    //ADD PRICES
    @FXML
    private void pickPerfPrice()
    {
        int i =0;
        Node temp = (Node) Main.showLinkedList.head;

        while(temp!=null)
        {
            if(pickPerf.getValue().equals(((Show) temp.getData()).getTitle()))
            {
                stallPrice.setText(((Show) temp.getData()).getStallPrice());
                circlePrice.setText(((Show) temp.getData()).getCirclePrice());
                balconyPrice.setText(((Show) temp.getData()).getBalconyPrice());
                break;
            }
        }
    }

    //STALL PRICE
    @FXML
    private void numberOfStalls()
    {
        Node temp = (Node) Main.showLinkedList.head;

        int numOfStalls = Integer.parseInt(stall.getText());
        int stallCost =Integer.parseInt(((Show) temp.getData()).getStallPrice());
        int totalCost = Integer.parseInt(totalPrice.getText());

        totalPrice.setText(String.valueOf((numOfStalls*stallCost) + totalCost));
    }

    //CIRCLE PRICE
    @FXML
    private void numberOfCircles()
    {
        Node temp = (Node) Main.showLinkedList.head;

        int numOfCircles = Integer.parseInt(circle.getText());
        int circleCost =Integer.parseInt(((Show) temp.getData()).getCirclePrice());
        int totalCost = Integer.parseInt(totalPrice.getText());

        totalPrice.setText(String.valueOf((numOfCircles*circleCost) + totalCost));
    }

    //BALCONY PRICE
    @FXML
    private void numberOfBalconys()
    {
        Node temp = (Node) Main.showLinkedList.head;

        int numOfBalconys = Integer.parseInt(balcony.getText());
        int balconyCost =Integer.parseInt(((Show) temp.getData()).getBalconyPrice());
        int totalCost = Integer.parseInt(totalPrice.getText());

        totalPrice.setText(String.valueOf((numOfBalconys*balconyCost) + totalCost));
    }

    //ADD BOOKING
    @FXML
    private void addABooking(ActionEvent e) throws IOException
    {
        int totalSeats = (Integer.parseInt(stall.getText()) + Integer.parseInt(circle.getText()) + Integer.parseInt(balcony.getText()));
        //Add booking
        Main.bookingLinkedList.add(new Booking(name.getText(),
                pickPerf.getValue(),
                pickTime.getValue(),
                totalSeats,
                Integer.parseInt(totalPrice.getText()),
                Integer.parseInt(bookingID.getText())));

        //Go to current bookings
        Scene goToCurrentBookings = new Scene(FXMLLoader.load(getClass().getResource("../Customer/CurrentBooking.fxml")));
        Main.ps.setScene(goToCurrentBookings);
    }

    //GO BACK
    @FXML
    private void goBack(ActionEvent e) throws IOException {
        Scene returnB = new Scene(FXMLLoader.load(getClass().getResource("../Customer/CurrentBooking.fxml")));
        Main.ps.setScene(returnB);
    }

    //MAP
    @FXML
    private void goToMap(ActionEvent e) throws IOException {
        Scene mapping = new Scene(FXMLLoader.load(getClass().getResource("../map.fxml")));
        Main.ps.setScene(mapping);
    }
}
