package com.gwtravel.view.bean;

/**
 * Created by 一合鱼 on 2017,3,10,0010.
 */

public class MsgEntity {

    String title;

    String content;

    String time;

    String type;

    public MsgEntity(String title, String content, String time, String type) {
        this.title = title;
        this.content = content;
        this.time = time;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
