package com.asuscomm.yangyinetwork.doitandroid_examples.ui.main.activities;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.asuscomm.yangyinetwork.doitandroid_examples.R;
import com.asuscomm.yangyinetwork.doitandroid_examples.models.Chat;
import com.asuscomm.yangyinetwork.doitandroid_examples.models.dummy.DummyData;
import com.asuscomm.yangyinetwork.doitandroid_examples.services.db.local.MySqliteOpenHeloper;
import com.asuscomm.yangyinetwork.doitandroid_examples.services.db.local.OrmHelper;
import com.asuscomm.yangyinetwork.doitandroid_examples.ui.main.adapter.ChatlistRecyclerViewAdapter;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ChatRoomActivity extends AppCompatActivity {
    private final String TAG = "jaeyoung/"+getClass().getSimpleName();
    private SQLiteDatabase db;
    private RecyclerView recylerView_chat;
    private ChatlistRecyclerViewAdapter adapter;
    private ConnectionSource connectionSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chatroom_activity);

        initView();
        initDB();
//        readDB();
    }

    private void initDB() {
        Log.d(TAG, "initDB: ");

        OrmHelper helper =
                new OrmHelper(this);
        RuntimeExceptionDao<Chat, Integer> chatDao = helper.getChatDao();

        List<Chat> list = chatDao.queryForAll();

        StringBuilder sb = new StringBuilder();
        sb.append("Found ").append(list.size()).append(" entries in DB in ").append("onCreate").append("()\n");


        // if we already have items in the database
        int simpleC = 1;
        for (Chat simple : list) {
            sb.append('#').append(simpleC).append(": ").append(simple).append('\n');
            simpleC++;
        }
        sb.append("------------------------------------------\n");
        sb.append("Deleted ids:");
        for (Chat chat : list) {
            chatDao.delete(chat);
            sb.append(' ').append(chat.getContent());
            Log.d(TAG, "initDB: deleting simple(" + chat.getContent() + ")");
            Log.d(TAG, "deleting simple(" + chat.getContent() + ")");
            simpleC++;
        }
        sb.append('\n');
        sb.append("------------------------------------------\n");

        int createNum;
        final int MAX_NUM_TO_CREATE = 10;
        do {
            createNum = new Random().nextInt(MAX_NUM_TO_CREATE) + 1;
        } while (createNum == list.size());
        sb.append("Creating ").append(createNum).append(" new entries:\n");
        for (int i = 0; i < createNum; i++) {
            // create a new simple object
            long millis = System.currentTimeMillis();
            Chat chat = new Chat(false, "JYP", "millis="+millis);
            // store it in the database
            chatDao.create(chat);
            Log.d(TAG, "created chat(" + chat.getContent()+ ")");
            // output it
            sb.append('#').append(i + 1).append(": ");
            sb.append(chat).append('\n');
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                // ignore
            }
        }

        Log.d(TAG, "Done with page at " + System.currentTimeMillis());
    }

    private void readDB() {
        Log.d(TAG, "readDB: ");
        String[] proj = {"name", "content", "ismine"};
        Cursor resultCursor = db.query("chat", proj, null, null, null, null, null); // args=null -> 다갖고오겠다
        List<Chat> chatlist = new ArrayList<>();
        boolean isMine = false;
        String name = null;
        String content = null;

        while(resultCursor.moveToNext()) {
            Log.d(TAG, "readDB: moveToNext");
            name = resultCursor.getString(0);
            content = resultCursor.getString(1);
            int isMineInt = resultCursor.getInt(2);
            if(isMineInt == 1) {
                isMine = true;
            } else {
                isMine = false;
            }
            chatlist.add(new Chat(isMine, name, content));
        }

        adapter.setChats(chatlist);
    }

    private void initView() {
        recylerView_chat = (RecyclerView) findViewById(R.id.chatroom_recyclerview_chatlist);
        recylerView_chat.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
        adapter = new ChatlistRecyclerViewAdapter(DummyData.getChatsDummy());
        recylerView_chat.setAdapter(adapter);
        Button sendBtn = (Button) findViewById(R.id.chatroom_inputbar_btn_send);
        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: ");
            }
        });
    }
}
