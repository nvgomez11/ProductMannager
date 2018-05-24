package com.example.nelson.productmanager;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class Products extends AppCompatActivity {


    ArrayList<String> array_titles = new ArrayList<String>();
    ArrayList<String> array_descriptions = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        array_titles.add("Clavos");
        array_titles.add("Carbon");
        array_titles.add("Huevos");

        array_descriptions.add("De acero");
        array_descriptions.add("Traido de indonesia");
        array_descriptions.add("De gallina blanca");

        GridView gridView = findViewById(R.id.grid_view);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });



        GridAdapter adapter = new GridAdapter(this,array_titles,array_descriptions);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Products.this,"Selected item is: "+ array_titles.get(position),Toast.LENGTH_SHORT).show();
            }
        });
    }

}
