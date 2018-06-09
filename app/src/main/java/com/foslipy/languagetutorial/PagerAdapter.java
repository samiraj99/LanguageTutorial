package com.foslipy.languagetutorial;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.foslipy.languagetutorial.Chapters;
import com.foslipy.languagetutorial.Examples;
import com.foslipy.languagetutorial.Tests;

public class PagerAdapter extends FragmentStatePagerAdapter {


    int noOfTabs;

    public PagerAdapter(FragmentManager fm, int NumberOfTabs){

        super(fm);
        this.noOfTabs=NumberOfTabs;
    }



    @Override
    public Fragment getItem(int position) {

        switch (position)
        {
            case 0:
                Chapters chapters =new Chapters();
                return chapters;

            case 1:
                Examples examples=new Examples();
                return examples;

            case 2:
                Tests tests=new Tests();
                return tests;

        }

        return null;
    }

    @Override
    public int getCount() {
        return noOfTabs;
    }
}
