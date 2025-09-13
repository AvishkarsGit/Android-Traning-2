package com.avishkar.listviewdemo;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private ListView listView;

//    private String names[] = new String[10];//array
    private ArrayList<String> developersList = new ArrayList<>();

    private ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        //init listview
        listView = findViewById(R.id.listView);

        loadData();


    }

    private void loadData() {

        developersList.add("Avishkar");
        developersList.add("Pooja");
        developersList.add("Sanika");
        developersList.add("Shrutika");
        developersList.add("Ankita");
        developersList.add("Sneha");

//        for (int i = 0; i<developersList.size();i++) {
//           Toast.makeText(MainActivity.this, ""+developersList.get(i), Toast.LENGTH_LONG).show();
//            Log.d("DATA", "names: "+developersList.get(i));
//        }

        adapter = new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,developersList);

        listView.setAdapter(adapter);
    }
}