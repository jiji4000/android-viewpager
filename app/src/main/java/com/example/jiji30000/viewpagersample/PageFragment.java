package com.example.jiji30000.viewpagersample;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PageFragment extends Fragment {
    private static final String TAG = PageFragment.class.getName();
    // スライド用の部品
    private ViewPager mPager;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView");
        View view = inflater.inflate(R.layout.viewpager_fragment, container, false);
        mPager = (ViewPager)view.findViewById(R.id.viewpager);
        mPager.setAdapter(new SampleFragmentPagerAdapter(getChildFragmentManager(),
                getContext()));

        // 上部にタブをセットする
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mPager);
        return view;
    }
}