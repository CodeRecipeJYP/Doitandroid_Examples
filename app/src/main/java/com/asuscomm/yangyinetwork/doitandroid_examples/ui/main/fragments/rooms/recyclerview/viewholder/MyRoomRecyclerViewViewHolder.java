package com.asuscomm.yangyinetwork.doitandroid_examples.ui.main.fragments.rooms.recyclerview.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.asuscomm.yangyinetwork.doitandroid_examples.R;
import com.asuscomm.yangyinetwork.doitandroid_examples.models.Room;

/**
 * Created by jaeyoung on 2017. 5. 28..
 */

public class MyRoomRecyclerViewViewHolder extends RecyclerView.ViewHolder {
    public final View mView;
    public final TextView mIdView;
    public final TextView mContentView;
    public Room mItem;

    public MyRoomRecyclerViewViewHolder(View view) {
        super(view);
        mView = view;
        mIdView = (TextView) view.findViewById(R.id.id);
        mContentView = (TextView) view.findViewById(R.id.content);
    }

    @Override
    public String toString() {
        return super.toString() + " '" + mContentView.getText() + "'";
    }
}