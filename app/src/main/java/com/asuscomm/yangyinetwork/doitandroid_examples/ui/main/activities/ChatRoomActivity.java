package com.asuscomm.yangyinetwork.doitandroid_examples.ui.main.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.asuscomm.yangyinetwork.doitandroid_examples.R;
import com.asuscomm.yangyinetwork.doitandroid_examples.models.dummy.DummyData;
import com.asuscomm.yangyinetwork.doitandroid_examples.ui.main.adapter.ChatlistRecyclerViewAdapter;

public class ChatRoomActivity extends AppCompatActivity {
    private final String TAG = "jaeyoung/"+getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chatroom_activity);

        initView();
    }

    private void initView() {
        RecyclerView chatlist = (RecyclerView) findViewById(R.id.chatroom_recyclerview_chatlist);
        chatlist.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
        ChatlistRecyclerViewAdapter adapter = new ChatlistRecyclerViewAdapter(DummyData.getChatsDummy());
        chatlist.setAdapter(adapter);
        Button sendBtn = (Button) findViewById(R.id.chatroom_inputbar_btn_send);
        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: ");
            }
        });
    }
}
