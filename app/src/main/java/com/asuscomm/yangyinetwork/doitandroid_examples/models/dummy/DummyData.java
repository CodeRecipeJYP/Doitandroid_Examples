package com.asuscomm.yangyinetwork.doitandroid_examples.models.dummy;

import com.asuscomm.yangyinetwork.doitandroid_examples.models.Chat;
import com.asuscomm.yangyinetwork.doitandroid_examples.models.Friend;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jaeyoung on 2017. 5. 28..
 */

public class DummyData {
    public static List<Friend> getFriendsDummy() {
        List<Friend> friends = new ArrayList();
        friends.add(new Friend("ㅇ","ㅇㄹ", "ㅇㄹㅇ"));
        friends.add(new Friend("ㅇ","ㅇㄹ", "ㅇㅇ2"));
        friends.add(new Friend("ㅇ","ㅇㄹ", "ㅇㅇ4"));

        return friends;
    }

    public static List<Chat> getChatsDummy() {
        List<Chat> chats = new ArrayList<>();
        chats.add(new Chat(false, "김괴진", "hi"));
        chats.add(new Chat(true, null, "hi22"));
        chats.add(new Chat(false, "신중궈", "고기"));
        chats.add(new Chat(false, "신중궈", "사줄게"));

        return chats;
    }
}
