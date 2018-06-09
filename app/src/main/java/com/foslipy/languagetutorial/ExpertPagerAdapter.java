package com.foslipy.languagetutorial;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ExpertPagerAdapter extends FragmentPagerAdapter {

    final String[] tabs = {"Chapters", "Examples", "Tests"};

    public ExpertPagerAdapter(FragmentManager fm) {

        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                ExpertChapters chapters = new ExpertChapters();
                return chapters;

            case 1:
                ExpertExamples examples = new ExpertExamples();
                return examples;

            case 2:
                ExpertTests tests = new ExpertTests();
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
