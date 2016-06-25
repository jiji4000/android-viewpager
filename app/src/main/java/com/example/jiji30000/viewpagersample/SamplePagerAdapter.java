package com.example.jiji30000.viewpagersample;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class SamplePagerAdapter extends PagerAdapter{

    public static final int PAGE_COUNT = 3;
    private Context mContext;
    private static final int RES_IDS[] = new int[]{R.drawable.img1,R.drawable.img2,R.drawable.img3};

    SamplePagerAdapter(Context context){
        mContext = context;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
        //ViewPagerに登録していたViewを削除する
        collection.removeView((View)view);
    }
    @Override
    public Object instantiateItem(ViewGroup container,int position){
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(mContext.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.content_fragment_page,null);
        ImageView imageView = (ImageView)view.findViewById(R.id.main_image);
        imageView.setImageResource(RES_IDS[position]);
        container.addView(view);
        return view;
    }
}
