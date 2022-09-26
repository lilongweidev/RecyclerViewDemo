package com.llw.recyclerviewdemo.bean;

public class Message {

    private int type;
    private String content;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Message(int type, String content) {
        this.type = type;
        this.content = content;
    }
}
