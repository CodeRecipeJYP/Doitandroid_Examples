package com.asuscomm.yangyinetwork.doitandroid_examples.ui.main.fragments.friends.recyclerview.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.asuscomm.yangyinetwork.doitandroid_examples.R;
import com.asuscomm.yangyinetwork.doitandroid_examples.models.Friend;
import com.asuscomm.yangyinetwork.doitandroid_examples.models.Room;

/**
 * Created by jaeyoung on 2017. 5. 28..
 */

public class MyFriendRecyclerViewViewHolder extends RecyclerView.ViewHolder {
    public final View mView;
    public final TextView mStatueMsgView;
    public final TextView mNameView;
    public final ImageView mProfileIv;
    public Friend mItem;

    public MyFriendRecyclerViewViewHolder(View view) {
        super(view);
        mView = view;
        mProfileIv = (ImageView) view.findViewById(R.id.profileIv);
        mStatueMsgView = (TextView) view.findViewById(R.id.statusTv);
        mNameView = (TextView) view.findViewById(R.id.nameTv);
    }

    @Override
    public String toString() {
        return super.toString() + " '" + mNameView.getText() + "'";
    }
}