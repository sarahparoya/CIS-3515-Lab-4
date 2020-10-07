package edu.temple.colorchangingapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class CanvasActivity extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);

        setTitle("Canvas Activity");

        final Intent receivedIntent = getIntent();
        textView = findViewById(R.id.textView);
        String name = receivedIntent.getStringExtra("name");

        textView.setText(name);
        ConstraintLayout constraintLayout = findViewById(R.id.textColor);
        constraintLayout.setBackgroundColor(Color.parseColor(getIntent().getStringExtra("color")));


    }
}
