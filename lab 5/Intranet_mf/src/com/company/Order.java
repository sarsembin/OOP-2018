package com.company;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable {
    private String title;
    private String text;
    private Date date;
    private boolean isDone;

    public Order(String title, String text) {
        this.title = title;
        this.text = text;
        date = new Date();
        isDone = false;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public Date getDate() {
        return date;
    }

    public boolean getisDone() {
        return isDone;
    }

    public void setisDoneTrue() {
        this.isDone = true;
    }
}
