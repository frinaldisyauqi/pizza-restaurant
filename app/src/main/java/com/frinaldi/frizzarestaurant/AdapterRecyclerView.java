package com.frinaldi.frizzarestaurant;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import androidx.constraintlayout.widget.Group;


public class AdapterRecyclerView extends RecyclerView.Adapter<AdapterRecyclerView.ViewHolder> {

    private String[] SubjectValues;
    private Context context;

    AdapterRecyclerView(Context context1, String[] SubjectValues1) {

        SubjectValues = SubjectValues1;
        context = context1;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        ImageView imageView;
        TextView descView;
        CardView menuCard;

        ViewHolder(View v) {

            super(v);

            textView = v.findViewById(R.id.menu_title_id);
            imageView = v.findViewById(R.id.display_picture_menu_id);
            descView = v.findViewById(R.id.menu_desc_id);
            menuCard = v.findViewById(R.id.card_menu_id);

        }
    }

    @NonNull
    @Override
    public AdapterRecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.menu_list, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.textView.setText(SubjectValues[position]);
        holder.menuCard.setOnClickListener(v -> {
            String str = holder.textView.getText().toString();
            // Create the Intent object of this class Context() to Second_activity class
            Intent menuIntent = new Intent(context.getApplicationContext(), MenuActivity.class);
            menuIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            // now by putExtra method put the value in key, value pair key is
            // menu_name by this key we will receive the value, and put the string
            menuIntent.putExtra("menu_name", str);
            // start the Intent
            context.startActivity(menuIntent);
        });


        if (SubjectValues[position].equals("Margherita Pizza")){
            holder.imageView.setImageResource(R.drawable.pizza_margherita);
            holder.descView.setText("Margherita Pizza is a typical Neapolitan pizza, made with San Marzano tomatoes, mozzarella cheese, fresh basil, salt, and extra-virgin olive oil");
        } else if (SubjectValues[position].equals("Smoked Salmon Pizza")){
            holder.imageView.setImageResource(R.drawable.pizza_smokedsalmon);
            holder.descView.setText("Pesketarian pizza option with beatifully smoked salmon that rich with umami.");
        } else if (SubjectValues[position].equals("Shrimp Pizza")){
            holder.imageView.setImageResource(R.drawable.pizza_shrimp);
            holder.descView.setText("Frutti di Mare is an Italian type of pizza that may be served with shrimp. Lack Cheese with the seafood being served atop a tomato sauce.");
        } else if (SubjectValues[position].equals("Pepperoni Pizza")){
            holder.imageView.setImageResource(R.drawable.pizza_pepperoni);
            holder.descView.setText("Pepperoni is an American variety of spicy salami made from cured pork and beef seasoned with paprika or other chili pepper.");
        }

//        int[] refIds = holder.menuGroup.getReferencedIds();
//        for (int id : refIds) {
//            holder.textView.findViewById(id).setOnClickListener(v -> {
//                String str = holder.textView.getText().toString();
//                // Create the Intent object of this class Context() to Second_activity class
//                Intent menuIntent = new Intent(context.getApplicationContext(), MenuActivity.class);
//                // now by putExtra method put the value in key, value pair key is
//                // menu_name by this key we will receive the value, and put the string
//                menuIntent.putExtra("menu_name", str);
//                // start the Intent
//                context.startActivity(menuIntent);
//            });
//        }
    }

    @Override
    public int getItemCount() {

        return SubjectValues.length;
    }
}