package com.aris.paytraffic.drawerMenu.addItem;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.aris.paytraffic.R;
import com.aris.paytraffic.drawerMenu.model.Item;

import java.util.List;

/**
 * Created by rafael.meyer on 8/24/16.
 */
public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ViewHolder> {

    public List<Item> items;
    public RecyclerViewOnClickListener myRecyclerViewOnClickListener;

    public class ViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener{
        public CardView cardViewItem;
        public TextView textViewName;
        public View viewColor;

        public ViewHolder(View itemView) {
            super(itemView);
            cardViewItem = (CardView)itemView.findViewById(R.id.cardViewItem);
            textViewName = (TextView)itemView.findViewById(R.id.nomeId);
            viewColor = itemView.findViewById(R.id.viewColor);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v)
        {
            if (myRecyclerViewOnClickListener != null) {
                Toast.makeText(itemView.getContext(), textViewName.getText(), Toast.LENGTH_SHORT).show();
                myRecyclerViewOnClickListener.onClickListener(v, getAdapterPosition());
            }
        }
    }

    public RVAdapter(List<Item> items) {
        this.items = items;
    }

    @Override
    public RVAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardviewitem, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textViewName.setText(items.get(position).getName());
        //int colorViewItem = Color.parseColor(items.get(position).getCard());
       // holder.viewColor.setBackgroundColor(colorViewItem);
    }

    @Override
    public int getItemCount() {
        if (items == null){
            return 0;
        }
        return items.size();
    }

    public interface RecyclerViewOnClickListener {
        void onClickListener(View view, int position);
    }

    public void setMyRecyclerViewOnClickListener(RecyclerViewOnClickListener myRecyclerViewOnClickListener) {
        this.myRecyclerViewOnClickListener = myRecyclerViewOnClickListener;
    }

}
