package com.example.firestore;

public class Post {
    private String from;
    private String to;
    private String date;
    private String time;
    private String username;
    private String vehicle;
    private long oSlots;
    private long tSlots;
    private String text;
    private String desc;

    public Post() {
    }
    public Post(String from, String to, String date, String time, String username, String vehicle, long oSlots, long tSlots, String text,String desc) {
        this.from = from;
        this.to = to;
        this.date = date;
        this.time = time;
        this.username = username;
        this.vehicle = vehicle;
        this.oSlots = oSlots;
        this.tSlots = tSlots;
        this.text = text;
        this.desc = desc;
    }

    public long gettSlots() {
        return tSlots;
    }

    public void settSlots(long tSlots) {
        this.tSlots = tSlots;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public long getoSlots() {
        return oSlots;
    }

    public void setoSlots(long oSlots) {
        this.oSlots = oSlots;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
