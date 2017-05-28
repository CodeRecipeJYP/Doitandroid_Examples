package com.asuscomm.yangyinetwork.doitandroid_examples.models.dummy;

import com.asuscomm.yangyinetwork.doitandroid_examples.models.Friend;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jaeyoung on 2017. 5. 28..
 */

public class DummyData {
    public static List<Friend> getFriendsDummy() {
        List<Friend> friends = new ArrayList();
        friends.add(new Friend("ㅇ"));
        friends.add(new Friend("ㅇ"));
        friends.add(new Friend("ㅇ"));

        return friends;
    }
}
