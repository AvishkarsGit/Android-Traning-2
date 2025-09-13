package com.avishkar.recyclerviewdemo;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.avishkar.recyclerviewdemo.adapter.CustomAdapter;
import com.avishkar.recyclerviewdemo.model.ItemsModel;

import java.util.ArrayList;
import java.util.Vector;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private ArrayList<ItemsModel> itemsList;

    private CustomAdapter adapter;
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


        //init comp
        initComp();

        //load data
        loadData();
    }

    private void initComp() {
        // init recycler view
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        itemsList = new ArrayList<>();
    }

    private void loadData() {
        ItemsModel model1 = new ItemsModel(R.drawable.pizza1,"Pizza","A cheesy flatbread topped with sauce, vegetables, and meats, baked to perfection","499");
        ItemsModel model2 = new ItemsModel(R.drawable.pizza2,"Pizza","A cheesy flatbread topped with sauce, vegetables, and meats, baked to perfection","499");
        ItemsModel model3 = new ItemsModel(R.drawable.burger1,"Burger","A juicy grilled patty served in a soft bun with lettuce, cheese, and sauces.","499");

        itemsList.add(model1);
        itemsList.add(model2);
        itemsList.add(model3);

        adapter = new CustomAdapter(MainActivity.this,itemsList);

        recyclerView.setAdapter(adapter);
    }
}