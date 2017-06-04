package com.asuscomm.yangyinetwork.doitandroid_examples.models;

/**
 * Created by jaeyoung on 2017. 5. 28..
 */

public class Chat {
    boolean isMine = false;
    String name;
    String content;

    public Chat(boolean isMine, String name, String content) {
        this.isMine = isMine;
        this.name = name;
        this.content = content;
    }

    public boolean isMine() {
        return isMine;
    }

    public void setMine(boolean mine) {
        isMine = mine;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
