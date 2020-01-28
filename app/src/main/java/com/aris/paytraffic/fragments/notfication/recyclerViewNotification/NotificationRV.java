package com.aris.paytraffic.fragments.notfication.recyclerViewNotification;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.aris.paytraffic.R;
import com.aris.paytraffic.helper.BaseRecyclerVH;

public class NotificationRV extends BaseRecyclerVH {

    private static int layout = R.layout.notification_layout_row;



    private NotificationRV(@NonNull View itemView) {
        super(itemView);
    }

    public void build() {
    }


    public static NotificationRV create(ViewGroup parent) {
        return new NotificationRV(view(parent, layout));
    }
}
