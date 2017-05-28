package com.asuscomm.yangyinetwork.doitandroid_examples.ui.main.fragments.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.asuscomm.yangyinetwork.doitandroid_examples.ui.main.fragments.FriendsFragment;
import com.asuscomm.yangyinetwork.doitandroid_examples.ui.main.fragments.RoomsFragment;
import com.asuscomm.yangyinetwork.doitandroid_examples.ui.main.fragments.SettingsFragment;

/**
 * Created by jaeyoung on 2017. 5. 28..
 */

public class CustomFragmentPagerAdapter extends FragmentPagerAdapter {
    private final int NUMOFFRAGMENT = 3;
    private FriendsFragment friendsFragment = new FriendsFragment();
    private RoomsFragment roomsFragment = new RoomsFragment();
    private SettingsFragment settingsFragment = new SettingsFragment();

    public CustomFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        switch (position) {
            case 0:
                title = "Friends";
                break;
            case 1:
                title = "Rooms";
                break;
            case 2:
                title = "Settings";
                break;
        }
        return title;
    }


    @Override
    public Fragment getItem(int position) {
        Fragment item = null;
        switch (position) {
            case 0:
                item = friendsFragment;
                break;
            case 1:
                item = roomsFragment;
                break;
            case 2:
                item = settingsFragment;
                break;
        }
        return item;
    }

    @Override
    public int getCount() {
        return NUMOFFRAGMENT;
    }
}
