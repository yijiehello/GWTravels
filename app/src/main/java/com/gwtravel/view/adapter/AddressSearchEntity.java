package com.gwtravel.view.adapter;

/**
 * Created by yiheyu on 2017/3/13.
 */

public class AddressSearchEntity {
    private int icon;
    private String address;

    public AddressSearchEntity(int icon, String address) {
        this.icon = icon;
        this.address = address;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
