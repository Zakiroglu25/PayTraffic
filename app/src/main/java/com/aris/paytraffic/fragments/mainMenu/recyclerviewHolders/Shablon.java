package com.aris.paytraffic.fragments.mainMenu.recyclerviewHolders;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.aris.paytraffic.R;
import com.aris.paytraffic.helper.BaseRecyclerVH;

public class Shablon extends BaseRecyclerVH {

    private static int layout = R.layout.shablon_mainmenu_row;



    private Shablon(@NonNull View itemView) {
        super(itemView);
    }

    public void build() {
    }


    public static Shablon create(ViewGroup parent) {
        return new Shablon(view(parent, layout));
    }
}
