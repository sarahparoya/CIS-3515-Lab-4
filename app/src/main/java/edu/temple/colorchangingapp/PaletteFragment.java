package edu.temple.colorchangingapp;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;


public class PaletteFragment extends Fragment {


    public PaletteFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View l =  inflater.inflate(R.layout.fragment_palette, container, false);

        Resources res = getResources();
        final String[] english = res.getStringArray(R.array.color_names);
        final String[] french = res.getStringArray(R.array.color_select);


        ColorAdapter colorAdapter = new ColorAdapter(getActivity(), english, french);

       // l.setBackgroundColor(Color.CYAN);
        GridView gridView = l.findViewById(R.id.gridView);
        gridView.setAdapter(colorAdapter);


        return l;


    }
}