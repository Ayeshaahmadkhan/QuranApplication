package com.example.quranapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.TextView;


public class mainactivity3 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        TextView selectedAyatTextView = findViewById(R.id.selectedAyatTextView);
        String selectedAyat = getIntent().getStringExtra("selectedAyat");
        selectedAyatTextView.setText(selectedAyat);
    }
}


