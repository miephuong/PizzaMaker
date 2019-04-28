package com.example.pizzamaker.SelectPizza;

import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pizzamaker.R;

import java.util.ArrayList;

public class PizzaAdapter extends RecyclerView.Adapter<PizzaAdapter.ViewHolder> {
    private ArrayList<PizzaItem> pizzaItem;
    final private OnListItemClickListener pOnListItemClickListener;

    PizzaAdapter(ArrayList<PizzaItem> pizzas, OnListItemClickListener listener){
        pizzaItem = pizzas;
        pOnListItemClickListener = listener;
    }

    @Override
    public PizzaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.pizza_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PizzaAdapter.ViewHolder viewHolder, int position) {
        viewHolder.pizzaname.setText(pizzaItem.get(position).getName());
        viewHolder.pic.setImageResource(pizzaItem.get(position).getPicId());

    }

    @Override
    public int getItemCount() {
        return pizzaItem.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView pizzaname;
        ImageView pic;

        ViewHolder(View itemView){
            super(itemView);
            pizzaname = itemView.findViewById(R.id.tv_pizza);
            pic = itemView.findViewById(R.id.iv_pic);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            pOnListItemClickListener.onListItemClick(getAdapterPosition());
        }
    }

    public interface OnListItemClickListener{
        void onListItemClick(int clickedItemIndex);
    }
}
