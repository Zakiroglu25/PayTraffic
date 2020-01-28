package com.aris.paytraffic.helper;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public abstract class BaseAdapter<T extends RecyclerView.ViewHolder, K >
    extends RecyclerView.Adapter<T> {

  OnRecyclerItemClick<K> onRecyclerItemClick;
  OnRecyclerLongLick<K> onRecyclerLongLick;

  private List<K> childList;

  public BaseAdapter setData(List<K> dataList) {
    childList = dataList;
    notifyDataSetChanged();
    return this;
  }

  public BaseAdapter addDate(List<K> dataList){
    childList.addAll(dataList);
    notifyDataSetChanged();
    return this;
  }


  @Override public int getItemCount() {
    if (childList == null) {
      return 0;
    }
    return childList.size();
  }

  public List<K> getChildList() {
    return childList;
  }

  @Override public void onBindViewHolder(@NonNull T holder, int position) {
    if (onRecyclerItemClick != null) {
      holder.itemView.setOnClickListener(v -> onRecyclerItemClick.onClick((K) getItemOn(position)));
    }

    if (onRecyclerLongLick != null) {
      holder.itemView.setOnLongClickListener(
          v -> onRecyclerLongLick.onLongClick((K) getItemOn(position)));
    }
  }

  protected K getItemOn(int position) {
    if (childList == null) {
      return null;
    }
    return childList.get(position);
  }


  public BaseAdapter setOnRecyclerItemClick(OnRecyclerItemClick<K> onRecyclerItemClick) {
    this.onRecyclerItemClick = onRecyclerItemClick;
    return this;
  }

  public void setOnRecyclerLongLick(OnRecyclerLongLick<K> onRecyclerLongLick) {
    this.onRecyclerLongLick = onRecyclerLongLick;
  }

  public interface OnRecyclerItemClick<K> {
    void onClick(K o);
  }

  public interface OnRecyclerLongLick<K> {
    boolean onLongClick(K o);
  }
}
