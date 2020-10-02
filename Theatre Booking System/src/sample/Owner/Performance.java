package sample.Owner;
import java.time.LocalDate;

public class Performance {
    //INSTANCES
    private String perfTitle, time;
    private LocalDate date;

    //CONSTRUCTOR
    public Performance(String perfTitle, String time, LocalDate date) {
        this.perfTitle = perfTitle;
        this.time = time;
        this.date = date;
    }

    //GETTERS AND SETTER
    //title
    public String getPerfTitle() {
        return perfTitle;
    }
    public void setPerfTitle(String perfTitle) {
        this.perfTitle = perfTitle;
    }

    // time
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }

    //date
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
}
