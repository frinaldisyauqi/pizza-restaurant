package com.frinaldi.frizzarestaurant;

import static com.frinaldi.frizzarestaurant.R.drawable.*;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.Group;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Objects;

public class SecondActivity extends AppCompatActivity {

    TextView receiver_display_name;
    ImageView store_location;
    TextView store_name;
    String ciwalk = "Cihampelas Walk";
    String bip = "Bandung Indah Plaza";
    String mim = "Metro Indah Mall";
    Uri gmmIntentUri;
    Group location_maps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        receiver_display_name = findViewById(R.id.display_name_id);
        // create the get Intent object
        Intent userIntent = getIntent();
        // receive the value by getStringExtra() method and
        // key must be same which is send by first activity
        String display_name = userIntent.getStringExtra("display_name");
        // display the string into textView
        String default_text = receiver_display_name.getText().toString();
        receiver_display_name.setText(default_text + display_name);

        //Change Image By Location
        String receiver_store_name = userIntent.getStringExtra("store_location");
        store_location = findViewById(R.id.store_photos_id);
        store_name = findViewById(R.id.store_name_id);
        if (Objects.equals(receiver_store_name, ciwalk)) {
            store_location.setImageResource(R.drawable.ciwalk);
            store_name.setText(receiver_store_name);
            gmmIntentUri = Uri.parse("geo:-6.894848,107.6024238?z=10&q=ciwalk+lobby");
        } else if (Objects.equals(receiver_store_name, bip)) {
            store_location.setImageResource(R.drawable.bip);
            store_name.setText(receiver_store_name);
            gmmIntentUri = Uri.parse("geo:-6.9085914,107.6086126?z=10&q=bandung+indah+plaza");
        } else if (Objects.equals(receiver_store_name, mim)) {
            store_location.setImageResource(R.drawable.mim);
            store_name.setText(receiver_store_name);
            gmmIntentUri = Uri.parse("geo:-6.9421418,107.6565488?z=10&q=metro+indah+mall");
        }

        //Open Maps Location
        location_maps = findViewById(R.id.location_group_id);
        int[] refIds = location_maps.getReferencedIds();
        for (int id : refIds) {
            findViewById(id).setOnClickListener(v -> {
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            });
        }
    }
}