package edu.temple.palette;

import android.content.Context;

import android.content.res.Resources;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import android.widget.Spinner;
import android.widget.Toast;

public class MasterFragment extends Fragment {

    Context parentContext;

    Spinner spinner;

    public MasterFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        this.parentContext = context;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_master, container, false);
        Resources res = parentContext.getResources();


        String[] colorsLanguage = res.getStringArray(R.array.colors);
        String[] colors = res.getStringArray(R.array.colorValues);
        ColorAdapter colorAdapter = new ColorAdapter(parentContext, colors, colorsLanguage);

        spinner = v.findViewById(R.id.spinner);

        spinner.setAdapter(colorAdapter);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            boolean justCreated = true;
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(justCreated) {
                    justCreated = false;
                }else{
                    String colorName =  parent.getItemAtPosition(position).toString();
                    ((GetColorInterface) parentContext).colorSelected(colorName);
                    spinner.setAdapter(null);

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(parentContext, "", Toast.LENGTH_SHORT).show();
            }
        });
        return v;
    }


    interface GetColorInterface{
        void colorSelected(String color);
    }

}
