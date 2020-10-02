package sample.Owner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.Main;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class CurrentPerformanceController implements Initializable
{
    //LIST
    ObservableList list = FXCollections.observableArrayList(); //ComboBox list for the times

    //BUTTONS
    @FXML private Button newPerformanceButton, returnButton, deletePerformance, map;
    @FXML private DatePicker deleteDate;
    @FXML private ComboBox<String> deleteTime;
    @FXML private TextField performanceToDelete;
    @FXML private TableView<Performance> tableViewPerformance;
    @FXML private TableColumn<Performance, String> titleColumn, timeColumn;
    @FXML private TableColumn<Performance, LocalDate> dateColumn;

    //ADD NEW PERFORMANCE BUTTON
    @FXML
    private void goToNewPerformance(ActionEvent e) throws IOException {
        Scene newPerformanceB = new Scene(FXMLLoader.load(getClass().getResource("../Owner/Add New Performance.fxml")));
        Main.ps.setScene(newPerformanceB);
    }

    //DELETE
    @FXML
    private void deleteThePerformance(ActionEvent e) throws IOException{
        int i = 0;
        Node temp = (Node) Main.performanceLinkedList.head;

        while (temp != null) {
            if (performanceToDelete.getText().equals(((Performance) temp.getData()).getPerfTitle()) && deleteTime.getValue().toString().equals(((Performance) temp.getData()).getTime())
            && deleteDate.getValue().toString().equals(((Performance) temp.getData()).getDate().toString()))
            {
                Main.performanceLinkedList.delete(i);
                Scene newShowB = new Scene(FXMLLoader.load(getClass().getResource("../Owner/Current Performance.fxml")));
                Main.ps.setScene(newShowB);
                break;
            }
            else {
                temp = temp.next;
                i = i + 1;
            }

        }
    }

    //INITIALIZE
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        setTheTime();

        //set up the columns in the table
        titleColumn.setCellValueFactory(new PropertyValueFactory<Performance, String>("perfTitle"));
        timeColumn.setCellValueFactory(new PropertyValueFactory<Performance, String>("time"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<Performance, LocalDate>("date"));

        //Load Dummy Data
        Node temp = (Node) Main.performanceLinkedList.head;
        while(temp != null) {
            tableViewPerformance.getItems().add((Performance) temp.getData());
            temp = temp.next;
        }
    }

    //TIMES
    @FXML
    private void setTheTime()
    {
        list.add("Matinee 2:00");
        list.add("Evening 6:00");
        deleteTime.getItems().addAll(list);
    }

    //GO BACK
    @FXML
    private void goBack(ActionEvent e) throws IOException {
        Scene returnB = new Scene(FXMLLoader.load(getClass().getResource("../Owner/OwnerLog.fxml")));
        Main.ps.setScene(returnB);
    }

    //MAP
    @FXML
    private void goToMap(ActionEvent e) throws IOException {
        Scene mapping = new Scene(FXMLLoader.load(getClass().getResource("../map.fxml")));
        Main.ps.setScene(mapping);
    }

}
