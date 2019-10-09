package edu.temple.palette;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;


public class PaletteActivity extends AppCompatActivity {
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] colors = {"White", "Green", "Red", "Magenta", "Gray", "Cyan", "Black", "Blue", "Yellow", "Lime"};
        ColorAdapter colorAdapter = new ColorAdapter(PaletteActivity.this, colors);

        spinner = findViewById(R.id.spinner);

        spinner.setAdapter(colorAdapter);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            boolean justCreated = true;
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(justCreated) {
                    justCreated = false;
                }else{
                    Intent intent = new Intent(PaletteActivity.this, CanvasActivity.class);
                    intent.putExtra("color", parent.getItemAtPosition(position).toString());
                    startActivity(intent);
                    justCreated=false;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(PaletteActivity.this, R.string.test, Toast.LENGTH_SHORT).show();
            }
        });







    }
}
