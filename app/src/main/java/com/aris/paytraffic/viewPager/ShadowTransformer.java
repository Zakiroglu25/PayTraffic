package com.aris.paytraffic.viewPager;

import android.util.Log;
import android.view.View;

import androidx.viewpager.widget.ViewPager;


public class ShadowTransformer implements ViewPager.OnPageChangeListener, ViewPager.PageTransformer {

    private ViewPager mViewPager;
    private CardPagerAdapter mAdapter;
    private float mLastOffset;
    private boolean mScalingEnabled;

    public ShadowTransformer(ViewPager viewPager, CardPagerAdapter adapter) {
        mViewPager = viewPager;
        viewPager.addOnPageChangeListener(this);
        mAdapter = adapter;
    }


    @Override
    public void transformPage(View page, float position) {

    }

    private static final String TAG = "ShadowTransformer";

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        int realCurrentPosition;
        int nextPosition;
        float realOffset;
        boolean goingLeft = mLastOffset > positionOffset;
        // If we're going backwards, onPageScrolled receives the last position
        // instead of the current one
        if (goingLeft) {
            realCurrentPosition = position + 1;
            nextPosition = position;
            realOffset = 1 - positionOffset;
        } else {
            nextPosition = position + 1;
            realCurrentPosition = position;
            realOffset = positionOffset;
        }

        // Avoid crash on overscroll
        if (nextPosition > mAdapter.getCount() - 1
                || realCurrentPosition > mAdapter.getCount() - 1) {
            return;
        }

        View currentCard = mAdapter.getCardViewAt(realCurrentPosition);

        // This might be null if a fragment is being used
        // and the views weren't created yet
        if (currentCard != null) {
            Log.e(TAG, "onPageScrolled:  current" );
            currentCard.setScaleX((float) (1 + 0.1 * (1 - realOffset)));
            currentCard.setScaleY((float) (1 + 0.1 * (1 - realOffset)));
        }

        View nextCard = mAdapter.getCardViewAt(nextPosition);

        // We might be scrolling fast enough so that the next (or previous) card
        // was already destroyed or a fragment might not have been created yet
//        Log.e(TAG, "onPageScrolled: realoff= "+realOffset );
        if (nextCard != null) {
            Log.e(TAG, "onPageScrolled:  next" );

            nextCard.setScaleX((float) (1 + 0.1 * (realOffset)));
            nextCard.setScaleY((float) (1 + 0.1 * (realOffset)));
        }


        mLastOffset = positionOffset;
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
