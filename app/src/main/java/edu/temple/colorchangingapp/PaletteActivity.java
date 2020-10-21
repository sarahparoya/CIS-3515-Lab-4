package edu.temple.colorchangingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.TextView;

public class PaletteActivity extends AppCompatActivity implements PaletteFragment.OnColorSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Main Activity");
        final String[] aColors = getResources().getStringArray(R.array.color_names);
        final String[] colorNames = getResources().getStringArray(R.array.color_select);

        PaletteFragment pf = PaletteFragment.newInstance(aColors, colorNames);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container_2, pf)
                .commit();

       /* PaletteFragment pf = new PaletteFragment();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        ft.add(R.id.container_2, pf).commit();*/

      /*  Resources res = getResources();
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
                Intent intent = new Intent(PaletteActivity.this, );
                //put string into the extra with the key: color
                intent.putExtra("color", (String) english[position]);
                TextView colorView = (TextView)view;
                intent.putExtra(getResources().getString(R.string.color_value), colorView.getText());
                //launch the intent
                startActivity(intent);
            }
        });*/
    }
    @Override
    public void onColorSelected(int position) {
        final String[] aColors = getResources().getStringArray(R.array.color_names);
        CanvasFragment canvasFragment = CanvasFragment.newInstance(aColors, position);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_2, canvasFragment)
                .addToBackStack(null)
                .commit();
    }
}