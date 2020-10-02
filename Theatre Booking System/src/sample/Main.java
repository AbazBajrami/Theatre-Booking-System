package sample;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Customer.Booking;
import sample.Owner.Show;
import sample.Owner.LinkedList;
import sample.Owner.*;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;

public class Main extends Application {
    public static Stage ps;
    public static LinkedList<Show> showLinkedList = new LinkedList<>(); //List of Shows
    public static LinkedList<Performance> performanceLinkedList = new LinkedList<>(); //List of Performnaces
    public static LinkedList<Booking> bookingLinkedList = new LinkedList<>(); //List of Bookings

    //START METHOD
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../sample/map.fxml")); //Open Login Page
        primaryStage.setScene(new Scene(root)); //Set the Scene
        primaryStage.show(); //Show Scene
        ps = primaryStage;
    }


    //Main
    public static void main(String[] args)
    {
        launch(args);
    }

    //Save
    @SuppressWarnings("unchecked")
    public static void save() throws Exception
    {
        XStream xStream = new XStream(new DomDriver());

        //shows
        ObjectOutputStream out = xStream.createObjectOutputStream(new FileWriter("Shows.xml"));
        out.writeObject(showLinkedList);
        out.close();

        //performance
        out = xStream.createObjectOutputStream(new FileWriter("Performances.xml"));
        out.writeObject(performanceLinkedList);
        out.close();

        //bookings
        out = xStream.createObjectOutputStream(new FileWriter("Bookings.xml"));
        out.writeObject(bookingLinkedList);
        out.close();
    }

    //Load
    @SuppressWarnings("unchecked")
    public  static void load() throws Exception
    {
        XStream xStream = new XStream(new DomDriver());

        //shows
        ObjectInputStream is = xStream.createObjectInputStream(new FileReader("Shows.xml"));
        showLinkedList = (LinkedList<Show>) is.readObject();
        is.close();

        //performances
        is = xStream.createObjectInputStream(new FileReader("Performances.xml"));
        performanceLinkedList = (LinkedList<Performance>) is.readObject();
        is.close();

        //bookings
        is = xStream.createObjectInputStream(new FileReader("Bookings.xml"));
        bookingLinkedList = (LinkedList<Booking>) is.readObject();
        is.close();
    }

}
