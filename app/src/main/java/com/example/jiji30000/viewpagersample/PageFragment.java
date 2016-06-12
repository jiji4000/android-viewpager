package com.example.jiji30000.viewpagersample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class PageFragment extends Fragment {
    private static final String TAG = PageFragment.class.getName();
    // スライド用の部品
    private LoopViewPager mPager;
    private int mMargin;
    private LinearLayout mIndicatorLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView");
        View view = inflater.inflate(R.layout.viewpager_fragment, container, false);
        mPager = (LoopViewPager) view.findViewById(R.id.viewpager);
        mPager.setAdapter(new SamplePagerAdapter(getContext()));
        mPager.setCurrentItem(0);
        mPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Log.d(TAG, "onPageSelected = " + position);
                // indicator更新
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                layoutParams.setMargins(mMargin, 0, 0, 0);
                mIndicatorLayout.removeAllViews();
                for (int i = 0; i < SamplePagerAdapter.PAGE_COUNT; ++i) {
                    if (position == i) {
                        View indicatorOn = getActivity().getLayoutInflater().inflate(R.layout.indicator, null);
                        indicatorOn.setLayoutParams(layoutParams);
                        mIndicatorLayout.addView(indicatorOn, layoutParams);
                    } else {
                        View indicatorOff = getActivity().getLayoutInflater().inflate(R.layout.indicator_off, null);
                        indicatorOff.setLayoutParams(layoutParams);
                        mIndicatorLayout.addView(indicatorOff);
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        // indicator
        mIndicatorLayout = (LinearLayout) view.findViewById(R.id.indicators);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        mMargin = (int) (metrics.density * 4);
        layoutParams.setMargins(mMargin, 0, 0, 0);
        for (int i = 0; i < SamplePagerAdapter.PAGE_COUNT; ++i) {
            if (i == 0) {
                View indicatorOn = getActivity().getLayoutInflater().inflate(R.layout.indicator, null);
                indicatorOn.setLayoutParams(layoutParams);
                mIndicatorLayout.addView(indicatorOn, layoutParams);
            } else {
                View indicatorOff = getActivity().getLayoutInflater().inflate(R.layout.indicator_off, null);
                indicatorOff.setLayoutParams(layoutParams);
                mIndicatorLayout.addView(indicatorOff);
            }
        }
        return view;
    }
}