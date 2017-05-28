package com.asuscomm.yangyinetwork.doitandroid_examples.ui.main.fragments.friends;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.asuscomm.yangyinetwork.doitandroid_examples.R;
import com.asuscomm.yangyinetwork.doitandroid_examples.models.dummy.DummyData;
import com.asuscomm.yangyinetwork.doitandroid_examples.ui.main.fragments.friends.recyclerview.MyFriendRecyclerViewAdapter;


public class FriendsFragment extends Fragment {
    MyFriendRecyclerViewAdapter adapter;

    public FriendsFragment() {
        // Required empty public constructor
    }

    public static FriendsFragment newInstance() {
        FriendsFragment fragment = new FriendsFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment_friends, container, false);
        RecyclerView friendsList = (RecyclerView) view.findViewById(R.id.recyclerView);
        friendsList.setLayoutManager(new GridLayoutManager(getContext(), 2));
        adapter = new MyFriendRecyclerViewAdapter(DummyData.getFriendsDummy());
        friendsList.setAdapter(adapter);
        // Inflate the layout for this fragment
        return view;
    }
}
