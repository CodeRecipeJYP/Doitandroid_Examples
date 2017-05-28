package com.asuscomm.yangyinetwork.doitandroid_examples.models;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Created by jaeyoung on 2017. 5. 28..
 */

public class Room {
    private int id;
    private List<Friend> friends;
    private String title;
    private Date createDate;
    private String imageUri;

    public Room() {
    }

    public Room(int id, List<Friend> friends, String title, Date createDate, String imageUri) {
        this.id = id;
        this.friends = friends;
        this.title = title;
        this.createDate = createDate;
        this.imageUri = imageUri;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Friend> getFriends() {
        return friends;
    }

    public void setFriends(List<Friend> friends) {
        this.friends = friends;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }
}
