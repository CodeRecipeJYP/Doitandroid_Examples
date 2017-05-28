package com.asuscomm.yangyinetwork.doitandroid_examples.models;

/**
 * Created by jaeyoung on 2017. 5. 28..
 */

public class Friend {
    private String name;
    private String imgUri;
    private String statusMsg;

    public Friend() {
    }

    public Friend(String name) {
        this(name, null,null);
    }

    public Friend(String name, String imgUri, String statusMsg) {
        this.name = name;
        this.imgUri = imgUri;
        this.statusMsg = statusMsg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgUri() {
        return imgUri;
    }

    public void setImgUri(String imgUri) {
        this.imgUri = imgUri;
    }

    public String getStatusMsg() {
        return statusMsg;
    }

    public void setStatusMsg(String statusMsg) {
        this.statusMsg = statusMsg;
    }
}
