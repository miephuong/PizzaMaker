package com.example.pizzamaker.SelectIngredients;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;

import com.example.pizzamaker.R;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{private ArrayList<Ingredients> ingredients;
    final private OnListItemClickListener listener;

    RecyclerViewAdapter(ArrayList<Ingredients> ingredients, OnListItemClickListener listener){
        this.ingredients = ingredients;
        this.listener = listener;
    }

    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.ingredient_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int position) {
        viewHolder.checkboxIngredients.setText(ingredients.get(position).getName());
        viewHolder.checkboxImage.setImageResource((ingredients.get(position).getIcon()));
        viewHolder.checkboxIngredients.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = viewHolder.getAdapterPosition();
                String n = ingredients.get(i).getName();
                Snackbar.make(v, n + " has been added to your order.", Snackbar.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return ingredients.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        CheckBox checkboxIngredients;
        ImageView checkboxImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            checkboxIngredients = itemView.findViewById(R.id.check_box);
            checkboxImage = itemView.findViewById(R.id.check_box_image);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listener.onListItemClick(getAdapterPosition());
        }
    }

    public interface OnListItemClickListener{
        void onListItemClick(int adapterPosition);
    }

}
