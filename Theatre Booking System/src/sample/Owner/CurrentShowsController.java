package sample.Owner;
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
import javafx.scene.control.cell.TextFieldTableCell;
import sample.Main;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class CurrentShowsController implements Initializable
{
    //BUTTONS
    @FXML private Button newShowButton, returnButton, deleteShow, map;
    @FXML private TextField showToDelete;
    @FXML private TableView<Show> tableView;
    @FXML public  TableColumn<Show, String> titleColumn, runningTimeColumn, stallPrice, circlePrice, balconyPrice;
    @FXML private TableColumn<Show, LocalDate> startDate, endDate;

    //ADD NEW SHOW BUTTON
    @FXML
    private void goToNewShow(ActionEvent e) throws IOException
    {
        Scene newShowB = new Scene(FXMLLoader.load(getClass().getResource("../Owner/Add New Show.fxml")));
        Main.ps.setScene(newShowB);
    }

    //DELETE
    @FXML
    private void deleteTheShow(ActionEvent e) throws IOException{
        int i = 0;
        Node temp = (Node) Main.showLinkedList.head;

        while (temp != null) {
            if (showToDelete.getText().equals(((Show) temp.getData()).getTitle()))
            {
                Main.showLinkedList.delete(i);
                Scene newShowB = new Scene(FXMLLoader.load(getClass().getResource("../Owner/Current Shows.fxml")));
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
    private void goBack(ActionEvent e) throws IOException
    {
        Scene returnB = new Scene(FXMLLoader.load(getClass().getResource("../Owner/OwnerLog.fxml")));
        Main.ps.setScene(returnB);
    }

    //INITIALIZE
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        //set up the columns in the table
        titleColumn.setCellValueFactory(new PropertyValueFactory<Show, String>("title"));
        runningTimeColumn.setCellValueFactory(new PropertyValueFactory<Show, String>("runningTime"));
        startDate.setCellValueFactory(new PropertyValueFactory<Show, LocalDate>("startDate"));
        endDate.setCellValueFactory(new PropertyValueFactory<Show, LocalDate>("endDate"));
        stallPrice.setCellValueFactory(new PropertyValueFactory<Show, String>("stallPrice"));
        circlePrice.setCellValueFactory(new PropertyValueFactory<Show, String>("circlePrice"));
        balconyPrice.setCellValueFactory(new PropertyValueFactory<Show, String>("balconyPrice"));

        Node temp = (Node) Main.showLinkedList.head;
        while(temp != null) {
            tableView.getItems().add((Show) temp.getData());
            temp = temp.next;
        }

        //EDIT TABLE CELLS
        tableView.setEditable(true);
        titleColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        runningTimeColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        stallPrice.setCellFactory(TextFieldTableCell.forTableColumn());
        circlePrice.setCellFactory(TextFieldTableCell.forTableColumn());
        balconyPrice.setCellFactory(TextFieldTableCell.forTableColumn());
    }

    //MAP
    @FXML
    private void goToMap(ActionEvent e) throws IOException {
        Scene mapping = new Scene(FXMLLoader.load(getClass().getResource("../map.fxml")));
        Main.ps.setScene(mapping);
    }
}





