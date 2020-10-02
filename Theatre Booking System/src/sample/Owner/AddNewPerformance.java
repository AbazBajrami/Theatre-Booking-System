package sample.Owner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import sample.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddNewPerformance implements Initializable
{
    //COMBOBOX LISTS
    ObservableList timeList = FXCollections.observableArrayList();

    //BUTTONS
    @FXML private Button addPerformanceButton, returnButton, map;
    @FXML private ComboBox<String> times, showChoice;
    @FXML private DatePicker pickDate;

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        addChoice();
        setTheTime();
    }

    //SHOW CHOICE BOX
    @FXML
    public void addChoice()
    {
        int i = 0;
        Node temp = (Node) Main.showLinkedList.head;

        while(temp != null)
        { //goes through linked list and add the titles that are in the list to the combobox
            showChoice.getItems().add(String.valueOf(Main.showLinkedList.getNode(i).getData().getTitle()));
            temp = temp.next;
            i = i+1;
        }
    }

    //TIMES
    @FXML
    public void setTheTime()
    {
        timeList.add("Matinee 2:00");
        timeList.add("Evening 6:00");
        times.getItems().addAll(timeList);
    }


    //NEW PERFORMANCE
    @FXML
    private void newPerformance(ActionEvent e) throws IOException
    {
        int i = 0;
        Node temp = (Node) Main.showLinkedList.head;

        //Add performance
        while (temp != null )
        {
            if (showChoice.getValue().equals( ((Show) temp.getData()).getTitle()))
            {
                if (pickDate.getValue().isBefore(((Show) temp.getData()).getStartDate()) || pickDate.getValue().isAfter(((Show) temp.getData()).getEndDate())) {
                    System.out.println("The performnace date must be a correct date");
                    break;
                }
                else
                {
                    Main.performanceLinkedList.add(new Performance(
                            showChoice.getValue(),
                            times.getValue(),
                            pickDate.getValue()));

                    //Go to current performance
                    Scene goToCP = new Scene(FXMLLoader.load(getClass().getResource("../Owner/Current Performance.fxml")));
                    Main.ps.setScene(goToCP);
                }
            }
            temp= temp.next;
            i++;
        }
    }

    //GO BACK
    @FXML
    private void goBack(ActionEvent e) throws IOException {
        Scene returnB = new Scene(FXMLLoader.load(getClass().getResource("../Owner/Current Performance.fxml")));
        Main.ps.setScene(returnB);
    }

    //MAP
    @FXML
    private void goToMap(ActionEvent e) throws IOException {
        Scene mapping = new Scene(FXMLLoader.load(getClass().getResource("../map.fxml")));
        Main.ps.setScene(mapping);
    }








}
