package com.frinaldi.frizzarestaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {
    TextView receiver_menu_name;
    ImageView menuImages;
    TextView menuDesc;
    TextView menuPrice;
    Button menuButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        receiver_menu_name = findViewById(R.id.menu_item_text);
        // create the get Intent object
        Intent userIntent = getIntent();
        // receive the value by getStringExtra() method and
        // key must be same which is send by first activity
        String display_name = userIntent.getStringExtra("display_name");
        String menu_name = userIntent.getStringExtra("menu_name");
        // display the string into textView
        receiver_menu_name.setText(menu_name);

        //Change Image
        menuImages = findViewById(R.id.menu_big_picture);
        menuDesc = findViewById(R.id.menu_item_desc);
        menuPrice = findViewById(R.id.menu_item_price);

        if (menu_name.equals("Margherita Pizza")){
            menuImages.setImageResource(R.drawable.pizza_margherita);
            menuDesc.setText(display_name);
            menuPrice.setText("Rp. 150.000,0");
        } else if (menu_name.equals("Smoked Salmon Pizza")){
            menuImages.setImageResource(R.drawable.pizza_smokedsalmon);
            menuDesc.setText(R.string.salmon_desc);
            menuPrice.setText("Rp. 120.000,0");
        } else if (menu_name.equals("Shrimp Pizza")){
            menuImages.setImageResource(R.drawable.pizza_shrimp);
            menuDesc.setText(R.string.shrimp_desc);
            menuPrice.setText("Rp. 170.000,0");
        } else if (menu_name.equals("Pepperoni Pizza")){
            menuImages.setImageResource(R.drawable.pizza_pepperoni);
            menuDesc.setText(R.string.pepperoni_desc);
            menuPrice.setText("Rp. 110.000,0");
        }

        menuButton = findViewById(R.id.menu_button_back);
        menuButton.setOnClickListener(
                v -> {
                    Intent i = new Intent(MenuActivity.this,ThirdActivity.class);
                    i.putExtra("display_name", display_name);
                    startActivity(i);
                }
        );
    }
}