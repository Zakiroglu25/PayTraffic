package com.aris.paytraffic.fragments.notfication.adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aris.paytraffic.fragments.mainMenu.recyclerviewHolders.AddShablon;
import com.aris.paytraffic.fragments.notfication.recyclerViewNotification.NotificationRV;
import com.aris.paytraffic.helper.BaseAdapter;

public class NotificationAdapter  extends BaseAdapter<RecyclerView.ViewHolder,Object> {

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        switch (NotificationAdapter.ViewType.valueOf(viewType)){
            case NOTIFICATION:
                return NotificationRV.create(parent);
            default:
                throw new RuntimeException("Error");
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);

        switch (NotificationAdapter.ViewType.valueOf(getItemViewType(position))){
            case NOTIFICATION:
                break;

        }
    }

    @Override
    public int getItemViewType(int position) {
        Object o = getItemOn(position);
        if (o instanceof NotificationAdapter.ViewType) {
            return ((NotificationAdapter.ViewType) o).i;
        } else if (o instanceof AddShablon) {
            return NotificationAdapter.ViewType.NOTIFICATION.i;
        } else if (o instanceof AddShablon) {
        }

        return super.getItemViewType(position);
    }
    public enum ViewType {
        NOTIFICATION(1);

        private int i;

        ViewType(int i) {
            this.i = i;
        }

        public static NotificationAdapter.ViewType valueOf(int i) {
            for (NotificationAdapter.ViewType type : NotificationAdapter.ViewType.values()) {
                if (type.i == i)
                    return type;
            }
            return NotificationAdapter.ViewType.NOTIFICATION;
        }
    }
}
