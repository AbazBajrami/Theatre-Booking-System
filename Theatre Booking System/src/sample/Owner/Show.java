package sample.Owner;
import java.time.LocalDate;

public class Show
{
    //INSTANCES
    private String title, runningTime, stallPrice, circlePrice, balconyPrice;
    private LocalDate startDate, endDate;

    //CONSTRUCTOR
    public Show(String title, String runningTime, String stallPrice, String circlePrice, String balconyPrice, LocalDate startDate, LocalDate endDate)
    {
        this.title = title;

        //Time can't be above 2 hours
        if(Integer.parseInt(runningTime) > 120 && Integer.parseInt(runningTime) <60)
        {
            System.out.println("Invalid Value. Must be below 120");
        }
        else
        {
            this.runningTime = runningTime;
        }

        this.stallPrice = stallPrice;
        this.circlePrice = circlePrice;
        this.balconyPrice = balconyPrice;

        if(startDate.isAfter(endDate) && endDate.isBefore(startDate))
        {
            System.out.println("Invalid Dates. Start date must be before end date and end date must be before start date");
        }
        else
        {
            this.startDate = startDate;
            this.endDate = endDate;
        }
    }

    //GETTERS AND SETTER
    //title
    public String getTitle(){return title;}
    public void setTitle(String title){this.title = title;}

    //running time
    public String getRunningTime() {return runningTime;}
    public void setRunningTime(String runningTime)
    {
        if(Integer.parseInt(runningTime) > 120 && Integer.parseInt(runningTime) <60)
        {
            System.out.println("Invalid Value. Must be below 120");
        }
        else
        {
            this.runningTime = runningTime;
        }
    }

    //stall price
    public String getStallPrice(){return stallPrice;}
    public void setStallPrice(String stallPrice){this.stallPrice = stallPrice;}

    //circle price
    public String getCirclePrice(){return circlePrice;}
    public void setCirclePrice(String circlePrice){this.circlePrice = circlePrice;}

    //balcony price
    public String getBalconyPrice(){return balconyPrice;}
    public void setBalconyPrice(String balconyPrice){this.balconyPrice = balconyPrice;}

    //start date
    public LocalDate getStartDate(){return startDate;}
    public void setStartDate(LocalDate startDate)
    {
        if(startDate.isAfter(endDate))
        {
            System.out.println("Invalid Dates. Start date must be before end date and end date must be before start date");
        }
        else
        {
            this.startDate = startDate;
        }
    }

    //end date
    public LocalDate getEndDate(){return endDate;}
    public void setEndDate(LocalDate endDate)
    {
        if(endDate.isBefore(startDate))
        {
            System.out.println("Invalid Dates. Start date must be before end date and end date must be before start date");
        }
        else
        {
            this.endDate = endDate;
        }
    }

}
