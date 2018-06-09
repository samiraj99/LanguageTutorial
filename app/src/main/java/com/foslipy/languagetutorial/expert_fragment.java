package com.foslipy.languagetutorial;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class expert_fragment extends Fragment {

    View view;
    TabLayout tabLayout;
    ViewPager viewPager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.expert_fragment_layout, container, false);


        viewPager = view.findViewById(R.id.expert_fragment_vp);
        viewPager.setAdapter(new ExpertPagerAdapter(getChildFragmentManager()));
        tabLayout = view.findViewById(R.id.expert_fragment_tl);
        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.setupWithViewPager(viewPager);
            }
        });

        return view;

    }
}
