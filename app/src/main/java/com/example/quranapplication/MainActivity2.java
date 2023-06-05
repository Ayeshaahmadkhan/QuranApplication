package com.example.quranapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView surahContentTextView;
    QuranText qd;
    int selectedSurahIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        surahContentTextView = findViewById(R.id.surah_content_textview);
        qd = new QuranText();

        // Retrieve the selected Surah index from the intent
        Intent intent = getIntent();
        selectedSurahIndex = intent.getIntExtra("selectedSurahIndex", 0);

        // Get the starting and ending ayah indices for the selected Surah
        int startAyahIndex = QDH.SSP[selectedSurahIndex];
        int endAyahIndex = startAyahIndex + QDH.surahAyatCount[selectedSurahIndex] - 1;


        // Get the Surah content based on the ayah indices
        String[] surahContentArray = qd.GetData(startAyahIndex, endAyahIndex);

        if (surahContentArray.length > 0) {
            StringBuilder surahContentBuilder = new StringBuilder();
            for (String ayah : surahContentArray) {
                surahContentBuilder.append(ayah);
                surahContentBuilder.append("\n");
            }
            String surahContent = surahContentBuilder.toString();
            surahContentTextView.setText(surahContent);
        } else {
            surahContentTextView.setText("Invalid Surah Index");
        }
    }
}
