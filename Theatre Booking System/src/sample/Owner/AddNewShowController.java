package sample.Owner;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.Main;
import java.io.IOException;


public class AddNewShowController {
    //INSTANCES
    @FXML private TextField newShowTitle, newRunningTime, newStallPrice, newCirclePrice, newBalconyPrice;
    @FXML private DatePicker newStartDate, newEndDate;
    @FXML private Button addShow, returnButton, map;

    //NEW SHOW BUTTON
    public void addShowButtonPushed(ActionEvent e) throws IOException
    {
        //Add Show
        Main.showLinkedList.add(new Show(newShowTitle.getText(),
                newRunningTime.getText(),
                newStallPrice.getText(),
                newCirclePrice.getText(),
                newBalconyPrice.getText(),
                newStartDate.getValue(),
                newEndDate.getValue())
        );

        //Got to current shows
        Scene goToShows = new Scene(FXMLLoader.load(getClass().getResource("../Owner/Current Shows.fxml")));
        Main.ps.setScene(goToShows);
    }

    //GO BACK
    @FXML
    private void goBack(ActionEvent e) throws IOException {
        Scene returnB = new Scene(FXMLLoader.load(getClass().getResource("../Owner/Current Shows.fxml")));
        Main.ps.setScene(returnB);
    }

    //MAP
    @FXML
    private void goToMap(ActionEvent e) throws IOException {
        Scene mapping = new Scene(FXMLLoader.load(getClass().getResource("../map.fxml")));
        Main.ps.setScene(mapping);
    }


}
