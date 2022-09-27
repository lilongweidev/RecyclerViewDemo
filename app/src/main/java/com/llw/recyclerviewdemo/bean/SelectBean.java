package com.llw.recyclerviewdemo.bean;

public class SelectBean {

    private boolean select;
    private String content;

    public boolean isSelect() {
        return select;
    }

    public void setSelect(boolean select) {
        this.select = select;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public SelectBean(boolean select, String content) {
        this.select = select;
        this.content = content;
    }
}
