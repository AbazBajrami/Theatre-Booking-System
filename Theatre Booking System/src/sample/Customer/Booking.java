package sample.Customer;
public class Booking
{
    private String name, performanceChosen, time;
    private int numberOfSeats, price, bookingId;

    public Booking(String name, String performanceChosen, String time, int numberOfSeats, int price, int bookingId)
    {
        this.name = name;
        this.performanceChosen = performanceChosen;
        this.time = time;
        this.numberOfSeats = numberOfSeats;
        this.price = price;
        this.bookingId = bookingId;
    }


    //GETTERS AND SETTER
    //name
    public String getName(){return name;}
    public void setName(String name){this.name = name;}

    //performance chosen
    public String getPerformanceChosen(){return performanceChosen; }
    public void setPerformanceChosen(String performanceChosen){this.performanceChosen = performanceChosen;}

    //time
    public String getTime(){return time;}
    public void setTime(String time){this.time = time;}

    //number of seats
    public int getNumberOfSeats(){return numberOfSeats;}
    public void setNumberOfSeats(int numberOfSeats){this.numberOfSeats = numberOfSeats;}

    //price
    public int getPrice(){return price;}
    public void setPrice(int price){this.price = price;}

    //booking id
    public int getBookingId(){return bookingId;}
    public void setBookingId(int bookingId){this.bookingId = bookingId;}
}
