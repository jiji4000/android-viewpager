package com.example.jiji30000.viewpagersample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ContentFragment1 extends Fragment {
    private final static String TAG = ContentFragment1.class.getName();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG,"onCreateView");
        View view = inflater.inflate(R.layout.content_fragment_page, container, false);
        TextView textView = (TextView)view.findViewById(R.id.text);
        textView.setText("page1");
        return view;
    }

    @Override
    public void onResume(){
        Log.d(TAG,"onResume");
        super.onResume();
    }

    @Override
    public void onStop(){
        Log.d(TAG,"onStop");
        super.onStop();
    }

    @Override
    public void onDetach(){
        Log.d(TAG,"onDetach");
        super.onDetach();
    }
}