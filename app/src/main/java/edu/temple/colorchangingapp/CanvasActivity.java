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

        String color = receivedIntent.getStringExtra("color");

        String name = receivedIntent.getStringExtra(getResources().getString(R.string.color_value));



        final ConstraintLayout canvasConstraint = (ConstraintLayout) findViewById(R.id.textColor);


        canvasConstraint.setBackgroundColor(Color.parseColor((color)));

        TextView messageTextView = findViewById(R.id.textView);

        messageTextView.setText(name);





    }
}
