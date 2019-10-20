package edu.temple.palette;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

public class MainActivity extends AppCompatActivity implements MasterFragment.GetColorInterface {

        DetailFragment df;
        FragmentManager fm;

        boolean singlePane;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            singlePane = findViewById(R.id.container_2) == null;
            df = new DetailFragment();


            fm = getSupportFragmentManager();

            fm.beginTransaction()
                    .replace(R.id.container_1, new MasterFragment())
                    .commit();

            if (!singlePane) {
                fm.beginTransaction()
                        .replace(R.id.container_2, df)
                        .commit();
            }

        }

        @Override
        public void colorSelected(String colorName) {


            if (singlePane) {

                DetailFragment newFragment = DetailFragment.newInstance(colorName);
                fm.beginTransaction()
                        .replace(R.id.container_1, newFragment)
                        .addToBackStack(null)
                        .commit();
            } else {
                df.changeColor(colorName);
            }
        }
    }
