package com.asuscomm.yangyinetwork.doitandroid_examples.ui.main.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.asuscomm.yangyinetwork.doitandroid_examples.R;
import com.asuscomm.yangyinetwork.doitandroid_examples.models.dummy.DummyData;
import com.asuscomm.yangyinetwork.doitandroid_examples.ui.main.adapter.ChatlistRecyclerViewAdapter;

public class ChatRoomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chatroom_activity);

        RecyclerView chatlist = (RecyclerView) findViewById(R.id.chatroom_recyclerview_chatlist);
        chatlist.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
        ChatlistRecyclerViewAdapter adapter = new ChatlistRecyclerViewAdapter(DummyData.getChatsDummy());
        chatlist.setAdapter(adapter);
    }

}
