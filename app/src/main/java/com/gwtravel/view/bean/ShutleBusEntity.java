package com.gwtravel.view.bean;

/**
 * Created by 一合鱼 on 2017,3,8,0008.
 */

public class ShutleBusEntity {


    public ShutleBusEntity(String startstation, String endstation, String starttime, String endtime) {
        this.startstation = startstation;
        this.endstation = endstation;
        this.starttime = starttime;
        this.endtime = endtime;
    }

    String startstation;
    String endstation;
    String starttime;
    String endtime;

    public String getStartstation() {
        return startstation;
    }

    public void setStartstation(String startstation) {
        this.startstation = startstation;
    }

    public String getEndstation() {
        return endstation;
    }

    public void setEndstation(String endstation) {
        this.endstation = endstation;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }
}
