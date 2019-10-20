package edu.temple.palette;


import android.graphics.Color;
import android.os.Bundle;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;


import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;



/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {

    String colorName = "";
    FrameLayout detail;

    public static final String COLOR_KEY = "color_name";

    public DetailFragment() {
        // Required empty public constructor
    }

    public static DetailFragment newInstance (String colorName) {
        DetailFragment df = new DetailFragment();

        Bundle bundle = new Bundle();
        bundle.putString(COLOR_KEY, colorName);

        df.setArguments(bundle);


        return df;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null)
            colorName = getArguments().getString(COLOR_KEY);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_detail, container, false);

        changeColor(colorName);

        v.setBackgroundColor(Color.parseColor(colorName));


        return v;
    }

    public void changeColor(String color) {
        change(color);
    }

    private void change (String color) {
        colorName = color;

    }

}
