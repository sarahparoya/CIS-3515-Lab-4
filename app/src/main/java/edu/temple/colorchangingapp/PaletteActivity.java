package edu.temple.colorchangingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Spinner;

public class PaletteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Palette Activity");


        Resources res = getResources();
        final String[] english = res.getStringArray(R.array.color_names);
        final String[] french = res.getStringArray(R.array.color_select);


        ColorAdapter colorAdapter = new ColorAdapter(this, english, french);

        //this is the gridView in the layout
        GridView gridView = findViewById(R.id.gridView);
        gridView.setAdapter(colorAdapter);

        //when item is clicked
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //create the intent
                Intent intent = new Intent(PaletteActivity.this, CanvasActivity.class);
                //put string into the extra with the key: color
                intent.putExtra("color", (String) english[position]);
                //launch the intent
                startActivity(intent);


            }
        });
    }
}