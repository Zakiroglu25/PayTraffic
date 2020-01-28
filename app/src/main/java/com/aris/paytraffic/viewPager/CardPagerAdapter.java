package com.aris.paytraffic.viewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.viewpager.widget.PagerAdapter;

import com.aris.paytraffic.R;

import java.util.Arrays;
import java.util.List;

public class CardPagerAdapter extends PagerAdapter {

    private List<View> mViews;
    private List<String> mData;
    private float mBaseElevation;

    public CardPagerAdapter() {
        mData = Arrays.asList("","","","");
        mViews = Arrays.asList(null,null,null,null);

    }


    public float getBaseElevation() {
        return mBaseElevation;
    }

    public View getCardViewAt(int position) {
        return mViews.get(position);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext())
                .inflate(R.layout.viewpager_item, container, false);
        container.addView(view);
        bind(mData.get(position), view);
        mViews.set(position, view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
        mViews.set(position, null);
    }

    private void bind(String item, View view) {
//        TextView titleTextView = (TextView) view.findViewById(R.id.titleTextView);
//        TextView contentTextView = (TextView) view.findViewById(R.id.contentTextView);
//        titleTextView.setText(item.getTitle());
//        contentTextView.setText(item.getText());
    }

}
