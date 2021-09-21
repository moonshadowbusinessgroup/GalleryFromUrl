package com.hadimusthafa.galleryfromurl2;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import org.json.JSONArray;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    int mNumOfTabs;
    JSONArray ja_one, ja_two, ja_three, ja_four, ja_five;

    public ViewPagerAdapter(FragmentManager fm, int NumOfTabs, int behavior, JSONArray ja_one, JSONArray ja_two, JSONArray ja_three, JSONArray ja_four, JSONArray ja_five) {
        super(fm, behavior);
        this.mNumOfTabs = NumOfTabs;
        this.ja_one = ja_one;
        this.ja_two = ja_two;
        this.ja_three = ja_three;
        this.ja_four = ja_four;
        this.ja_five = ja_five;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new FragmentOne(ja_one);
            case 1:
                return new FragmentTwo(ja_two);
            case 2:
                return new FragmentThree(ja_three);
            case 3:
                return new FragmentFour(ja_four);
            case 4:
                return new FragmentFive(ja_five);
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}