package hu.ulyssys.java.course.javaee.demo.jsf;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import javax.validation.constraints.Future;
import java.io.Serializable;
import java.util.Date;

@Named
@ViewScoped
public class CalendarView implements Serializable {

    @Future
    private Date date2;

    public Date getDate2() {
        return date2;
    }

    public void setDate2(Date date2) {
        this.date2 = date2;
    }
}
