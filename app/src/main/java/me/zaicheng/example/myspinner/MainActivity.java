package me.zaicheng.example.myspinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.Toolbar;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] items = new String[] {
                "item1",
                "item2",
                "item3"
        };

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        MySpinnerAdapter spinnerAdapter = new MySpinnerAdapter();
        spinnerAdapter.addItems(Arrays.asList(items));

        AppCompatSpinner spinner = (AppCompatSpinner) findViewById(R.id.spinner);

        if (spinner != null) {
            spinner.setAdapter(spinnerAdapter);
        }
    }
}
