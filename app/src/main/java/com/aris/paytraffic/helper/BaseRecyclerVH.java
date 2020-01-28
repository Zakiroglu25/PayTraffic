package com.aris.paytraffic.helper;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public abstract class BaseRecyclerVH extends RecyclerView.ViewHolder {


  public BaseRecyclerVH(@NonNull View itemView) {
    super(itemView);
  }


  public static View view(ViewGroup parent,int layoutId){
    return  LayoutInflater
        .from(parent.getContext())
        .inflate(layoutId, parent, false);

  }




}
