package com.asuscomm.yangyinetwork.doitandroid_examples.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by jaeyoung on 2017. 5. 28..
 */

@DatabaseTable(tableName = "chats")
public class Chat {
    @DatabaseField(generatedId = true)
    int id;
    @DatabaseField
    boolean isMine = false;
    @DatabaseField
    String name;
    @DatabaseField
    String content;

    public Chat() {
    }

    public Chat(boolean isMine, String name, String content) {
        this.isMine = isMine;
        this.name = name;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
