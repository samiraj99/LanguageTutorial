package com.foslipy.languagetutorial;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class BeginnersPagerAdapter extends FragmentPagerAdapter {

    final String[] tabs = {"Chapters", "Examples", "Tests"};

    public BeginnersPagerAdapter(FragmentManager fm) {

        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                BeginnersChapters chapters = new BeginnersChapters();
                return chapters;

            case 1:
                BeginnersExamples examples = new BeginnersExamples();
                return examples;

            case 2:
                BeginnersTests tests = new BeginnersTests();
                return tests;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabs[position];
    }
}
