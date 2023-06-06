package com.example.quranapplication;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    TextView surahContentTextView;
    EditText searchAyahEditText;
    Button searchButton;
    QuranText qd;
    int selectedSurahIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        surahContentTextView = findViewById(R.id.surah_content_textview);
        searchAyahEditText = findViewById(R.id.search_edittext);
        searchButton = findViewById(R.id.goToAyatButton);
        qd = new QuranText();

        // Retrieve the selected Surah index from the intent
        selectedSurahIndex = getIntent().getIntExtra("selectedSurahIndex", 0);

        // Get the starting and ending ayah indices for the selected Surah
        int startAyahIndex = QDH.SSP[selectedSurahIndex];
        int endAyahIndex = startAyahIndex + QDH.surahAyatCount[selectedSurahIndex];

        // Get the Surah content based on the ayah indices
        String[] surahContentArray = qd.GetData(startAyahIndex-1, endAyahIndex);

        StringBuilder surahContentBuilder = new StringBuilder();
        for (String ayah : surahContentArray) {
            surahContentBuilder.append(ayah);
            surahContentBuilder.append("\n");
        }

        // Set the Surah content in the TextView
        surahContentTextView.setText(surahContentBuilder.toString());
        surahContentTextView.setMovementMethod(new ScrollingMovementMethod());

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchAyahNumber = searchAyahEditText.getText().toString().trim();
                if (!searchAyahNumber.isEmpty()) {
                    int ayahNumber = Integer.parseInt(searchAyahNumber);
                    if (ayahNumber >= 1 && ayahNumber <= surahContentArray.length) {
                        String searchedAyah = surahContentArray[ayahNumber];
                        surahContentTextView.setText(searchedAyah);
                    } else {
                        surahContentTextView.setText("Invalid Ayah Number");
                    }
                }
            }
        });
    }
}
