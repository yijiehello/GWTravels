package com.gwtravel.view.bean;

/**
 * Created by yiheyu on 2017/3/13.
 */

public class AddressEntity {

    public AddressEntity(int icon, String name, String address) {
        this.icon = icon;
        this.name = name;
        this.address = address;
    }

    private int icon;
    private String name;
    private String address;

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
