package com.asuscomm.yangyinetwork.doitandroid_examples.ui.main.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.asuscomm.yangyinetwork.doitandroid_examples.R;
import com.asuscomm.yangyinetwork.doitandroid_examples.models.Chat;
import com.asuscomm.yangyinetwork.doitandroid_examples.ui.main.adapter.viewholder.ChatlistRecyclerViewHolder;

import java.util.List;

/**
 * Created by jaeyoung on 2017. 6. 4..
 */

public class ChatlistRecyclerViewAdapter extends RecyclerView.Adapter<ChatlistRecyclerViewHolder> {
    private List<Chat> chats;
    LayoutInflater inflater;

    public ChatlistRecyclerViewAdapter(List<Chat> chats) {
        this.chats = chats;
    }

    @Override
    public ChatlistRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(inflater == null) {
            inflater = LayoutInflater.from(parent.getContext());
        }

        View view = inflater.inflate(R.layout.chatroom_item_chat, null);
        return new ChatlistRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ChatlistRecyclerViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return chats.size();
    }
}
