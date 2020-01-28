package com.aris.paytraffic.utils;

import android.content.Context;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Utils {

  public static void loadDefaultRecyclerConfg(RecyclerView recyclerView, Context context) {
    RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context);
    recyclerView.setLayoutManager(mLayoutManager);
    recyclerView.setItemAnimator(new DefaultItemAnimator());
  }

  public static int dpToPx(int dp, Context context) {
    float d = context.getResources().getDisplayMetrics().density;
    return (int) (dp * d);
  }
}
