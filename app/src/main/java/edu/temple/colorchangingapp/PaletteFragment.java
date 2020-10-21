package edu.temple.colorchangingapp;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;


public class PaletteFragment extends Fragment {


    View l;
    private static final String ANDROID_COLORS = "android_colors";
    private static final String COLOR_NAMES = "color_names";

    private String[] aColors;
    private String[] colorNames;

    OnColorSelectedListener mCallback;


    public PaletteFragment() {
        // Required empty public constructor
    }

    public static PaletteFragment newInstance(String[] androidColors, String[] colorNames) {

        PaletteFragment fragment = new PaletteFragment();
        Bundle args = new Bundle();


        args.putStringArray(ANDROID_COLORS, androidColors);
        args.putStringArray(COLOR_NAMES, colorNames);


        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {

            aColors = getArguments().getStringArray(ANDROID_COLORS);
            colorNames = getArguments().getStringArray(COLOR_NAMES);
        }
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        l =  inflater.inflate(R.layout.fragment_palette, container, false);

        Resources res = getResources();


        TextView textView = l.findViewById(R.id.textView);
        ColorAdapter colorAdapter = new ColorAdapter(getActivity(), aColors, colorNames);

       // l.setBackgroundColor(Color.CYAN);
        GridView gridView = l.findViewById(R.id.gridView);
        gridView.setAdapter(colorAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                mCallback.onColorSelected(position);
            }
        });
        return l;
    }

    public interface OnColorSelectedListener
    {
        void onColorSelected(int position);
    }
    public void onAttach(Context context) {
        super.onAttach(context);


        try {
            mCallback = (OnColorSelectedListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement OnColorSelectedListener");
        }
    }


}