package com.example.lessonproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class TestMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_main);


        ImageButton button1 = findViewById(R.id.rightButton);

        ImageButton button2 = findViewById(R.id.rightButton1);

        ImageButton button3 = findViewById(R.id.rightButton2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TestMainActivity.this, "Button one", Toast.LENGTH_SHORT).show();

                button3.setVisibility(View.GONE);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TestMainActivity.this, "Button two", Toast.LENGTH_SHORT).show();
                button3.setVisibility(View.VISIBLE);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TestMainActivity.this, "Button three", Toast.LENGTH_SHORT).show();
            }
        });
    }
}