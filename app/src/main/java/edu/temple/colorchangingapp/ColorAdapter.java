package edu.temple.colorchangingapp;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import java.util.Locale;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class ColorAdapter extends BaseAdapter {
    String[] colors;
    Context context;
    String[] display;

    public ColorAdapter (Context context, String[] colors, String[] display){
        this.colors = colors;
        this.context = context;
        this.display = display;
        this.display = context.getResources().getStringArray(R.array.color_select);
    }

    @Override
    public int getCount() {
        return colors.length;
    }

    @Override
    public Object getItem(int position) {
        return colors[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        TextView textView = new TextView(context);
        textView.setText(display[position]);
        textView.setTextSize(20);
        textView.setHeight(125);
        textView.setWidth(250);
        textView.setBackgroundColor(Color.parseColor(colors[position]));
        return textView;

    }
}