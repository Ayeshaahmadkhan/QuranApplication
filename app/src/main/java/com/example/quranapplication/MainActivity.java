package com.example.quranapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.view.ViewGroup;
import android.widget.TextView;
import android.content.res.Configuration;

import com.example.quranapplication.QuranText;
import com.example.quranapplication.QDH;

public class MainActivity extends AppCompatActivity {

    ListView surahListView;
    QDH ps;
    QuranText qd;

    private static final String SELECTED_SURAH_INDEX_KEY = "selectedSurahIndex";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        surahListView = findViewById(R.id.surahListView);
        ps = new QDH();
        qd = new QuranText();

        ArrayAdapter<String> surahAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_dropdown_item_1line,
                ps.englishSurahNames
        ) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                TextView textView = (TextView) super.getView(position, convertView, parent);
                String surahEnglish = ps.englishSurahNames[position];

                String surahText = surahEnglish;
                textView.setText(surahText);
                return textView;
            }
        };
        surahListView.setAdapter(surahAdapter);
        surahListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra(SELECTED_SURAH_INDEX_KEY, position);
                startActivity(intent);
            }
        });
    }
}
