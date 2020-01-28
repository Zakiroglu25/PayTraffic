package com.aris.paytraffic.fragments.mainMenu.recyclerviewHolders;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.aris.paytraffic.R;
import com.aris.paytraffic.helper.BaseRecyclerVH;

public class AddShablon extends BaseRecyclerVH {


    private static int layout = R.layout.add_shablon_row;



    private AddShablon(@NonNull View itemView) {
       super(itemView);
    }

    public void build() {
    }


    public static AddShablon create(ViewGroup parent) {
        return new AddShablon(view(parent, layout));
    }
}
