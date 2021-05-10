package com.ssm.domain;

import java.io.Serializable;
import java.sql.Date;

public class Event implements Serializable {
    private Integer id;
    private String student_id;
    private String announcer;
    private Date date;
    private String event;
    private Integer done;
    private Integer out_in;
    private Double amount;
    private Integer type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getAnnouncer() {
        return announcer;
    }

    public void setAnnouncer(String announcer) {
        this.announcer = announcer;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public Integer getDone() {
        return done;
    }

    public void setDone(Integer done) {
        this.done = done;
    }

    public Integer getOut_in() {
        return out_in;
    }

    public void setOut_in(Integer out_in) {
        this.out_in = out_in;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", student_id='" + student_id + '\'' +
                ", announcer='" + announcer + '\'' +
                ", date=" + date +
                ", event='" + event + '\'' +
                ", done=" + done +
                ", out_in=" + out_in +
                ", amount=" + amount +
                ", type=" + type +
                '}';
    }
}
