package com.asuscomm.yangyinetwork.doitandroid_examples.ui.main.fragments.friends.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.asuscomm.yangyinetwork.doitandroid_examples.R;
import com.asuscomm.yangyinetwork.doitandroid_examples.models.Friend;
import com.asuscomm.yangyinetwork.doitandroid_examples.ui.main.fragments.friends.recyclerview.viewholder.MyFriendRecyclerViewViewHolder;

import java.util.List;

public class MyFriendRecyclerViewAdapter extends RecyclerView.Adapter<MyFriendRecyclerViewViewHolder> {

    private final List<Friend> mValues;

    public MyFriendRecyclerViewAdapter(List<Friend> items) {
        mValues = items;
    }

    @Override
    public MyFriendRecyclerViewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.main_item_room, parent, false);
        return new MyFriendRecyclerViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyFriendRecyclerViewViewHolder holder, int position) {
        Friend item = mValues.get(position);
        holder.mItem = item;
//        holder.mProfileIv.set
        holder.mNameView.setText(item.getName());
        holder.mStatueMsgView.setText(item.getStatusMsg());
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }
}
