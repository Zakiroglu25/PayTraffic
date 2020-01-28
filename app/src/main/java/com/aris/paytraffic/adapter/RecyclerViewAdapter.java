package com.aris.paytraffic.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.aris.paytraffic.R;
import com.aris.paytraffic.activiy.KabelTv;
import com.aris.paytraffic.activiy.MobileOperator;
import com.aris.paytraffic.activiy.QrCodeActivity;
import com.aris.paytraffic.drawerMenu.model.Category;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private List<Category> CategoryList;

    //adapter constructor that takes list of animals to show it
    public RecyclerViewAdapter(List<Category> CategoryList) {
        this.CategoryList = CategoryList;
    }

    //creating each row by inflating (convert from XML to java ) the views and return a viewHolder object of this row
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_item, parent, false);

        return new ViewHolder(itemView);
    }

    //binding (Adding) data to views
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Category category = CategoryList.get(position);
        holder.categoryImageView.setImageResource(category.getImage());
        holder.categoryName.setText(category.getName());
    }

    //Return the number of items that recycler has to show is very important
    @Override
    public int getItemCount() {
        return CategoryList.size();
    }

    //viewHolder is just responsible on holding Views and linking it to its XML by findViewById() Fn
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView categoryImageView;
        TextView categoryName;
        ConstraintLayout container;

        public ViewHolder(View view) {
            super(view);
            container = view.findViewById(R.id.container);
            categoryImageView = view.findViewById(R.id.categoryImageView);
            categoryName = view.findViewById(R.id.categoryTextView);

            //Add the onClickListeners here in the ViewHolder constructor
            container.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (getAdapterPosition()) {
                        case 0:
                            Intent intent = new Intent(v.getContext(), QrCodeActivity.class);
                            v.getContext().startActivity(intent);
                            break;
                        case 1:
                            intent = new Intent(v.getContext(), MobileOperator.class);
                            v.getContext().startActivity(intent);
                            break;
                        case 2:
                            intent = new Intent(v.getContext(), KabelTv.class);
                            v.getContext().startActivity(intent);
                            break;
                    }
                }
            });

        }
    }
}
