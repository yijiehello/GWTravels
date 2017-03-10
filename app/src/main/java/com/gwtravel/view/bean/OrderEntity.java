package com.gwtravel.view.bean;

/**
 * Created by 一合鱼 on 2017,3,10,0010.
 */

public class OrderEntity {

    String type ;
    String stasue ;
    String time ;
    String day;
    String daynum;
    String sStation ;
    String eStation ;
    String price;
    String payed;
    String car;

    public OrderEntity(String type, String stasue, String sStation, String eStation, String car) {
        this.type = type;
        this.stasue = stasue;
        this.time = "9:30";
        this.day = "2017/02/29";
        this.daynum = "1";
        this.sStation = sStation;
        this.eStation = eStation;
        this.price = "$ 5.00";
        this.payed =  "1";
        this.car = car;
    }

    public OrderEntity(String type, String stasue, String sStation, String eStation, String price, String payed, String car) {
        this.type = type;
        this.stasue = stasue;
        this.time = "9:30";
        this.day = "2017/02/29";
        this.daynum = "1";
        this.sStation = sStation;
        this.eStation = eStation;
        this.price = price;
        this.payed = payed;
        this.car = car;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStasue() {
        return stasue;
    }

    public void setStasue(String stasue) {
        this.stasue = stasue;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDaynum() {
        return daynum;
    }

    public void setDaynum(String daynum) {
        this.daynum = daynum;
    }

    public String getsStation() {
        return sStation;
    }

    public void setsStation(String sStation) {
        this.sStation = sStation;
    }

    public String geteStation() {
        return eStation;
    }

    public void seteStation(String eStation) {
        this.eStation = eStation;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPayed() {
        return payed;
    }

    public void setPayed(String payed) {
        this.payed = payed;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }
}
