package beans;

import java.text.DateFormat;
import java.util.Date;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * Created by arpi on 31.10.2016.
 */
public class Event {
    private int id = new Random().nextInt(100);
    private String msg;
    private Date date;
    private DateFormat df;

    public Event(Date date, DateFormat df) {
        this.date = date;
        this.df = df;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", msg='" + msg + '\'' +
                ", date=" + df.format(date) +
                '}';
    }

}
