package com.frinaldi.frizzarestaurant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    TextView receiver_display_name;
    Context context;
    RecyclerView recyclerView;
    RecyclerView.Adapter recyclerViewAdapter;
    RecyclerView.LayoutManager recyclerViewLayoutManager;
    String[] subjects = {
            "Pepperoni Pizza", "Shrimp Pizza", "Smoked Salmon Pizza", "Margherita Pizza"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        receiver_display_name = findViewById(R.id.display_name_menu_id);
        // create the get Intent object
        Intent menuIntent = getIntent();
        // receive the value by getStringExtra() method and
        // key must be same which is send by first activity
        String display_name = menuIntent.getStringExtra("display_name");
        // display the string into textView
        String default_text = receiver_display_name.getText().toString();
        receiver_display_name.setText(default_text + display_name);

        //Recycler
        context = getApplicationContext();
        recyclerView = findViewById(R.id.recyclerView);
        recyclerViewLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(recyclerViewLayoutManager);
        recyclerViewAdapter = new AdapterRecyclerView(context, subjects,display_name);
        recyclerView.setAdapter(recyclerViewAdapter);
    }


}