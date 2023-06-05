package com.example.quranapplication;
package com.example.quranapplication.QDH;
import android.os.Bundle;
import android.view.View;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;



public class MainActivity extends AppCompatActivity {

   public ListView surahListView;

  public QDH qdh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the QDH class and get the list of Surah names
        qdh = new QDH();
        List<String> surahNames = qdh.GetSurahNames();

        // Initialize the ListView and set the adapter
        surahListView = findViewById(R.id.surahListView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, surahNames);
        surahListView.setAdapter(adapter);

        // Set click listener for the ListView items
        surahListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the selected Surah name
                String selectedSurah = surahNames.get(position);

                // Handle the click event, you can navigate to the specific Surah here
                Toast.makeText(MainActivity.this, "Selected Surah: " + selectedSurah, Toast.LENGTH_SHORT).show();
            }
        });
    }
}


