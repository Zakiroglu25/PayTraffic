package com.aris.paytraffic.fragments.mainMenu.adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aris.paytraffic.fragments.mainMenu.recyclerviewHolders.AddShablon;
import com.aris.paytraffic.fragments.mainMenu.recyclerviewHolders.Shablon;
import com.aris.paytraffic.helper.BaseAdapter;

public class MainMenuAdapter extends BaseAdapter<RecyclerView.ViewHolder,Object> {
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        switch (ViewType.valueOf(viewType)){
            case ADDSHABLON:
                return AddShablon.create(parent);
            case SHABLON:
                return Shablon.create(parent);
                default:
                    throw new RuntimeException("Error");
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);

        switch (ViewType.valueOf(getItemViewType(position))){
            case ADDSHABLON:
                break;
            case SHABLON:
                break;

        }
    }

    @Override
    public int getItemViewType(int position) {
        Object o = getItemOn(position);
        if (o instanceof ViewType) {
            return ((ViewType) o).i;
        } else if (o instanceof AddShablon) {
            return ViewType.ADDSHABLON.i;
        } else if (o instanceof AddShablon) {
            return ViewType.SHABLON.i;
        }

        return super.getItemViewType(position);
    }
    public enum ViewType {
        ADDSHABLON(1),
        SHABLON(2);

        private int i;

        ViewType(int i) {
            this.i = i;
        }

        public static ViewType valueOf(int i) {
            for (ViewType type : ViewType.values()) {
                if (type.i == i)
                    return type;
            }
            return ViewType.ADDSHABLON;
        }
    }
}