package com.asuscomm.yangyinetwork.doitandroid_examples.ui.main.adapter.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.asuscomm.yangyinetwork.doitandroid_examples.R;

/**
 * Created by jaeyoung on 2017. 6. 4..
 */

public class ChatlistRecyclerViewHolder extends RecyclerView.ViewHolder {
    public View chatOthers;
    public TextView chatMine;
    public ImageButton othersPhoto;
    public TextView othersName, othersContent;

    public ChatlistRecyclerViewHolder(View itemView) {
        super(itemView);
        chatOthers = itemView.findViewById(R.id.chatitem_others);
        chatMine = (TextView)itemView.findViewById(R.id.chatitem_mine);

        othersPhoto = (ImageButton) chatOthers.findViewById(R.id.chatitem_imgbtn_photo);
        othersName = (TextView) chatOthers.findViewById(R.id.chatitem_tv_name);
        othersContent = (TextView) chatOthers.findViewById(R.id.chatitem_tv_content);
    }
}
