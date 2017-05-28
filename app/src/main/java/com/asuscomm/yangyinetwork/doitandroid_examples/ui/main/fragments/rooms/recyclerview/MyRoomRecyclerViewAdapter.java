package com.asuscomm.yangyinetwork.doitandroid_examples.ui.main.fragments.rooms.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.asuscomm.yangyinetwork.doitandroid_examples.R;
import com.asuscomm.yangyinetwork.doitandroid_examples.models.Room;
import com.asuscomm.yangyinetwork.doitandroid_examples.ui.main.fragments.rooms.recyclerview.viewholder.MyRoomRecyclerViewViewHolder;

import java.util.List;

public class MyRoomRecyclerViewAdapter extends RecyclerView.Adapter<MyRoomRecyclerViewViewHolder> {

    private final List<Room> mValues;

    public MyRoomRecyclerViewAdapter(List<Room> items) {
        mValues = items;
    }

    @Override
    public MyRoomRecyclerViewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.main_item_room, parent, false);
        return new MyRoomRecyclerViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyRoomRecyclerViewViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(mValues.get(position).getId());
        holder.mContentView.setText(mValues.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }
}
