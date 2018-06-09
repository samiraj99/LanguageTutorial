package com.foslipy.languagetutorial;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class AdvancedPagerAdapter extends FragmentPagerAdapter {

    final String[] tabs = {"Chapters", "Examples", "Tests"};

    public AdvancedPagerAdapter(FragmentManager fm) {

        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                AdvancedChapters chapters = new AdvancedChapters();
                return chapters;

            case 1:
                AdvancedExamples examples = new AdvancedExamples();
                return examples;

            case 2:
                AdvancedTests tests = new AdvancedTests();
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
