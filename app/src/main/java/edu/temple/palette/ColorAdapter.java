package edu.temple.palette;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ColorAdapter extends BaseAdapter {

    Context context;
    String colors[];



    public ColorAdapter(Context applicationContext, String[] colors) {
        this.context = applicationContext;
        this.colors = colors;
    }

    @Override
    public int getCount() {
        return colors.length;
    }

    @Override
    public String getItem(int i) {
        return colors[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        TextView textView;

        if(view!=null && view instanceof TextView){
            textView = (TextView)view;
        }else{
            textView = new TextView(context);
        }

        String colorValue = colors[i];
        textView.setText(colorValue);
        textView.setBackgroundColor(Color.parseColor(colorValue));

        return textView;



    }
}
