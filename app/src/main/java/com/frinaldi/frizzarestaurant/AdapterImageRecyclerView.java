package com.frinaldi.frizzarestaurant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Objects;

public class AdapterImageRecyclerView extends RecyclerView.Adapter<AdapterImageRecyclerView.ViewHolder> {

    private String[] SubjectValues;
    private Context context;

    AdapterImageRecyclerView(Context context1, String[] SubjectValues1) {

        SubjectValues = SubjectValues1;
        context = context1;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        de.hdodenhof.circleimageview.CircleImageView imageView;

        ViewHolder(View v) {

            super(v);

            imageView = v.findViewById(R.id.display_picture_menu_id);
        }
    }

    @NonNull
    @Override
    public AdapterImageRecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.menu_list, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (Objects.equals(SubjectValues[position], "Pepperoni Pizza")) {
            holder.imageView.setImageResource(R.drawable.pizza_pepperoni);
        } else if (Objects.equals(SubjectValues[position], "Shrimp Pizza")) {
            holder.imageView.setImageResource(R.drawable.pizza_shrimp);
        } else if (Objects.equals(SubjectValues[position], "Smoked Salmon Pizza")) {
            holder.imageView.setImageResource(R.drawable.pizza_smokedsalmon);
        } else if (Objects.equals(SubjectValues[position], "Margherita Pizza")) {
            holder.imageView.setImageResource(R.drawable.pizza_margherita);
        }

    }

    @Override
    public int getItemCount() {

        return SubjectValues.length;
    }
}