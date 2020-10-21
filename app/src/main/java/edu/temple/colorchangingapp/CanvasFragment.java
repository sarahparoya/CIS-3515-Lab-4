package edu.temple.colorchangingapp;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

public class CanvasFragment extends Fragment {

    private static final String ANDROID_COLORS = "android_colors";
    private static final String POSITION = "position";

    private static final String COLOR_VALUE = "color_select";


    private String[] androidColors;
    private int position;
    private String[] french;

    public CanvasFragment() {
        // Required empty public constructor
    }

    public static CanvasFragment newInstance(String[] androidColors, int position, String[] french) {
        CanvasFragment fragment = new CanvasFragment();
        Bundle args = new Bundle();
        args.putStringArray(ANDROID_COLORS, androidColors);
        args.putInt(POSITION, position);
        args.putStringArray(COLOR_VALUE, french);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            androidColors = getArguments().getStringArray(ANDROID_COLORS);
            position = getArguments().getInt(POSITION);
            french = getArguments().getStringArray(COLOR_VALUE);

        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View l = inflater.inflate(R.layout.fragment_canvas, container, false);

        FrameLayout frameLayout = l.findViewById(R.id.container_canvas);
        TextView colorName = l.findViewById(R.id.colorName);
        frameLayout.setBackgroundColor(Color.parseColor(androidColors[this.position]));

        colorName.setText(french[this.position]);

        return l;
    }

    public void onColorSelected(int position){
        this.position = position;
        updateBackgroundColor();
    }
    private void updateBackgroundColor(){
        FrameLayout frameLayout = getView().findViewById(R.id.container_canvas);
        frameLayout.setBackgroundColor(Color.parseColor(androidColors[this.position]));
    }
}
