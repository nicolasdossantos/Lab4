package edu.temple.palette;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

public class CanvasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas_activity);

        Intent canvas = getIntent();
        String color = canvas.getStringExtra("color");
        findViewById(R.id.canvaslayout).setBackgroundColor(Color.parseColor(color));
        setTitle("Canvas");



    }
}
