package com.example.lessonproject.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lessonproject.R;
import com.example.lessonproject.adapters.CountriesAdapter;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //get intent data
        Intent intent = getIntent();
        String countryName = intent.getStringExtra("name");
        String continent = intent.getStringExtra("continent");
        String description = intent.getStringExtra("description");
        String countryImage = intent.getStringExtra("image");

        //now init views
        TextView countryNameTv = findViewById(R.id.country_name_tv_d);
        TextView continentTv = findViewById(R.id.continent_tv_d);
        TextView descriptionTv = findViewById(R.id.description_tv_d);
        ImageView imageView = findViewById(R.id.country_image_iv_d);

        //now set data
        countryNameTv.setText(countryName);
        continentTv.setText(continent);
        descriptionTv.setText(description);
        Glide.with(this).load(countryImage).into(imageView);

    }
}