package com.example.jiji30000.viewpagersample;

import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TabHost;

public class MainActivity extends AppCompatActivity implements FragmentTabHost.OnTabChangeListener{
    private static final String TAG = MainActivity.class.getName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // FragmentTabHostを取得する
        FragmentTabHost tabHost = (FragmentTabHost)findViewById(android.R.id.tabhost);
        tabHost.setup(this, getSupportFragmentManager(), R.id.container);

        TabHost.TabSpec tabSpec1, tabSpec2, tabSpec3;

        // タブ生成1
        tabSpec1 = tabHost.newTabSpec("tab1");
        tabSpec1.setIndicator("tab1");
        tabHost.addTab(tabSpec1, PageFragment.class, null);
        // タブ生成2
        tabSpec2 = tabHost.newTabSpec("tab2");
        tabSpec2.setIndicator("tab2");
        tabHost.addTab(tabSpec2, PageFragment2.class, null);
        // タブ生成3
        tabSpec3 = tabHost.newTabSpec("tab3");
        tabSpec3.setIndicator("tab3");
        tabHost.addTab(tabSpec3, PageFragment3.class, null);

        // リスナー登録
        tabHost.setOnTabChangedListener(this);
    }

    @Override
    public void onTabChanged(String tabId) {

    }
}