//package com.aris.paytraffic.adapter;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//
//import androidx.viewpager.widget.PagerAdapter;
//import androidx.viewpager.widget.ViewPager;
//
//import com.aris.paytraffic.R;
//
//public class ViewPagerAdapter extends PagerAdapter {
//    private Context context;
//    private LayoutInflater layoutInflater;
//    private Integer [] images = {R.drawable.qr_code,R.drawable.global,R.drawable.sports_car};
//
//    public ViewPagerAdapter(Context context) {
//        this.context = context;
//    }
//
//    @Override
//    public int getCount() {
//        return images.length;
//    }
//
//    @Override
//    public boolean isViewFromObject(View view, Object object) {
//        return view == object;
//    }
//
//    @Override
//    public Object instantiateItem(ViewGroup container, final int position) {
//
//        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        View view = layoutInflater.inflate(R.layout.custom_layout, null);
//        ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
//        imageView.setImageResource(images[position]);
//
//
//        ViewPager vp = (ViewPager) container;
//        vp.addView(view, 0);
//        return view;
//
//    }
//
//    @Override
//    public void destroyItem(ViewGroup container, int position, Object object) {
//
//        ViewPager vp = (ViewPager) container;
//        View view = (View) object;
//        vp.removeView(view);
//
//    }
//}
